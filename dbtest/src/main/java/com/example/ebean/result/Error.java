package com.example.ebean.result;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class Error {

    private String message;
    private String field;
    public String getMessage() {
        return message;
    }

    public Error setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getField() {
        return field;
    }

    public Error setField(String field) {
        this.field = field;
        return this;
    }
}
