package com.cn.wbg.service.impl;

import com.cn.wbg.entity.Topic;
import com.cn.wbg.mapper.BaseMapper;
import com.cn.wbg.service.TopicService;
import com.cn.wbg.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TopicServiceImpl extends ServiceImpl<Topic>
implements TopicService{
    @Autowired
    private TopicMapper topicMapper;
    @Override
    protected BaseMapper<Topic> baseMapper() {
        return null;
    }

    @Override
    public Integer addtopic(Topic topic) {
        return topicMapper.addtopic(topic);
    }

    /**
     * 获取所有话题
     * */
    @Override
    public List<Topic> selectall() {

        return topicMapper.selectall();
    }

    @Override
    public Topic queryoneTopic(Integer topicid) {
        return topicMapper.queryoneTopic(topicid);
    }
}
