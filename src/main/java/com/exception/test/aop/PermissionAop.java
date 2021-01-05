package com.exception.test.aop;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wc
 */

@Aspect
@Component
@Order
public class PermissionAop {
    private static final Logger logger = LoggerFactory.getLogger(PermissionAop.class);

    @Pointcut("@annotation(com.exception.test.annotation.AopAnnotation)")
    public void permissionCheck() {

    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) {
        logger.debug("first ----");
        Object[] args = joinPoint.getArgs();
        JSONObject arg = (JSONObject) (args[0]);
        Long id = arg.getLong("id");
        String name = arg.getString("name");
        logger.debug("id: " + id);
        logger.debug("name: " + name);

        if (id < 0) {
            return JSON.parseObject("{\"code\":500,\"msg\":\"error\"}");
        }
        return JSON.parseObject("{\"code\":200,\"msg\":\"success\"}");
    }


}
