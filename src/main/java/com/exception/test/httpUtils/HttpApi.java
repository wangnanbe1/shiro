package com.exception.test.httpUtils;


import com.exception.test.bean.User;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import org.springframework.stereotype.Service;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;



@Service
@RetrofitClient(baseUrl = "http://localhost:8090/")
public interface HttpApi {

    @GET("result")
    List<User> login(@Query("limit") int limit);
}
