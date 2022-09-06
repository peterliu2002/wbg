package com.cn.wbg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author xiaoliu
 * @ClassName LoginController
 * @date 2021/11/1 13:30
 */
@Controller
public class LoginController {
    @Autowired
    HttpSession httpSession;

    /**
     * 去往登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 去注册页面
     */
    @RequestMapping("/toregister")
    public String toregister() {
        return "register";
    }

    /**
     * 去往主页
     *
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/main")
    public String toMain() {
        Object names = httpSession.getAttribute("names");


        return "main";
    }

    @RequestMapping("/toLogout")
    public String toLogout() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    /**
     * 通往主页获取所以话题
     * */
}
