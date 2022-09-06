package com.cn.wbg.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 主键id
     */
    private Integer userid;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 此数据是否删除0否1是
     */
    private Integer isdel;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String userpassword;

    /**
     * 用户性别  0 女 1 男 2保密 3多重性别
     */
    private String usersex;

    /**
     * 用户出生日期
     */
    private Date userbirth;

    /**
     * 用户地区
     */
    private String userlocalized;

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
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserpassword() == null ? other.getUserpassword() == null : this.getUserpassword().equals(other.getUserpassword()))
            && (this.getUsersex() == null ? other.getUsersex() == null : this.getUsersex().equals(other.getUsersex()))
            && (this.getUserbirth() == null ? other.getUserbirth() == null : this.getUserbirth().equals(other.getUserbirth()))
            && (this.getUserlocalized() == null ? other.getUserlocalized() == null : this.getUserlocalized().equals(other.getUserlocalized()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserpassword() == null) ? 0 : getUserpassword().hashCode());
        result = prime * result + ((getUsersex() == null) ? 0 : getUsersex().hashCode());
        result = prime * result + ((getUserbirth() == null) ? 0 : getUserbirth().hashCode());
        result = prime * result + ((getUserlocalized() == null) ? 0 : getUserlocalized().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", isdel=").append(isdel);
        sb.append(", username=").append(username);
        sb.append(", userpassword=").append(userpassword);
        sb.append(", usersex=").append(usersex);
        sb.append(", userbirth=").append(userbirth);
        sb.append(", userlocalized=").append(userlocalized);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}