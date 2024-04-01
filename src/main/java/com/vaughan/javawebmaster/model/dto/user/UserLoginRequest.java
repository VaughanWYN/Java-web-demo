package com.vaughan.javawebmaster.model.dto.user;

import lombok.Data;

/**
 * 用户登陆请求
 */
@Data
public class UserLoginRequest {
    private static final long serialVersionUID = 3191241716373120793L;
    private String userAccount;
    private String userPassword;
}
