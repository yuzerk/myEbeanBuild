package com.example.ebean.util;

import java.util.UUID;

/**
 * @author yuzk
 * @date 2017/11/10
 */
public class UuidUtil {

    /**
     * 不去掉-的uuid
     *
     * @return
     */
    public static String randomRawUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 去掉-的uuid
     *
     * @return
     */
    public static String randomUUID() {
        String uuid = randomRawUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(uuid.substring(0, 8));
        sb.append(uuid.substring(9, 13));
        sb.append(uuid.substring(14, 18));
        sb.append(uuid.substring(19, 23));
        sb.append(uuid.substring(24));
        return sb.toString();
    }
}
