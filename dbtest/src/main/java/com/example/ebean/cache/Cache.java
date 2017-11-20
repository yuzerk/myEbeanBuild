package com.example.ebean.cache;

import java.util.Set;

/**
 * @author yuzk
 * @date 2017/11/19
 */
public interface Cache {

    Object get(Object key);

    void put(Object key, Object value);

    /**
     * insert/update with expired time
     * @param key
     * @param Value
     * @param seconds
     */
    void putex(Object key, Object Value, int seconds);

    /**
     * set expired time
     * @param key
     * @param seconds
     */
    void setex(Object key, int seconds);

    /**
     * remove the specify key-value
     * @param key
     * @return
     */
    void remove(Object key);

    /**
     * remove all key-value
     */
    void clean();

    /**
     * get all keys
     * @return
     */
    Set keys();
}
