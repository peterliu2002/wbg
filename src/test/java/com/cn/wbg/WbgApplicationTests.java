package com.cn.wbg;

import com.cn.wbg.entity.User;
import com.cn.wbg.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class WbgApplicationTests {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TopicService topicService;
    @Test
    void tetopic(){
        Topic topic = new Topic();
        topic.setCreatename("小狗");
        topic.setCreatedate(new Date());
        topic.setHtnr("htnr");
        topic.setIspublic("1");
        topic.setTopicname("htmc");
        topicService.addtopic(topic);
    }
    @Test
    void contextLoads() throws ParseException {
        User user = new User();
        user.setUsersex("1");
        user.setUserbirth(new SimpleDateFormat("yyyy-MM-dd").parse("2002-11-26"));
        user.setUsername("123");
        user.setUserpassword("1126");
        user.setCreatetime(new Date());
        System.out.println(user);
        System.out.println(userService.register(user));
    }
    @Test
    void test(){
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2002-11-26") );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
