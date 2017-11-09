package com.example.ebean.common.basic;

import io.ebean.EbeanServer;
import io.ebean.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author yuzk
 * @date 2017/11/7
 */
public class BaseDao<T>{

    private Class<T> clazz;

    @Autowired
    private EbeanServer server;

    public BaseDao(){
        this.clazz = getEntityClass();
    }

    public Query<T> createQuery() {
        return server.createQuery(clazz);
    }


    private Class getEntityClass() {
        Class entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class) p[0];
        }
        return entityClass;
    }
}
