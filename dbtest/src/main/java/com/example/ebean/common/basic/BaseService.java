package com.example.ebean.common.basic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuzk
 * @date 2017/11/9
 */
public class BaseService<DAO extends BaseDao> extends BaseResultProcessor{

    @Autowired
    protected DAO dao;


}
