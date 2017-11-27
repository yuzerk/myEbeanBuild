package com.example.ebean.result;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@XmlRootElement(name = "Result")
public class XMLResult {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public XMLResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public XMLResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
