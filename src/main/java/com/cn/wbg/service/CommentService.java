package com.cn.wbg.service;

import com.cn.wbg.entity.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public interface CommentService extends IServive<Comment> {


    /**
     *
     * 按照pid和topicid查询本话题评论
     *
     *
     * ***/
    List<String> querycidlist(Integer topicid);
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
}
