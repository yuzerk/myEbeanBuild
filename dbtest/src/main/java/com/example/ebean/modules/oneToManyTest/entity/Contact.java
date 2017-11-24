package com.example.ebean.modules.oneToManyTest.entity;

import com.example.ebean.common.basic.BaseEntity;
import com.example.ebean.util.ValidateUtil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author yuzk
 * @date 2017/11/23
 */
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity{

    private String type;
    private String typeDetail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customerId")
    private Customer customer;

    public String getType() {
        return type;
    }

    public Contact setType(String type) {
        this.type = type;
        return this;
    }

    public String getTypeDetail() {
        return typeDetail;
    }

    public Contact setTypeDetail(String typeDetail) {
        this.typeDetail = typeDetail;
        return this;
    }

    public Contact setCustomerId(String id) {
        if(ValidateUtil.isEmpty(customer)) {
            customer = new Customer();
        }
        customer.setId(id);
        return this;
    }

    public String getCustomerId() {
        return customer.getId();
    }
}
