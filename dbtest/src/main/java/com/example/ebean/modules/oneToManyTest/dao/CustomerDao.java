package com.example.ebean.modules.oneToManyTest.dao;

import com.example.ebean.common.basic.BaseDao;
import com.example.ebean.modules.oneToManyTest.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Repository
public class CustomerDao extends BaseDao<Customer>{

    public void insert(String name, Integer sex) {

        saveOrUpdate(new Customer().setName(name).setSex(sex));
    }

    public Customer findByName(String name) {

        return createQuery()
                .where()
                .eq("name",name)
                .findUnique();
    }
}
