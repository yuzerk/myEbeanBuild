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
        PagedList<Customer> customers =  dao.createOrderBy().asc("name")
                .setFirstRow(pagedList.getFirstRow())
                .setMaxRows(pagedList.getPageSize())
                .findPagedList();
        if(isEmpty(pagedList.getTotal())) {
            pagedList.setTotal(customers.getTotalCount());
        }
        //还可以返回成一个PagedList
        return customers.getList();
    }
}
