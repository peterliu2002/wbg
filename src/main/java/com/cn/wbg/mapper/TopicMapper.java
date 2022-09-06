package com.cn.wbg.mapper;

import com.cn.wbg.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @Entity com.cn.wbg.entity.Topic
*/
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {

    @Select("select * from topic where isdel = 0")
    List<Topic> selectall();
    /***
     * 添加话题
     * */
    Integer addtopic(Topic topic);
    /**
     *
     * 通过id获取话题
     * */
    Topic queryoneTopic(Integer topicid);
}
