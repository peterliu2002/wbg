package com.cn.wbg.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    private Integer dbid;

    /**
     * 创建用户
     */
    private String createname;

    /**
     * 创建日期
     */
    private Date createdate;

    /**
     * 此数据是否删除0否1是
     */
    private String isdel;

    /**
     * 
     */
    private Integer topicid;

    /**
     * 本节点id
     */
    private String cid;

    /**
     * 父节点id
     */
    private String pid;

    /**
     * 评论内容
     */
    private String plnr;

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
        Comment other = (Comment) that;
        return (this.getDbid() == null ? other.getDbid() == null : this.getDbid().equals(other.getDbid()))
            && (this.getCreatename() == null ? other.getCreatename() == null : this.getCreatename().equals(other.getCreatename()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getTopicid() == null ? other.getTopicid() == null : this.getTopicid().equals(other.getTopicid()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPlnr() == null ? other.getPlnr() == null : this.getPlnr().equals(other.getPlnr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDbid() == null) ? 0 : getDbid().hashCode());
        result = prime * result + ((getCreatename() == null) ? 0 : getCreatename().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getTopicid() == null) ? 0 : getTopicid().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPlnr() == null) ? 0 : getPlnr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dbid=").append(dbid);
        sb.append(", createname=").append(createname);
        sb.append(", createdate=").append(createdate);
        sb.append(", isdel=").append(isdel);
        sb.append(", topicid=").append(topicid);
        sb.append(", cid=").append(cid);
        sb.append(", pid=").append(pid);
        sb.append(", plnr=").append(plnr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}