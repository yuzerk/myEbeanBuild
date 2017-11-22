package com.example.ebean.result;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class Result<T> {

    private Integer ret;
    private T data;
    private Error error;

    public Integer getRet() {
        return ret;
    }

    public Result setRet(Integer ret) {
        this.ret = ret;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Error getError() {
        return error;
    }

    public Result setError(Error error) {
        this.error = error;
        return this;
    }
}
