package com.example.ebean.modules.oneToManyTest.service;

import com.example.ebean.common.basic.BaseService;
import com.example.ebean.modules.oneToManyTest.dao.ContactDao;
import com.example.ebean.modules.oneToManyTest.entity.Contact;
import org.springframework.stereotype.Service;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@Service
public class ContactService extends BaseService<ContactDao>{

    public void insert(String type,String typeDetail,String customerId) {

        dao.saveOrUpdate(new Contact()
                .setCustomerId(customerId)
                .setType(type)
                .setTypeDetail(typeDetail));
    }

    public Contact get(String id) {

        return dao.findById(id);
    }
}
