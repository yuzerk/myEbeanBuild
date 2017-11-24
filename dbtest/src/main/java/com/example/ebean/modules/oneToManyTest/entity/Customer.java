package com.example.ebean.modules.oneToManyTest.entity;

import com.example.ebean.common.basic.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author yuzk
 * @date 2017/11/23
 */
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

    private String name;
    private Integer sex;

    @OneToMany(mappedBy = "customer")
    List<Contact> contacts;

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Customer setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Customer setSex(Integer sex) {
        this.sex = sex;
        return this;
    }
}
