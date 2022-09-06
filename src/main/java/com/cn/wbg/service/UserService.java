package com.cn.wbg.service;

import com.cn.wbg.entity.User;
import com.cn.wbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public interface UserService extends IServive<User> {

    /**
     * 查询此用户是否存在
     * */
    User queryuseris(String user);

    Integer register(User user);
    Integer queryUsernameInteger(String username);
}
