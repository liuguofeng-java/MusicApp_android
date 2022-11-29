package io.music.app.common.network.interceptor;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求拦截器
 *
 * @author liuguofeng
 * @date 2022/11/29 11:27
 */
public class RequestInterceptor implements Interceptor {

    public RequestInterceptor() {
    }

    /**
     * 拦截
     */
    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        //构建器
        Request.Builder builder = chain.request().newBuilder();
        //添加使用环境
        builder.addHeader("os", "android");
        //返回
        return chain.proceed(builder.build());
    }
}
