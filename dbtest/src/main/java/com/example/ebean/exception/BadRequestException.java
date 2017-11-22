package com.example.ebean.exception;

import com.example.ebean.exception.baseException.BusinessException;
import com.example.ebean.util.ValidateUtil;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class BadRequestException extends BusinessException{

    private List<String> fields;

    public BadRequestException() {
        this(HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String field, String message) {
        super(message);
        setCode(HttpStatus.BAD_REQUEST);
        fieldsNotNull();
        fields.add(field);
    }

    public BadRequestException(String message, HttpStatus code) {
        super(message, code);
    }
    public BadRequestException(HttpStatus code) {
        super(code);
    }
    public List<String> getFields() {
        return fields;
    }

    private void fieldsNotNull() {
        if(ValidateUtil.isEmpty(fields)) {
            fields = new ArrayList<>();
        }
    }
}
