package com.example.ebean.common.basic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class BaseController<SERVICE extends BaseService> extends BaseProsessor{

    @Autowired
    protected SERVICE service;
}
