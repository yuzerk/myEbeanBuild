package com.example.ebean.common.basic;

import com.example.ebean.result.Result;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @author yuzk
 * @date 2017/11/24
 */
public class BaseResultProcessor extends BaseProsessor{

    /**
     * 判断调用接口是否错误，错误返回true
     *
     * @param result
     * @return
     */
    public boolean isError(Result result) {
        return result.getRet() < 0;
    }

    /**
     * 成功
     *
     * @return
     */
    public Result success() {

        return new Result().setRet(0);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public Result success(Object data) {

        if (data == null) {
            return success();
        }

        if (data instanceof Collection) {
            Collection collection = (Collection) data;
            return new Result().setRet(collection.size()).setData(data);
        }

        if (data.getClass().isArray()) {
            return new Result().setRet(Array.getLength(data)).setData(data);
        }

        return new Result().setRet(1).setData(data);

    }
}
