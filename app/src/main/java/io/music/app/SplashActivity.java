package io.music.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;
import io.music.app.util.StatusBarUtil;

/**
 * @author liuguofeng
 * @date 2022-11-14
 */
public class SplashActivity extends AppCompatActivity {

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