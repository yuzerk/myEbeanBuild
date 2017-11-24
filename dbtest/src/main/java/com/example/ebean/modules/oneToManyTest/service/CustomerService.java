package com.example.ebean.modules.oneToManyTest.service;

import com.example.ebean.common.basic.BaseService;
import com.example.ebean.modules.oneToManyTest.dao.CustomerDao;
import com.example.ebean.modules.oneToManyTest.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Service
public class CustomerService extends BaseService<CustomerDao>{

    public void insert(String name, Integer sex) {

        dao.insert(name,sex);
    }

    public Customer getByName(String name) {

        return dao.findByName(name);
    }
}
