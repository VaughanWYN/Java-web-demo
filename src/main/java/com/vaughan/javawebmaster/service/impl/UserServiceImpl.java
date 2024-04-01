package com.vaughan.javawebmaster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vaughan.javawebmaster.common.ErrorCode;
import com.vaughan.javawebmaster.constant.CommonConstant;
import com.vaughan.javawebmaster.exception.BusinessException;
import com.vaughan.javawebmaster.model.dto.user.UserQueryRequest;
import com.vaughan.javawebmaster.model.entity.User;
import com.vaughan.javawebmaster.model.enums.UserRoleEnum;
import com.vaughan.javawebmaster.model.vo.LoginUserVO;
import com.vaughan.javawebmaster.model.vo.UserVO;
import com.vaughan.javawebmaster.service.UserService;
import com.vaughan.javawebmaster.mapper.UserMapper;
import com.vaughan.javawebmaster.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaughan.javawebmaster.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author wangyongning
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-02-02 11:58:10
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    /**
     * 盐值，混淆密码
     */
    private static final String SALT = "nahguaV";
    @Override
    public long userRegister(String userAccount, String userPassword, String userCheckPassword) {
        //避免使用过多的判断语句以及与或非
        if (StringUtils.isAnyBlank(userAccount, userPassword, userCheckPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");//判断输入参数是否为空
        }
        if (userAccount.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");//判断账号长度
        }
        if (userPassword.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码过短");//判断密码长度
        }
        if (!userPassword.equals(userCheckPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"两次输入的密码不一样");//判断密码和校验密码是否相同
        }
        synchronized (userAccount.intern()) {
            //账户不能重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userAccount", userAccount);
            long count = this.baseMapper.selectCount(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
            }
            //加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
            //插入数据
            User user = new User();
            user.setUseraccount(userAccount);
            user.setUserpassword(encryptPassword);
            boolean saveResult = this.save(user);
            if(!saveResult){
                throw new BusinessException(ErrorCode.SYSTEM_ERROR,"注册失败，数据库错误");
            }
            return user.getId();
        }

    }

    @Override
    public LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");//判断输入参数是否为空
        }
        if (userAccount.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号错误");//判断账号长度
        }
        if (userPassword.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码错误");//判断密码长度
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        //查询用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("UserPassword", encryptPassword);
        User user = this.baseMapper.selectOne(queryWrapper);
        //用户不存在
        if (user == null) {
            log.info("user login failed, userAccount annot match userPassword");
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        //记录用户的登录状态
        request.getSession().setAttribute(USER_LOGIN_STATE, user);
        return this.getLoginUserVO(user);//将用户信息脱敏后返回

    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        //先判断是否已登陆
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 从数据库查询（追求性能的话可以注释，直接走缓存）
        long userId = currentUser.getId();
        currentUser = this.getById(userId);
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return currentUser;
    }

    @Override
    public User getLoinUserPermitNull(HttpServletRequest request) {
        //先判断是否已登陆
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;//?
        if (currentUser == null || currentUser.getId() == null) {
            return null;
        }
        // 从数据库查询（追求性能的话可以注释，直接走缓存）
        long userId = currentUser.getId();
        return this.getById(userId);
    }

    @Override
    public boolean isAdmin(HttpServletRequest request) {
        //仅管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;//?
        return isAdmin(user);
    }

    @Override
    public boolean isAdmin(User user) {
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserrole());
    }

    @Override
    public boolean userLogout(HttpServletRequest request) {
        //首先检查用户是否处于已登录的状态，如果是未登陆则抛出异常
        if (request.getSession().getAttribute(USER_LOGIN_STATE) == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "未登录");
        }
        //最后都是移除登录态，使其变成未登录
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return true;
    }

    @Override
    public LoginUserVO getLoginUserVO(User user) {
        if (user == null) {
            return null;
        }
        LoginUserVO loginUserVO = new LoginUserVO();
        BeanUtils.copyProperties(user, loginUserVO);
        return loginUserVO;
    }

    @Override
    public UserVO getUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);//将user中的变量复制到userVO中去
        return userVO;
    }

    @Override
    public List<UserVO> getUserVO(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return new ArrayList<>();
        }
        return userList.stream().map(this::getUserVO).collect(Collectors.toList());
    }


    @Override
    public QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest) {
        if (userQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = userQueryRequest.getId();
        String unionId = userQueryRequest.getUnionId();
        String mpOpenId = userQueryRequest.getMpOpenId();
        String userName = userQueryRequest.getUserName();
        String userProfile = userQueryRequest.getUserProfile();
        String userRole = userQueryRequest.getUserRole();
        String sortField = userQueryRequest.getSortField();
        String sortOrder = userQueryRequest.getSortOrder();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.eq(StringUtils.isNotBlank(unionId), "unionId", unionId);
        queryWrapper.eq(StringUtils.isNotBlank(mpOpenId), "mpOpenId", mpOpenId);
        queryWrapper.eq(StringUtils.isNotBlank(userRole), "userRole", userRole);
        queryWrapper.like(StringUtils.isNotBlank(userProfile), "userProfile", userProfile);
        queryWrapper.like(StringUtils.isNotBlank(userName), "userName", userName);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}




