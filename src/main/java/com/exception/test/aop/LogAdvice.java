package com.exception.test.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);


    /**
     * 切入点
     */
    @Pointcut("execution(public * com.exception.test.controller.*.*(..))")
    private void LogAdvicePointCut() {
    }


    /**
     *
     */
    @Before("LogAdvicePointCut()")
    public void LogAdvice(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        StringBuffer requestURL = request.getRequestURL();
        logger.debug("ip: "+ request.getRemoteAddr() );
        logger.debug("className: "+ joinPoint.getSignature().getDeclaringTypeName());
        logger.debug("http Method: "+ request.getMethod());
        logger.debug("Controller Method Name: "+ joinPoint.getSignature().getName());
    }


}
