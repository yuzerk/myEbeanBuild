package com.example.ebean.common.basic;

import io.ebean.Model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author yuzk
 * @date 2017/11/17
 */
@MappedSuperclass
public abstract class BaseEntity extends Model{

    @Id
    private String Id;

    public String getId() {
        return Id;
    }

    public BaseEntity setId(String id) {
        Id = id;
        return this;
    }
}
