package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatDelegate;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.music.app.R;
import io.music.app.base.BaseFragment;
import io.music.app.common.util.DarkModeUtils;
import io.music.app.entity.EventEntity;

/**
 * 侧边栏
 */
public class LeftNavFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_left_nav, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    /**
     * 菜单切换按钮事件
     * @param messageEvent 事件内容
     */
    @Subscribe
    public void onEvent(EventEntity<Boolean> messageEvent) {
        switch (messageEvent.getId()) {
            case R.id.close_app_but://关闭应用程序
                System.exit(0);
                break;
            case R.id.menu_dark_model://深色模式
                if(messageEvent.getData()){
                    showToastTop("深色模式!");
                    //DarkModeUtils.applyNightMode(this.getContext());
                }else{
                    showToastTop("默认模式!");
                    //DarkModeUtils.applyDayMode(this.getContext());
                }
                break;
            default:
                showToastTop("该功能还没有!");
                break;
        }

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