package com.example.ebean.account.server;

import com.example.ebean.account.entity.User;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@Service
public class UserService {

    @Autowired
    private EbeanServer server;

    public User get(String name) {

        return server.createQuery(User.class)
                .where()
                .eq("name",name)
                .findOne();
    }
}
