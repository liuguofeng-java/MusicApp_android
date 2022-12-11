package io.music.app.ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

import io.music.app.BR;
import io.music.app.api.vo.BannerVo;


/**
 * @author liuguofeng
 * @date 2022/12/06 15:18
 **/
public class PageHome extends BaseObservable {
    //轮播图数据
    private List<BannerVo.Banners> banners;

    @Bindable
    public List<BannerVo.Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerVo.Banners> banners) {
        this.banners = banners;
        notifyPropertyChanged(BR.banners);
    }
}
