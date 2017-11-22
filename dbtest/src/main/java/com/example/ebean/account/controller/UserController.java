package com.example.ebean.account.controller;

import com.example.ebean.account.entity.User;
import com.example.ebean.account.server.UserService;
import com.example.ebean.common.basic.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService>{


    @GetMapping("/get")
    public User get(String name) {

        return service.get(name);
    }

    @GetMapping("/update")
    public int update(String password) {

        return service.update(password);
    }

    @GetMapping("/save")
    public void save(String password) {

        service.saveOrUpdate(password);
    }

    @GetMapping("/findlist")
    public List<User> getList() {
        List<String> ids = Arrays.asList("1","2","3");
        return service.findList(ids);
    }

    // @ExceptionHandler and @ControllerAdvice TEST
    @GetMapping("/what")
    public void what(String se) {
        service.error(se);
    }

    // UUID generator TEST
    @GetMapping("/insert")
    public void insert(String name) {
        String password = "lalalalalal";
        service.insert(new User().setPassword(password).setName(name));
    }
}
