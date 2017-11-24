package com.example.ebean.result;

/**
 * @author yuzk
 * @date 2017/11/24
 */
public class MyPagedList<T> {

    private Integer skip;
    private Integer total;
    private Integer pageSize;
    private Integer firstRow;
    private Integer maxRow;
    private T data;

    public Integer getSkip() {
        return skip;
    }

    public MyPagedList setSkip(Integer skip) {
        this.skip = skip;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public MyPagedList setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public MyPagedList setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public T getData() {
        return data;
    }

    public MyPagedList setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getFirstRow() {
        return firstRow;
    }

    public MyPagedList setFirstRow(Integer firstRow) {
        this.firstRow = firstRow;
        return this;
    }

    public Integer getMaxRow() {
        return maxRow;
    }

    public MyPagedList setMaxRow(Integer maxRow) {
        this.maxRow = maxRow;
        return this;
    }
}
