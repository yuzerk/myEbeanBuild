package com.example.ebean.exception.handler;

import com.example.ebean.exception.BadRequestException;
import com.example.ebean.exception.ProtocolNotMatchException;
import com.example.ebean.result.Error;
import com.example.ebean.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuzk
 * @date 2017/11/22
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handlerBadRequestException(BadRequestException e) {

        return new ResponseEntity<Object>(generateExceptionResult(e), HttpStatus.OK);
    }

//    @ExceptionHandler(value = ProtocolNotMatchException.class)
//    public Result handlerProtocolMatch(ProtocolNotMatchException e) {
//
//        return generateExceptionResult(e);
//    }

    private Result generateExceptionResult(Exception e) {
        return new Result().setRet(-1).setError(new Error().setMessage(e.getMessage()));
    }
}
