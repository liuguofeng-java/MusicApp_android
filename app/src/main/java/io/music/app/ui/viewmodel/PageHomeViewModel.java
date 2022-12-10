package io.music.app.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.music.app.api.PageHomeApi;
import io.music.app.api.vo.BannerVo;
import io.music.app.common.network.HttpServer;
import io.music.app.common.network.observer.BaseObserver;
import io.music.app.ui.model.PageHome;

/**
 * @author liuguofeng
 * @date 2022/12/09 23:16
 **/
public class PageHomeViewModel extends ViewModel {

    private PageHomeApi api;
    public MutableLiveData<PageHome> pageHome;

    public MutableLiveData<PageHome> getPageHome() {
        if (pageHome == null) {
            pageHome = new MutableLiveData<>();
            api = HttpServer.createService(PageHomeApi.class);
        }
        return pageHome;
    }

    /**
     * 获取轮播图
     *
     * @return
     */
    public void getBanner() {
        HttpServer
                .applyObservable(api.banner())
                .safeSubscribe(new BaseObserver<BannerVo>() {
                    @Override
                    public void onSuccess(BannerVo result) {
                        if (result.getCode() == 200) {
                            PageHome pageHome = Objects.requireNonNull(PageHomeViewModel.this.pageHome.getValue());
                            pageHome.setBanners(result.getBanners());
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }
}
