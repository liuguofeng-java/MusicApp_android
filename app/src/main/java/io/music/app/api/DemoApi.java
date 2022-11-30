package io.music.app.api;

import java.util.Map;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 测试
 * @author liuguofeng
 * @date 2022/11/29 11:17
 **/
public interface DemoApi {
    @GET("playlist/detail")
    Observable<Map<String,Object>> playlistDetail(@Query("id") int id);
}
