package io.music.app.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import io.music.app.util.StatusBarUtil;

/**
 * @author liuguofeng
 * @date 2022/11/15 10:03
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //给子类提供一个获取activity对象的方式
    public Activity getActivity() {
        return this;
    }
}
