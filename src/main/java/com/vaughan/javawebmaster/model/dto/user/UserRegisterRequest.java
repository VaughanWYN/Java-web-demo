package com.vaughan.javawebmaster.model.dto.user;

import lombok.Data;

/**
 * 用户注册请求体
 * 写请求体是为了用请求体去代替大量的变量
 */
@Data
public class UserRegisterRequest {
    public static final long serivalVersionUID = 3191241716373120793L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
