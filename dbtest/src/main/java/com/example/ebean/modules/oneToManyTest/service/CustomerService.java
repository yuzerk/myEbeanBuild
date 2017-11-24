package com.example.ebean.modules.oneToManyTest.service;

import com.example.ebean.common.basic.BaseService;
import com.example.ebean.modules.oneToManyTest.dao.CustomerDao;
import com.example.ebean.modules.oneToManyTest.entity.Customer;
import com.example.ebean.result.MyPagedList;
import io.ebean.PagedList;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Customer> gets(MyPagedList<Customer> pagedList) {
        operatorPage(pagedList);
        PagedList<Customer> customers =  dao.createQuery().orderBy().asc("name")
                .setFirstRow(pagedList.getFirstRow())
                .setMaxRows(pagedList.getMaxRow())
                .findPagedList();
        return customers.getList();
    }
}
