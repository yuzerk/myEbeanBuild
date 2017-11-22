package com.example.ebean.account.server;

import com.example.ebean.account.dao.UserDao;
import com.example.ebean.account.entity.User;
import com.example.ebean.common.basic.BaseDao;
import com.example.ebean.common.basic.BaseService;
import com.example.ebean.exception.BadRequestException;
import com.example.ebean.exception.ProtocolNotMatchException;
import com.example.ebean.result.Result;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuzk
 * @date 2017/10/13
 */
@Service
public class UserService extends BaseService<UserDao> {

    public User get(String name) {

        return dao.get(name);
    }

    public int update(String password) {
        return dao.update(password);
    }

    public void saveOrUpdate(String password) {
        String name = "lucy";
        User user = dao.get(name);
        user.setPassword(password);        dao.saveOrUpdate(user);
    }

    public List<User> findList(List<String> ids) {

        return dao.createQuery()
                .where()
                .in("id",ids)
                .findList();
    }

    public void error(String select) {
        if(select.equals("1")) {
            throw new BadRequestException("some one field","badRequest");
        }
        if(select.equals("2")) {
            throw new ProtocolNotMatchException("ProtocolNotMatch");
        }
    }
}
