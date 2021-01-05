package com.exception.test;

import com.exception.test.bean.User;
import com.exception.test.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class TestApplicationTests {

    @Autowired
    private UserLoginService userLoginService;


    @Test
    public void test() throws ParseException {
//        User zhangsan = userLoginService.getUser("zhangsan");
//        System.out.println(zhangsan);


        String date = "20201228";


        String yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(date));

    }






    @Test
    void contextLoads() {

    }


}
