package com.example.ebean.account.server;

import com.example.ebean.account.dao.UserDao;
import com.example.ebean.account.entity.User;
import com.example.ebean.common.basic.BaseDao;
import com.example.ebean.common.basic.BaseService;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@Service
public class UserService extends BaseService<UserDao> {

    public User get(String name) {

        return dao.get(name);
    }
}
