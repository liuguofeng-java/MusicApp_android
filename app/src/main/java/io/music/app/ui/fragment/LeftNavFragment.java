package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import io.music.app.R;
import io.music.app.base.BaseFragment;
import io.music.app.common.enevt.EventEntity;
import io.music.app.common.enevt.ServiceEvent;

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
        if(!messageEvent.getServiceId().equals(ServiceEvent.MENU_SWITCH.getCode())) return;
        switch (messageEvent.getId()) {
            case R.id.menu_dark_model://深色模式
                if(messageEvent.getData()){
                    showToastTop("深色模式!");
                }else{
                    showToastTop("默认模式!");
                }
                break;
            default:
                showToastTop("该功能还没有!");
                break;
        }
    }

    @Override
    public void onDestroy() {
        //解除注册
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}