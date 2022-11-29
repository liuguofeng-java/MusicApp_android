package io.music.app.common.network;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import io.music.app.common.network.handler.HttpErrorHandler;
import io.music.app.common.network.interceptor.RequestInterceptor;
import io.music.app.common.network.interceptor.ResponseInterceptor;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 请求网络
 * @author liuguofeng
 * @date 2022/11/29 11:40
 */
public class HttpServer {

    //OkHttp客户端
    private static OkHttpClient okHttpClient;
    //保存实例避免重复创建
    private static final ConcurrentHashMap<String, Retrofit> retrofitHashMap = new ConcurrentHashMap<>();
    //API访问地址
    private final static String baseUrl = "http://120.46.163.203:3000/";


    /**
     * 创建Retrofit
     */
    public static <T> T createService(Class<T> serviceClass) {
        return getRetrofit(serviceClass).create(serviceClass);
    }

    /**
     * 配置OkHttp
     * @return OkHttpClient
     */
    private static OkHttpClient getOkHttpClient() {
        //不为空则说明已经配置过了，直接返回即可。
        if (okHttpClient == null) {
            //OkHttp构建器
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //设置网络请求超时时长(s)
            builder.connectTimeout(5, TimeUnit.SECONDS);
            //添加请求拦截器
            builder.addInterceptor(new RequestInterceptor());
            //添加返回拦截器
            builder.addInterceptor(new ResponseInterceptor());
            //OkHttp配置完成
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    /**
     * 配置Retrofit
     *
     * @param serviceClass 服务类
     * @return Retrofit
     */
    private synchronized static <T> Retrofit getRetrofit(Class<T> serviceClass) {
        if (retrofitHashMap.get(baseUrl + serviceClass.getName()) != null) {
            //刚才上面定义的Map中键是String，值是Retrofit，当键不为空时，必然有值，有值则直接返回。
            return retrofitHashMap.get(baseUrl + serviceClass.getName());
        }
        //Retrofit构建器
        Retrofit.Builder builder = new Retrofit.Builder();
        //设置访问地址
        builder.baseUrl(baseUrl);
        //设置OkHttp客户端
        builder.client(getOkHttpClient());
        //设置数据解析器
        builder.addConverterFactory(GsonConverterFactory.create());
        //设置请求回调
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        //retrofit配置完成
        Retrofit retrofit = builder.build();
        //放入Map中
        retrofitHashMap.put(baseUrl + serviceClass.getName(), retrofit);
        //最后返回即可
        return retrofit;
    }

    /**
     * 配置RxJava 完成线程的切换,并处理网络返回结果
     * @param observable 返回的observable
     * @param <T> 泛型
     * @return observable
     */
    public static <T> Observable<T> applyObservable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())//线程订阅
                .observeOn(AndroidSchedulers.mainThread())//观察Android主线程
                .onErrorResumeNext(new HttpErrorHandler<T>());
    }

}
