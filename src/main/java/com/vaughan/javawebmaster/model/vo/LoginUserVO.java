package com.vaughan.javawebmaster.model.vo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *已登录用户视图（脱敏）展现给用户可以看到的信息，同时避免展现用户的隐私数据
 * @author wangyongning
 */
@Data
public class LoginUserVO implements Serializable {
    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
