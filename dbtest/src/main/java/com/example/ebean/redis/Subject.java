package com.example.ebean.redis;

import java.io.Serializable;

/**
 * @author yuzk
 * @date 2017/11/20
 */
public class Subject implements Serializable{

    String name;
    String scope;

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public Subject setScope(String scope) {
        this.scope = scope;
        return this;
    }
}
