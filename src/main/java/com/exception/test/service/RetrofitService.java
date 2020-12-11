package com.exception.test.service;


import com.exception.test.bean.User;
import com.exception.test.httpUtils.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrofitService {

    @Autowired
    private HttpApi httpApi;

    public List<User> getHttp(int limit){
        return  httpApi.login(limit);
    }


    public static void main(String[] args) {
        List<User> http = new RetrofitService().getHttp(3);
        System.out.println(http);
    }

}
