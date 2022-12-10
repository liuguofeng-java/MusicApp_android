package io.music.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.adapter.BannerAdapter;
import io.music.app.api.vo.BannerVo;

/**
 * 自定义轮播图
 *
 * @author liuguofeng
 * @date 2022/12/10 18:58
 **/
public class BannerLayout extends LinearLayout {
    //轮播图图片
    private List<BannerVo.Banners> picList;

    @BindView(R.id.banner_view_page)
    ViewPager pager;


    public BannerLayout(Context context) {
        super(context);
    }

    public BannerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        dealAttrs(context, attrs);
    }

    public BannerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        dealAttrs(context, attrs);
    }

    private void dealAttrs(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_banner, this, true);
        ButterKnife.bind(view);
//        pager.setAdapter(new BannerAdapter(view.getContext()));

    }

    @BindingAdapter("network_url")
    public static void setNetworkUrl(BannerLayout view, List<BannerVo.Banners> picList) {
        if(picList == null || picList.size() == 0) return;
        view.getPager().setAdapter(new BannerAdapter(view.getContext(),picList));
    }


    public ViewPager getPager() {
        return pager;
    }


    public List<BannerVo.Banners> getPicList() {
        return picList;
    }

    public void setPicList(List<BannerVo.Banners> picList) {
        this.picList = picList;
    }

}
