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
    @Test
    void test(){
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2002-11-26") );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
