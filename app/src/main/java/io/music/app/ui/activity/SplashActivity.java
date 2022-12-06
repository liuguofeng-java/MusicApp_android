package io.music.app.ui.activity;

import androidx.annotation.RequiresApi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import io.music.app.R;
import io.music.app.base.BaseActivity;
import io.music.app.common.util.StatusBarUtil;

/**
 * 启动页
 * @author liuguofeng
 * @date 2022-11-14
 */
public class SplashActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_MusicApp_android);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //设置自动收起导航栏和状态栏
        StatusBarUtil.setPackUpStatusBar(this);
        //设置状态栏颜色
        StatusBarUtil.setTransparent(this);
        initData();
    }

    protected void initData() {
        //3s跳转到主页
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.transition_in, R.anim.transition_out);
                finish();
            }
        };
        new Timer().schedule(task,3000);
    }
}