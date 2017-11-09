package com.example.ebean.account.dao;

import com.example.ebean.account.entity.User;
import com.example.ebean.common.basic.BaseDao;
import org.springframework.stereotype.Component;

/**
 * @author yuzk
 * @date 2017/11/9
 */
@Component
public class UserDao extends BaseDao<User>{

    public User get(String name) {
        return createQuery()
                .where()
                .eq("name",name)
                .findOne();
    }
}
