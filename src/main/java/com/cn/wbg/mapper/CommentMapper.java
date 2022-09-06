package com.cn.wbg.mapper;

import com.cn.wbg.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @Entity com.cn.wbg.entity.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 查询此话题全部评论
     * */
    List<Comment> querycom(Integer topicid);
    /**
     * dbid查本条评论cid
     * */
    String queryCidString(Integer dbid,Integer topicid);
    /**
     * dbid查本条评论cid下的全部评论
     * */
    List<String> queryCidlist(Integer dbid,Integer topicid);
    /**
     *
     * 保存新评论
     * */
    Integer saveNewComment(Comment comment);
    /**
     *
     * 按照pid和topicid查询本话题评论
     *
     *
     * ***/
    List<String> querycidlist(Integer topicid);
}
