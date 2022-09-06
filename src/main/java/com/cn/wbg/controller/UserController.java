package com.cn.wbg.controller;

import com.cn.wbg.entity.User;
import com.cn.wbg.service.UserService;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoliu
 * @ClassName UserController
 * @date 2022/8/1 14:26
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/getip")
    public String getip(){
        return "https://api.ipify.org/?format=json";
    }
    /**
     * 注册提交
     *
     * **/
    @RequestMapping("/register")
    public String toregister(@RequestParam("username") String username,
                             @RequestParam("userpassword")String userpassword ,
                             @RequestParam("usersex")String usersex,
                             @RequestParam("userbirth")String userbirth) {
        User user = new User();
        user.setUsersex(usersex);
        user.setUserpassword(userpassword);
        user.setUsername(username);
        user.setCreatetime(new Date());
        try {
            user.setUserbirth(new SimpleDateFormat("yyyy-MM-dd").parse(userbirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userService.register(user);
        return "login";
    }

}
