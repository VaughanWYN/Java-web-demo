package com.vaughan.javawebmaster.service;

import com.vaughan.javawebmaster.model.entity.User;
import com.vaughan.javawebmaster.model.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void userRegisterTest(){
        String userAccount = "Vaughan3";
        String userPassword = "2002101419";
        String checkPassword = "2002101419";
//
        long result = userService.userRegister(userAccount, userPassword, checkPassword);//        userAccount = "cau kai";
        assertTrue(result > 0 );



//        userPassword = "2002101410";
//        long result = userService.userRegister(userAccount, userPassword, checkPassword);
//        assertEquals (result > 0, result);




//        userPassword = "2002101411";
//        result = userService.userRegister(userAccount, userPassword, checkPassword);

//        result = userService.userRegister(userAccount, userPassword, checkPassword);
//        Assertions.assertEquals(-1, result);
//
//
//        userAccount = "wangyongning";
//        userPassword = "111111111";
//        checkPassword = "111111111";
//        result = userService.userRegister(userAccount, userPassword, checkPassword);
//        Assertions.assertEquals(-1, result);

    }

    @Test
    void getUserVO() {
        User wang = new User();
        wang.setUseraccount("29080876");
        wang.setElectricityid("100898210");
        wang.setElectricityusage(BigDecimal.valueOf(456.15));


    }


//    @Test
//    void getUserVO_NullUser() {
//        UserVO userVO = userService.getUserVO(null);
//
//        Assertions.assertNull(userVO, "当传入null用户时，getUserVO 应返回null");
//    }

    @Test
    void getUserVO_NonNullUser() {
        User user = new User();
        user.setUseraccount("29080876");
        user.setElectricityid("100898210");
        user.setElectricityusage(BigDecimal.valueOf(456.15));

        UserVO userVO = userService.getUserVO(user);

        Assertions.assertNotNull(userVO, "当传入非null用户时，getUserVO 不应返回null");
        Assertions.assertEquals(user.getUseraccount(), userVO.getUseraccount(), "UserVO 的用户账号应与 User 的相同");
        Assertions.assertEquals(user.getElectricityid(), userVO.getElectricityid(), "UserVO 的电力ID应与 User 的相同");
        Assertions.assertEquals(user.getElectricityusage(), userVO.getElectricityusage(), "UserVO 的电力使用量应与 User 的相同");
        // 可以继续添加其他属性的断言，根据具体需求验证复制的正确性
    }



}
