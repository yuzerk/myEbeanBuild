package com.example.ebean.common.ebeanServer;

import com.example.ebean.util.UuidUtil;
import io.ebean.config.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author yuzk
 * @date 2017/11/22
 */
@Component
public class UuidGenerator implements IdGenerator{
    @Override
    public Object nextValue() {
        return UuidUtil.randomUUID();
    }

    @Override
    public String getName() {
        return "UUID";
    }
}
