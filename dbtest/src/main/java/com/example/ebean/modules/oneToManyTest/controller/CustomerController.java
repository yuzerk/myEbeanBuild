package com.example.ebean.modules.oneToManyTest.controller;

import com.example.ebean.common.basic.BaseController;
import com.example.ebean.modules.oneToManyTest.entity.Customer;
import com.example.ebean.modules.oneToManyTest.service.CustomerService;
import com.example.ebean.result.MyPagedList;
import com.example.ebean.result.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/cus")
public class CustomerController extends BaseController<CustomerService>{

    @GetMapping("/insert")
    public void insert(String name, Integer sex) {

        service.insert(name,sex);
    }

    @GetMapping("/get")
    public Result get(String name)  {

       return success(service.getByName(name));
    }

    @PostMapping("/page")
    public Result getPage(@RequestBody MyPagedList<Customer> pagedList) {

        return success(service.gets(pagedList));
    }
}
