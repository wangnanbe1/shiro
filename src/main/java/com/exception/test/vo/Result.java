package com.exception.test.vo;

import lombok.Getter;
import lombok.ToString;

/**
 * @auther wangnanbei
 * @date 2020/11/25 11:14
 */

@Getter
@ToString
public class Result<T> {

    private Integer code;

    private String message;

    private T Data;

    private Result(ResultStatus resultStatus , T data){
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.Data = data;

    }


    public static Result<Void> success(){
        return new Result<>(ResultStatus.SUCCESS,null);
    }

    public static <T> Result<T> success( T data){
        return new Result<>(ResultStatus.SUCCESS,data);
    }

    public static <T> Result<T> success(ResultStatus resultStatus , T data){
        if(resultStatus == null) return success(data);
        return new Result<>(resultStatus,data);
    }

    public static Result<Void> failure(){
        return new Result<>(ResultStatus.INTERNAL_SERVER_ERROR,null);
    }

    public static <T> Result<T> failure(T data){
        return new Result<>(ResultStatus.INTERNAL_SERVER_ERROR,data);
    }

    public static <T> Result<T> failure(ResultStatus resultStatus,T data){
        if(resultStatus == null) return failure(data);
        return new Result<>(resultStatus,data);
    }
}
