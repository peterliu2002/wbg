package com.cn.wbg.service.impl;

import com.cn.wbg.entity.Comment;
import com.cn.wbg.mapper.BaseMapper;
import com.cn.wbg.service.CommentService;
import com.cn.wbg.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class CommentServiceImpl extends ServiceImpl<Comment>
implements CommentService{

    @Autowired
    CommentMapper commentMapper;

    @Override
    protected BaseMapper<Comment> baseMapper() {
        return commentMapper;
    }

    @Override
    public List<String> queryCidlist(Integer dbid,Integer topicid) {
        return commentMapper.queryCidlist(dbid,topicid);
    }

    @Override
    public String queryCidString(Integer dbid,Integer topicid) {
        return commentMapper.queryCidString(dbid,topicid);
    }

    @Override
    public Integer saveNewComment(Comment comment) {
        return commentMapper.saveNewComment(comment);
    }

    @Override
    public List<String> querycidlist(Integer topicid) {
        return commentMapper.querycidlist(topicid);
    }

    @Override
    public List<Comment> querycom(Integer topicid) {

        return commentMapper.querycom(topicid);
    }
}
