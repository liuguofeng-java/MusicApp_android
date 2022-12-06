package io.music.app.base;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import io.music.app.common.util.StatusBarUtil;
import io.music.app.common.util.ToastUtil;

/**
 * @author liuguofeng
 * @date 2022/11/15 10:03
 **/
public abstract class BaseActivity extends AppCompatActivity {

    private long timeMillis;

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
     *
     * @param message Toast 内容
     */
    protected void showToastTop(String message) {
        ToastUtil.showToastTop(this, message);
    }

    /**
     * 在中心弹窗Toast
     *
     * @param message Toast 内容
     */
    protected void showToastCenter(String message) {
        ToastUtil.showToastCenter(this, message);
    }

    /**
     * 在底部弹窗Toast
     *
     * @param message Toast 内容
     */
    protected void showToastBottom(String message) {
        ToastUtil.showToastBottom(this, message);
    }

    /**
     * 按两下返回退出
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                showToastBottom("再次按下退出应用程序!");
                timeMillis = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
