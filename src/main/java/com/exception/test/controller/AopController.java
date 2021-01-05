package com.exception.test.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exception.test.annotation.AopAnnotation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wc
 */


@RestController
public class AopController {

    @PostMapping("/api")
    @AopAnnotation()
    public Object getAop(@RequestBody JSONObject request){
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }


}
