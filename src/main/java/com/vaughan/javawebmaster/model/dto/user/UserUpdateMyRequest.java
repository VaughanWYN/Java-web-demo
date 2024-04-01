package com.vaughan.javawebmaster.model.dto.user;

/**
 * 用户更新个人信息请求
 */
public class UserUpdateMyRequest {
    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    private static final long serialVersionUID = 1L;
}
