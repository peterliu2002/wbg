package com.cn.wbg.controller;

import com.cn.wbg.entity.Topic;
import com.cn.wbg.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author xiaoliu
 * @ClassName TopicController
 * @date 2022/8/2 15:44
 */
@Controller
public class TopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping("/totopic")
    public String totopic(ModelMap mm){
        mm.put("topic",topicService.selectall());
        return "user/topic";
    }
    @RequestMapping("/tocomments")
    public String tocomments(ModelMap mm){
        mm.put("topic",topicService.selectall());
        return "user/topic";
    }
    /**
     * 添加话题
     * */
    @RequestMapping("/addtopic")
    @ResponseBody
    public Integer addtopic(Authentication authentication,
                         @RequestParam("htnr") String htnr,
                         @RequestParam("htmc") String htmc,
                         @RequestParam("htqx") String htqx
                         ){
        Topic topic = new Topic();
        String name = authentication.getName();
        topic.setCreatename(name);
        topic.setCreatedate(new Date());
        topic.setHtnr(htnr);
        System.out.println(htqx);
        topic.setIspublic(htqx);
        topic.setTopicname(htmc);

        return topicService.addtopic(topic);
    }
}
