package com.vaughan.javawebmaster.service;

import com.vaughan.javawebmaster.exception.BusinessException;
import com.vaughan.javawebmaster.mapper.UserMapper;
import com.vaughan.javawebmaster.model.entity.User;
import com.vaughan.javawebmaster.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * 用户服务测试
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void userRegisterTest(){
        String userAccount = "Vaughan1";
        String userPassword = "2002101419";
        String checkPassword = "2002101410";
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




}
