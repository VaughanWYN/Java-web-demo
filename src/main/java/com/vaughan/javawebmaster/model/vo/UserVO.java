package com.vaughan.javawebmaster.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    public Long id;
    public String useraccount; // 对应 User 类中的 userAccount 字段
    public String useravatar;
    public String userrole;
    public String realname; // 对应 User 类中的 realName 字段
    public String electricityid; // 对应 User 类中的 electricityId 字段
    public String phonenumber; // 对应 User 类中的 phoneNumber 字段
    public String address; // 对应 User 类中的 address 字段
    public String residentorcomp; // 对应 User 类中的 residentOrComp 字段
    public BigDecimal electricityusage; // 对应 User 类中的 electricityUsage 字段
    public Date updatetime; // 对应 User 类中的 updateTime 字段

    private static final long serialVersionUID = 1L;


}
