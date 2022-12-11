package io.music.app.api;

import java.util.Map;

import io.music.app.api.vo.BannerVo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 首页请求
 *
 * @author liuguofeng
 * @date 2022/11/29 11:17
 **/
public interface PageHomeApi {
    /**
     * 获取轮播图(type=1代表 android)
     *
     * @return 轮播图数据
     */
    @GET("banner?type=1")
    Observable<BannerVo> banner();

}
