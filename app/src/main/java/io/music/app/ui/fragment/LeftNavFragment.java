package io.music.app.ui.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.music.app.R;
import io.music.app.base.BaseFragment;

/**
 * 侧边栏
 */
public class LeftNavFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_left_nav, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @OnClick({R.id.close_app_but, R.id.login_but,
            R.id.scan_code, R.id.nav_vip,
            R.id.menu_msg,R.id.menu_cloud_bei,
            R.id.menu_ticket, R.id.menu_empty_sack,
            R.id.menu_mall, R.id.menu_beat,
            R.id.menu_ringtone, R.id.menu_game,
            R.id.menu_setting, R.id.menu_dark_model,
            R.id.menu_timing, R.id.menu_theme,
            R.id.menu_download, R.id.menu_free_traffic,
            R.id.menu_ring_bell, R.id.menu_order,
            R.id.menu_coupon, R.id.menu_service,
            R.id.menu_share, R.id.menu_bang
    })
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_app_but://关闭应用程序
                System.exit(0);
                break;
            default:
                showToastTop("该功能还没有!");
                break;
        }
    }
}