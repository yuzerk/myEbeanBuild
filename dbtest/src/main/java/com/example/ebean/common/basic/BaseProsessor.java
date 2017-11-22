package com.example.ebean.common.basic;

import com.example.ebean.util.ValidateUtil;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class BaseProsessor {

    /**
     * 空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {

        return ValidateUtil.isEmpty(value);
    }

    /**
     * 非空
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(Object value) {

        return ValidateUtil.isNotEmpty(value);
    }
}
