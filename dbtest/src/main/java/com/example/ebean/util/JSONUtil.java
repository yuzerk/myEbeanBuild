package com.example.ebean.util;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import jodd.util.StringUtil;

/**
 * json工具类
 *
 * @author christ
 */
public class JSONUtil {

    /**
     * 序列化
     *
     * @param value
     * @return
     */
    public static String serialize(Object value) {

        return serialize(value, (String[]) null);
    }

    /**
     * 序列化
     *
     * @param value
     * @param includes
     * @return
     */
    public static String serialize(Object value, String... includes) {

        if (includes != null) {

            return new JsonSerializer().deep(true).exclude("*").include(includes).serialize(value);
        }

        return new JsonSerializer().deep(true).serialize(value);
    }


    /**
     * 反序列化
     *
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String value, Class bean) {

        if (value == null) {
            return null;
        }

        // 数组类型处理
        if (StringUtil.trimLeft(value).startsWith("[")) {
            return new JsonParser().looseMode(true).map("values", bean).parse(value);
        }

        // 对象类型处理
        return (T) new JsonParser().looseMode(true).parse(value, bean);
    }

}