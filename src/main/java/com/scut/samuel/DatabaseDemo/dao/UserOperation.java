package com.scut.samuel.DatabaseDemo.dao;


import com.scut.samuel.DatabaseDemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by Ai on 2017/9/19.
 */
@Component
public interface UserOperation {
    @Insert("insert into user(username,age) values(#{username},#{age})")
    void insertUser(@Param("username")String username,@Param("age")int age);

    @Select("select * from user where username=#{username}")
    User selectUser(@Param("username")String username);

    @Delete("delete from user where username=#{username}")
    void deleteUser(@Param("username")String username);

    @Update("update user set age=#{age} where username=#{username}")
    void updateUser(@Param("age")int age, @Param("username")String username);
}
