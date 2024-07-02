package com.vaughan.javawebmaster.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vaughan.javawebmaster.model.dto.user.UserQueryRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.servlet.http.HttpServletRequest;

import com.vaughan.javawebmaster.model.entity.User;
import com.vaughan.javawebmaster.model.vo.LoginUserVO;
import com.vaughan.javawebmaster.model.vo.UserVO;

import java.util.List;

/**
 * @author wangyongning
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-02-02 11:58:10
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册接口/下面是接口传入参数
     *
     * @param userAccount
     * @param userPassword
     * @param userCheckPassword
     * @return 返回用户id
     */

    long userRegister(String userAccount, String userPassword, String userCheckPassword);

    /**
     * 用户登陆接口
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return 返回脱敏用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户登陆（微信开放平台）
     *
     * @param wxOAuth2UserInfo
     * @param request
     * @return 脱敏后的用户信息
     */
//    LoginUserVO userLoginByMpOpen(WxOAuth2UserInfo wxOAuth2UserInfo, HttpServletRequest request);


    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取当前登陆用户（允许未登陆）
     *
     * @param request
     * @return
     */
    User getLoinUserPermitNull(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User user);

    boolean userLogout(HttpServletRequest request);


    /**
     * 获取脱敏的已登陆用户信息
     *
     * @param user
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取脱敏用户信息
     *
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏的用户信息
     * @param userList
     * @return
     */
    List<UserVO> getUserVO(List<User> userList);

    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

}
