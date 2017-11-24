package com.example.ebean.common.basic;

import io.ebean.EbeanServer;
import io.ebean.OrderBy;
import io.ebean.Query;
import io.ebean.UpdateQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author yuzk
 * @date 2017/11/7
 */
public class BaseDao<T> extends BaseProsessor{

    private Class<T> clazz;

    @Autowired
    private EbeanServer server;

    public BaseDao(){
        this.clazz = getEntityClass();
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

    //-----------------------   sql  操作   --------------------------------

    public Query<T> createQuery(){
        return server.createQuery(clazz);
    }

    public OrderBy<T> createOrderBy() {
        return server.createQuery(clazz).orderBy();
    }

    public T findById(String id) {
        return server.find(clazz,id);
    }

    public void saveOrUpdate(Object object) {

        if(object instanceof Collection<?>) {
            server.saveAll((Collection<T>) object);
            return;
        }
        server.save(object);
    }

    public UpdateQuery<T> updateQuery() {
        return server.update(clazz);
    }
}
