package com.exception.test.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @auther wangnanbei
 * @date 2020/11/25 11:08
 */

@Getter
@ToString
public enum ResultStatus {

    SUCCESS(HttpStatus.OK, 200, "OK"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "Bad Request"),
    NOT_FOUND(HttpStatus.NOT_FOUND, 404, "Not Found"),
    NULL_POIN(HttpStatus.NOT_FOUND, 404, "Null Point"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "Internal Server Error");

    private HttpStatus httpStatus;
    private Integer code;
    private String message;

    ResultStatus(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
