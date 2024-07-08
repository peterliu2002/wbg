package com.cn.wbg.mapper;

import com.cn.wbg.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @Entity com.cn.wbg.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询此用户是否存在
     * */
    @Select("select * from USER where usercode = #{usercode} ")
    User queryuseris(String usercode);

    Integer register(User user);

    Integer queryUsernameInteger(String usercode);
}
