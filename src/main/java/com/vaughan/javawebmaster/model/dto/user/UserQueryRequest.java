package com.vaughan.javawebmaster.model.dto.user;

import com.vaughan.javawebmaster.common.PageRequest;
import lombok.Data;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

import java.io.Serializable;

/**
 * 用户查询请求
 */
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    private Long id;
    private String unionId;
    private String mpOpenId;
    private String userName;
    private String userProfile;

    private String userRole;
    private static final long serialVersionUID = 1L;
}
