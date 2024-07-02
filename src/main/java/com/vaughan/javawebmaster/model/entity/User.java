package com.vaughan.javawebmaster.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名（实名）
     */
    @TableField(value = "realName")
    private String realname;

    /**
     * 用电户号
     */
    @TableField(value = "electricityId")
    private String electricityid;

    /**
     * 手机号
     */
    @TableField(value = "phoneNumber")
    private String phonenumber;

    /**
     * 账号
     */
    @TableField(value = "userAccount")
    private String useraccount;

    /**
     * 密码
     */
    @TableField(value = "userPassword")
    private String userpassword;

    /**
     * 用户头像
     */
    @TableField(value = "userAvatar")
    private String useravatar;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 居民/企事业
     */
    @TableField(value = "residentOrComp")
    private String residentorcomp;

    /**
     * 是否管理员：0-否，1-是
     */
    @TableField(value = "isAdmin")
    private Integer isadmin;

    /**
     * 账户是否有效：0-无效，1-有效
     */
    @TableField(value = "isValid")
    private Integer isvalid;

    /**
     * 身份证
     */
    @TableField(value = "idCard")
    private String idcard;

    /**
     * 当月用电量
     */
    @TableField(value = "electricityUsage")
    private BigDecimal electricityusage;

    /**
     * 微信开放平台id
     */
    @TableField(value = "unionId")
    private String unionid;

    /**
     * 公众号openId
     */
    @TableField(value = "mpOpenId")
    private String mpopenid;

    /**
     * 用户角色：user/admin/ban
     */
    @TableField(value = "userRole")
    private String userrole;

    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    private Integer isdelete;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getElectricityid() == null ? other.getElectricityid() == null : this.getElectricityid().equals(other.getElectricityid()))
            && (this.getPhonenumber() == null ? other.getPhonenumber() == null : this.getPhonenumber().equals(other.getPhonenumber()))
            && (this.getUseraccount() == null ? other.getUseraccount() == null : this.getUseraccount().equals(other.getUseraccount()))
            && (this.getUserpassword() == null ? other.getUserpassword() == null : this.getUserpassword().equals(other.getUserpassword()))
            && (this.getUseravatar() == null ? other.getUseravatar() == null : this.getUseravatar().equals(other.getUseravatar()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getResidentorcomp() == null ? other.getResidentorcomp() == null : this.getResidentorcomp().equals(other.getResidentorcomp()))
            && (this.getIsadmin() == null ? other.getIsadmin() == null : this.getIsadmin().equals(other.getIsadmin()))
            && (this.getIsvalid() == null ? other.getIsvalid() == null : this.getIsvalid().equals(other.getIsvalid()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getElectricityusage() == null ? other.getElectricityusage() == null : this.getElectricityusage().equals(other.getElectricityusage()))
            && (this.getUnionid() == null ? other.getUnionid() == null : this.getUnionid().equals(other.getUnionid()))
            && (this.getMpopenid() == null ? other.getMpopenid() == null : this.getMpopenid().equals(other.getMpopenid()))
            && (this.getUserrole() == null ? other.getUserrole() == null : this.getUserrole().equals(other.getUserrole()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getElectricityid() == null) ? 0 : getElectricityid().hashCode());
        result = prime * result + ((getPhonenumber() == null) ? 0 : getPhonenumber().hashCode());
        result = prime * result + ((getUseraccount() == null) ? 0 : getUseraccount().hashCode());
        result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
        result = prime * result + ((getUseravatar() == null) ? 0 : getUseravatar().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getResidentorcomp() == null) ? 0 : getResidentorcomp().hashCode());
        result = prime * result + ((getIsadmin() == null) ? 0 : getIsadmin().hashCode());
        result = prime * result + ((getIsvalid() == null) ? 0 : getIsvalid().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getElectricityusage() == null) ? 0 : getElectricityusage().hashCode());
        result = prime * result + ((getUnionid() == null) ? 0 : getUnionid().hashCode());
        result = prime * result + ((getMpopenid() == null) ? 0 : getMpopenid().hashCode());
        result = prime * result + ((getUserrole() == null) ? 0 : getUserrole().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", realname=").append(realname);
        sb.append(", electricityid=").append(electricityid);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", useraccount=").append(useraccount);
        sb.append(", userpassword=").append(userpassword);
        sb.append(", useravatar=").append(useravatar);
        sb.append(", address=").append(address);
        sb.append(", residentorcomp=").append(residentorcomp);
        sb.append(", isadmin=").append(isadmin);
        sb.append(", isvalid=").append(isvalid);
        sb.append(", idcard=").append(idcard);
        sb.append(", electricityusage=").append(electricityusage);
        sb.append(", unionid=").append(unionid);
        sb.append(", mpopenid=").append(mpopenid);
        sb.append(", userrole=").append(userrole);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}