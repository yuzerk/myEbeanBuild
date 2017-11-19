package com.example.ebean.account.entity;


import com.example.ebean.common.basic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@Entity
@Table(name = "User")
public class User extends BaseEntity{

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
