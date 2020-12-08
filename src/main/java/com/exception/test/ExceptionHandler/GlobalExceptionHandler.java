package com.exception.test.ExceptionHandler;

import com.exception.test.vo.Result;
import com.exception.test.vo.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther wangnanbei
 * @date 2020/11/25 12:07
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务逻辑错误
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result bizExceptionHandler(HttpServletRequest req, BizException e) {
        logger.error("业务逻辑异常! 原因是:{}", e.errorMessage);
        return Result.failure(ResultStatus.NOT_FOUND, e.errorMessage);
    }

    /**
     * 空指针异常
     *
     * @param req
     * @param e
     * @return
     */

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result bizExceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("空指针异常! 原因是:{}", e);
        return Result.failure(ResultStatus.NULL_POIN, e);
    }

    /**
     * 其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result bizExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("其他异常! 原因是:{}", e);
        return Result.failure(ResultStatus.INTERNAL_SERVER_ERROR,e.getMessage());
    }


}
