package io.music.app.common.network;


/**
 * 基础返回类
 */
public class BaseResult<T> {
    private Integer code;

    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
