package com.cn.wbg.service.impl;

import com.cn.wbg.entity.User;
import com.cn.wbg.mapper.BaseMapper;
import com.cn.wbg.mapper.UserMapper;
import com.cn.wbg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
*
*/
@Service
public class UserServiceImpl extends ServiceImpl<User>
implements UserDetailsService,UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer register(User user) {
        user.setUserpassword(new BCryptPasswordEncoder().encode(user.getUserpassword()));
        System.out.println("------注册------");
        System.out.println(user);
        return userMapper.register(user);
    }

    @Override
    public Integer queryUsernameInteger(String usercode) {
        return userMapper.queryUsernameInteger(usercode);
    }

    @Override
    public Integer update(User user) {
        return null;
    }

    @Override
    public Integer add(User user) {
        return null;
    }

    @Override
    protected BaseMapper<User> baseMapper() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String usercode) throws UsernameNotFoundException {
        System.out.println(usercode+"loadUserByUsername");
        // 根据 s 查询用户
        User user = userMapper.queryuseris(usercode);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        System.out.println("登录：---"+user.getUsercode()+
                user.getUserpassword());
        return new org.springframework.security.core.userdetails.User(user.getUsercode(),
                user.getUserpassword()
                //new BCryptPasswordEncoder().encode(user.getPassword())
//                new BCryptPasswordEncoder().encode(user.getUserpassword())
                , roles);
    }

    @Override
    public User queryuseris(String user) {
        User queryuseris = userMapper.queryuseris(user);
        System.out.println(queryuseris+"x");
        return queryuseris;
    }
}
