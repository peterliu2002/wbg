package com.cn.wbg.controller;

import com.cn.wbg.entity.Topic;
import com.cn.wbg.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xiaoliu
 * @ClassName TestController
 * @date 2022/8/2 15:20
 */
@RestController
@RequestMapping("json")
public class TestController {
    @Autowired
    TopicService topicService;
    @RequestMapping("/a")
    public String test(Authentication authentication){
        return authentication.getName();
    }
    @RequestMapping("/test")
    @ResponseBody
    public List<Topic> t(@RequestParam("topicid") String topicid){
        return topicService.selectall();
    }
}
