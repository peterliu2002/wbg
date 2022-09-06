package com.cn.wbg.service;

import com.cn.wbg.entity.Topic;

import java.util.List;

/**
*
*/
public interface TopicService extends IServive<Topic> {


    List<Topic> selectall();
    Integer addtopic(Topic topic);
    /**
     *
     * 通过id获取话题
     * */
    Topic queryoneTopic(Integer topicid);

}
