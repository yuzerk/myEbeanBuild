package com.example.ebean.modules.oneToManyTest.controller;

import com.example.ebean.common.basic.BaseController;
import com.example.ebean.modules.oneToManyTest.service.ContactService;
import com.example.ebean.protocol.ContactProtocol.*;
import com.example.ebean.result.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/con")
public class ContactController extends BaseController<ContactService>{

    @PostMapping("/insert")
    public void insert(@RequestBody @Valid Insert.CustomerVo vo ,BindingResult result) {

        service.insert(vo.getType(),vo.getTypeDetail(),vo.getCustomerId());
    }

    public Result get(String id) {

        return success(service.get(id));
    }
}
