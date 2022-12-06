package io.music.app.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewpager.widget.ViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.adapter.ContentPagerAdapter;
import io.music.app.api.DemoApi;
import io.music.app.base.BaseActivity;
import io.music.app.common.network.HttpServer;
import io.music.app.entity.EventEntity;
import io.music.app.ui.fragment.BottomNavBarFragment;
import io.music.app.ui.fragment.PageAccountFragment;
import io.music.app.ui.fragment.PageCommunityFragment;
import io.music.app.ui.fragment.PageConcernFragment;
import io.music.app.ui.fragment.PageHomeFragment;
import io.music.app.ui.fragment.PagePodcastFragment;

public class MainActivity extends BaseActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注解获取控件
        ButterKnife.bind(this);

        //事件
        EventBus.getDefault().register(this);
        initData();
    }


    /**
     * 初始化页面
     */
    protected void initData() {
        List<Fragment> data = new ArrayList<>();
        data.add(new PageHomeFragment());
        data.add(new PagePodcastFragment());
        data.add(new PageAccountFragment());
        data.add(new PageConcernFragment());
        data.add(new PageCommunityFragment());
        ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(this.getSupportFragmentManager(), data);
        viewPager.setAdapter(contentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //切换导航栏状态
                BottomNavBarFragment fragment = (BottomNavBarFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.bottom_nav_bar);
                assert fragment != null;
                fragment.clearBar(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    /**
     * 点击底部菜单切换页面
     * @param messageEvent 事件内容
     */
    @Subscribe
    public void onEvent(EventEntity<Integer> messageEvent) {
        if(!messageEvent.getServiceId().equals("tab_bar")) return;
        viewPager.setCurrentItem(messageEvent.getData());
    }

    /**
     * 关闭时注销事件
     */
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}