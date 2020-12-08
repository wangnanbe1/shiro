package com.exception.test.controller;

import com.exception.test.vo.Result;
import com.exception.test.vo.ResultStatus;
import com.exception.test.ExceptionHandler.BizException;
import com.exception.test.bean.User;
import com.exception.test.mapper.UserMapper;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther wangnanbei
 * @date 2020/11/24 15:16
 */

@RestController
@Transactional
public class UserControllrt {

    private static final Logger logger = LoggerFactory.getLogger(UserControllrt.class);


    @Autowired
    private UserMapper userMapper;


    @GetMapping("/scan/{limit}")
    public List<User> scan(@PathVariable("limit") int limit){

        List<User> users = new ArrayList();

        Cursor<User> userCursor = userMapper.findAll(limit);
        userCursor.forEach(user->{
            users.add(user);
        });

        return users;
    }

    @GetMapping("/result/{limit}")
    public Result<List<User>> result(@PathVariable("limit") int limit){
        List<User> users = new ArrayList();
        Cursor<User> userCursor = userMapper.findAll(limit);
        userCursor.forEach(user->{
            users.add(user);
        });
//        return Result.failure(users);
        return Result.success(ResultStatus.SUCCESS,users);
    }

    @GetMapping("/user/")
    public void user(){
        throw new BizException("404","该户用未查询到!");
    }

    @PostMapping("/user/")
    public void user1(){
        String str=null;
        str.equals("111");
    }

    @PutMapping("/user/")
    public void user2(){
        Integer.parseInt("abc123");
    }

}
