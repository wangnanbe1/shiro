package com.exception.test.ExceptionHandler;

import com.exception.test.vo.Result;

/**
 * @auther wangnanbei ♥ liupei
 * @date 2020/11/25 13:01
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    protected String errorCode;

    protected String errorMessage;

    public BizException() {
        super();
    }

    public BizException(Result result) {
        super(result.getCode().toString());
        this.errorCode = result.getCode().toString();
        this.errorMessage = result.getMessage();
    }

    public BizException(Result result,Throwable cause) {
        super(result.getCode().toString(),cause);
        this.errorCode = result.getCode().toString();
        this.errorMessage = result.getMessage();
    }




    public BizException( String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BizException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BizException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
