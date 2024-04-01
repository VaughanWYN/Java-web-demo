package com.vaughan.javawebmaster.mapper;
import java.util.Date;

import com.vaughan.javawebmaster.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert(){
        User user = new User();
        user.setId(1L);
        user.setUseraccount("2086959435");
        user.setUserpassword("dsasadsad");
        user.setUnionid("是小宁宁呀！");
        user.setMpopenid("dasadadasd");
        user.setUsername("王永宁");
        user.setUseravatar("dajdkshakdh");
        user.hashCode();

        userMapper.insert(user);
    }


    /**
     * 使用插件GenerateAllSetter
     * 鼠标点击对象user 按alt+enter/option+enter唤出
     */
    @Test
    void testInsert1(){
        User user = new User();
        user.setUseraccount("321");
        user.setUserpassword("321");
        user.setUnionid("321");
        user.setMpopenid("321");
        user.setUsername("xixi");
        user.setUseravatar("321321");
        user.setUserprofile("321321");
        user.setUserrole("1");
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        user.setIsdelete(0);

        userMapper.insert(user);

    }

    @Test
    void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println("user = " + user);
    }

    @Test
    void testQueryById(){
        List<User> users = userMapper.selectBatchIds((Arrays.asList(1L, 2L, 3L, 4L)));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById(){
        User user = new User();
        user.setId(6L);
        userMapper.updateById(user);
    }

    @Test
    void testDeleteUser(){
        userMapper.deleteById(4L);
    }


}
