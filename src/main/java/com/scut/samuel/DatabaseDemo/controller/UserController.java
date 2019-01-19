package com.scut.samuel.DatabaseDemo.controller;

import com.scut.samuel.DatabaseDemo.dao.UserOperation;
import com.scut.samuel.DatabaseDemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ai on 2017/9/19.
 */
@RestController
public class UserController {
    @Autowired
    private UserOperation userOperation;

    @RequestMapping("/insert")
    public String insert(@RequestParam String username,@RequestParam int age){
        userOperation.insertUser(username,age);
        return "SUCCESS";
    }

    @RequestMapping("/select/{username}")
    public User findByName(@PathVariable String username){
        return userOperation.selectUser(username);
    }

    @RequestMapping("/delete/{username}")
    public String delete(@PathVariable String username){
        userOperation.deleteUser(username);
        return "SUCCESS";
    }
    @RequestMapping("/update/{username},{age}")
    public String delete(@PathVariable String username,@PathVariable int age){
        userOperation.updateUser(age,username);
        return "SUCCESS";
    }
}
