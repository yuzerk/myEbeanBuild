package com.example.ebean.exception.baseException;

import org.springframework.http.HttpStatus;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class BusinessException extends RuntimeException{

    private HttpStatus code;

    private Object data;

    public BusinessException(HttpStatus code) {
        this.code = code;
    }
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, HttpStatus code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, HttpStatus code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    protected BusinessException setCode(HttpStatus code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BusinessException setData(Object data) {
        this.data = data;
        return this;
    }
}
