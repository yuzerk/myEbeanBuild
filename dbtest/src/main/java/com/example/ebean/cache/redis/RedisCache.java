package com.example.ebean.cache.redis;

import com.example.ebean.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yuzk
 * @date 2017/11/19
 */
@Component
public class RedisCache implements Cache{

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    @Override
    public Object get(Object key) {
        return getMap().get(key);
    }

    @Override
    public void put(Object key, Object value) {
        getMap().set(key,value);
    }

    @Override
    public void putex(Object key, Object value, int seconds) {
        getMap().set(key,value,seconds, TimeUnit.SECONDS);
    }

    @Override
    public void setex(Object key, int seconds) {
        Object value = get(key);
        putex(key,value,seconds);
    }

    @Override
    public void remove(Object key) {
        if(key instanceof Collection) {
            template.delete((Collection<String>) key);
        }
        else{
            template.delete((String)key);
        }
    }

    @Override
    public void clean() {

    }

    @Override
    public Set keys() {
        return null;
    }

    private ValueOperations getMap() {
        return template.opsForValue();
    }
}
