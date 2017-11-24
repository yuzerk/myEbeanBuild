package com.example.ebean.modules.oneToManyTest.controller;

import com.example.ebean.common.basic.BaseController;
import com.example.ebean.modules.oneToManyTest.service.CustomerService;
import com.example.ebean.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/cus")
public class CustomerController extends BaseController<CustomerService>{

    @RequestMapping("/insert")
    public void insert(String name, Integer sex) {

        service.insert(name,sex);
    }

    @RequestMapping("/get")
    public Result get(String name)  {

       return success(service.getByName(name));
    }
}
