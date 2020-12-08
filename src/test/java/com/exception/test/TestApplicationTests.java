package com.exception.test;

import com.exception.test.bean.User;
import com.exception.test.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class TestApplicationTests {

    @Autowired
    private UserLoginService userLoginService;


    @Test
    public void test(){
        User zhangsan = userLoginService.getUser("zhangsan");
        System.out.println(zhangsan);
    }






    @Test
    void contextLoads() {

    }


}
