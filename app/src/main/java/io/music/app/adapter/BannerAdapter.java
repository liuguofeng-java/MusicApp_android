package io.music.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import io.music.app.R;
import io.music.app.api.vo.BannerVo;

/**
 * @author liuguofeng
 * @date 2022/12/10 19:49
 **/
public class BannerAdapter extends PagerAdapter {
    private final List<BannerVo.Banners> list;
    private final Context context;

    public BannerAdapter(Context context, List<BannerVo.Banners> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position %= list.size();

        View view = LayoutInflater.from(context).inflate(R.layout.view_banner_item,container,false);
        BannerVo.Banners banners = list.get(position);

        ShapeableImageView bannerImg =  view.findViewById(R.id.banner_img);
        RequestOptions OPTIONS = new RequestOptions()
                .placeholder(R.drawable.vector_picture)//图片加载出来前，显示的图片
                .fallback(R.drawable.vector_picture) //url为空的时候,显示的图片
                .error(R.drawable.vector_picture_err);//图片加载失败后，显示的图片
        Glide.with(context).load(banners.getPic()).apply(OPTIONS).into(bannerImg);

        TextView bannerTitle =  view.findViewById(R.id.banner_title);
        bannerTitle.setText(banners.getTypeTitle());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
