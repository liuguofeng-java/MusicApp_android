package io.music.app.common.network.interceptor;


import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 返回拦截器(响应拦截器)
 *
 * @author liuguofeng
 * @date 2022/11/29 11:30
 */
public class ResponseInterceptor implements Interceptor {

    /**
     * 拦截
     */
    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
