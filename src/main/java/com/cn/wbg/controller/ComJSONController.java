package com.cn.wbg.controller;

import com.cn.wbg.entity.Comment;
import com.cn.wbg.entity.Topic;
import com.cn.wbg.entity.User;
import com.cn.wbg.mapper.BaseMapper;
import com.cn.wbg.service.CommentService;
import com.cn.wbg.service.IServive;
import com.cn.wbg.service.TopicService;
import com.cn.wbg.service.UserService;
import com.cn.wbg.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoliu
 * @ClassName ComJSONController
 * @date 2022/8/5 10:38
 */
@RestController
@RequestMapping("/comment")
public class ComJSONController {
    @Autowired
    CommentService commentService;
    @Autowired
    TopicService topicService;
    @Autowired
    UserService userService;
    @ResponseBody
    @RequestMapping("/getonecomment")
    public Map<String, Object> getonecomment(@RequestParam("topicid") Integer topicid) {
        Map<String, Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("plq", commentService.querycom(topicid));
        objectObjectMap.put("htnr", topicService.queryoneTopic(topicid));
        return objectObjectMap;
    }

    @ResponseBody
    @RequestMapping("/getname")
    public String queryi(@RequestParam("name") String name){
        return name;
    }


    @ResponseBody
    @RequestMapping("/querycid")
    public List<String> getcommentlist(@RequestParam("dbid") Integer dbid, @RequestParam("topicid") Integer topicid) {

        return commentService.queryCidlist(dbid, topicid);
    }

    @ResponseBody
    @RequestMapping("/querycidone")
    public String getonecomment(@RequestParam("dbid") Integer dbid, @RequestParam("topicid") Integer topicid) {

        return commentService.queryCidString(dbid, topicid);
    }
    @ResponseBody
    @RequestMapping("/querycidmaxlist")
    public List<String> querycidmaxlist(@RequestParam("topicid") Integer topicid) {

        return commentService.querycidlist(topicid);
    }
    @ResponseBody
    @RequestMapping("/queryusername")
    public Integer queryusername(@RequestParam("username") String username) {

        return userService.queryUsernameInteger(username);
    }
    @ResponseBody
    @RequestMapping("/savecomment")
    public Integer savecomment(Authentication authentication,
                               @RequestParam("cid") String cid,
                               @RequestParam("pid") String pid,
                               @RequestParam("plnr") String plnr,
                               @RequestParam("topicid") Integer topicid) {
        Comment comment = new Comment();
        comment.setCreatedate(new Date());
        comment.setCreatename(authentication.getName());
        comment.setTopicid(topicid);
        comment.setCid(cid);
        comment.setPid(pid);
        comment.setPlnr(plnr);
        return commentService.saveNewComment(comment);
    }
}
