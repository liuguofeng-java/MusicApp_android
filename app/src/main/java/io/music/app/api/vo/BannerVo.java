package io.music.app.api.vo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

import io.music.app.BR;

/**
 * 获取轮播图实体
 * @author liuguofeng
 * @date 2022/12/09 23:51
 **/
public class BannerVo extends BaseObservable{
    private List<Banners> banners;
    private int code;

    @Bindable
    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class Banners extends BaseObservable {
        //id
        private String bannerId;

        //类型
        private Integer targetType;

        //类型提示
        private String typeTitle;

        //轮播图图片
        private String pic;

        @Bindable
        public String getBannerId() {
            return bannerId;
        }

        public void setBannerId(String bannerId) {
            this.bannerId = bannerId;
        }

        @Bindable
        public Integer getTargetType() {
            return targetType;
        }

        public void setTargetType(Integer targetType) {
            this.targetType = targetType;
        }

        @Bindable
        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
            notifyPropertyChanged(BR.bannerId);
        }

        @Bindable
        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
            notifyPropertyChanged(BR.bannerId);
        }
    }
}
