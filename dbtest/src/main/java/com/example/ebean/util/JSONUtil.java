package com.example.ebean.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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

    /**
     * 格式化输出json字符串
     *
     * @param jsonString
     * @return
     */
    public static String format(String jsonString) {
        if(!isJsonString(jsonString)) {
            return jsonString;
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        com.google.gson.JsonParser jp = new com.google.gson.JsonParser();
        JsonElement je = jp.parse(jsonString);
        return gson.toJson(je);
    }

    public static boolean isJsonString(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}