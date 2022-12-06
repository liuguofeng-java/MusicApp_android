package io.music.app.entity;

/**
 * 事件传递
 * @author liuguofeng
 * @date 2022/11/30 20:40
 **/
public class EventEntity<T> {
    /**
     * 业务id
     */
    private String serviceId;
    /**
     * 事件id
     */
    private int id;
    /**
     * 数据
     */
    private T data;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

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
