package com.example.ebean.redis;

import com.example.ebean.cache.redis.RedisCache;
import com.example.ebean.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuzk
 * @date 2017/11/20
 */
@RestController
@RequestMapping("/redis")
public class redisController {

    @Autowired
    private RedisCache cache;

    @GetMapping("put")
    public void put() {
        String tokenId = UuidUtil.randomUUID();
        Subject test = new Subject().setName("lalal").setScope("admin");
        cache.put(tokenId, test);
    }

    @GetMapping("get")
    public Subject get(String id) {
        return (Subject) cache.get(id);
    }

}
