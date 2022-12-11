package io.music.app.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.adapter.BannerAdapter;
import io.music.app.api.vo.BannerVo;
import io.music.app.ui.activity.MainActivity;

/**
 * 自定义轮播图
 *
 * @author liuguofeng
 * @date 2022/12/10 18:58
 **/
public class BannerLayout extends LinearLayout {

    @BindView(R.id.banner_view_page)
    ViewPager pager;

    private Timer timer;

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
    }

    @BindingAdapter("network_url")
    public static void setNetworkUrl(BannerLayout view, List<BannerVo.Banners> picList) {
        if (picList == null || picList.size() == 0) return;
        view.getPager().setAdapter(new BannerAdapter(view.getContext(), picList));
        startTimer(view);
    }

    /**
     * 定时器用于播放轮播图
     *
     * @param view 当前实例
     */
    public static void startTimer(BannerLayout view) {
        ViewPager pager = view.getPager();
        // 先停止
        stopTimer(view);
        Timer timer = new Timer();
        view.setTimer(timer);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    activity.runOnUiThread(() -> {
                        int currentItem = pager.getCurrentItem();
                        pager.setCurrentItem(currentItem + 1);
                    });
                }
            }
        };
        timer.schedule(timerTask, 5000, 5000);
    }


    /**
     * 停止当前实例自动轮播
     *
     * @param view 当前实例
     */
    public static void stopTimer(BannerLayout view) {
        Timer timer = view.getTimer();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void setTimer(Timer timer) {
        this.timer = timer;
    }

    private Timer getTimer() {
        return timer;
    }

    private ViewPager getPager() {
        return pager;
    }
}
