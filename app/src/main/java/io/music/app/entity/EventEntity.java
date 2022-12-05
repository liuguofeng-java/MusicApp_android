package io.music.app.entity;

/**
 * @author liuguofeng
 * @date 2022/11/30 20:40
 **/
public class EventEntity<T> {
    private int id;
    private T data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
