package com.cn.wbg.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName topic
 */
@Data
public class Topic implements Serializable {
    /**
     * 主键id
     */
    private Integer topicid;

    /**
     * 创建日期
     */
    private Date createdate;

    /**
     * 此数据是否删除0否1是
     */
    private String isdel;

    /**
     * 创建用户
     */
    private String createname;

    /**
     * 话题名称
     */
    private String topicname;

    /**
     * 是否公开0否1是
     */
    private String ispublic;

    /**
     * 话题内容
     */
    private String htnr;

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
        Topic other = (Topic) that;
        return (this.getTopicid() == null ? other.getTopicid() == null : this.getTopicid().equals(other.getTopicid()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getCreatename() == null ? other.getCreatename() == null : this.getCreatename().equals(other.getCreatename()))
            && (this.getTopicname() == null ? other.getTopicname() == null : this.getTopicname().equals(other.getTopicname()))
            && (this.getIspublic() == null ? other.getIspublic() == null : this.getIspublic().equals(other.getIspublic()))
            && (this.getHtnr() == null ? other.getHtnr() == null : this.getHtnr().equals(other.getHtnr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTopicid() == null) ? 0 : getTopicid().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreatename() == null) ? 0 : getCreatename().hashCode());
        result = prime * result + ((getTopicname() == null) ? 0 : getTopicname().hashCode());
        result = prime * result + ((getIspublic() == null) ? 0 : getIspublic().hashCode());
        result = prime * result + ((getHtnr() == null) ? 0 : getHtnr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topicid=").append(topicid);
        sb.append(", createdate=").append(createdate);
        sb.append(", isdel=").append(isdel);
        sb.append(", createname=").append(createname);
        sb.append(", topicname=").append(topicname);
        sb.append(", ispublic=").append(ispublic);
        sb.append(", htnr=").append(htnr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}