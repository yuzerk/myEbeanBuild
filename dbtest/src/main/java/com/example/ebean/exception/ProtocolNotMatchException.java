package com.example.ebean.exception;

import org.springframework.http.HttpStatus;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class ProtocolNotMatchException extends BadRequestException{

    public ProtocolNotMatchException() {
        setCode(HttpStatus.FAILED_DEPENDENCY);
    }
    public ProtocolNotMatchException(String message) {
        super(message,HttpStatus.FAILED_DEPENDENCY);
    }
}
