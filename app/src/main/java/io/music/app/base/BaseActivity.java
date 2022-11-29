package io.music.app.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.music.app.common.util.StatusBarUtil;
import io.music.app.common.util.ToastUtil;

/**
 * @author liuguofeng
 * @date 2022/11/15 10:03
 **/
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏状态栏
        StatusBarUtil.setStatusBarColor(this);

        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 在顶部弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastTop(String message){
        ToastUtil.showToastTop(this, message);
    }

    /**
     * 在中心弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastCenter(String message){
        ToastUtil.showToastCenter(this, message);
    }

    /**
     * 在底部弹窗Toast
     * @param message Toast 内容
     */
    protected void showToastBottom(String message){
        ToastUtil.showToastBottom(this, message);
    }

}
