package io.music.app.util;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import io.music.app.R;

/**
 * @author liuguofeng
 * @date 2022/11/15 10:15
 **/

public class ToastUtil {

    /**
     * 在顶部提示
     * @param context 上下文对象
     * @param messages toast内容
     */
    public static void showToastTop(final Activity context, final String messages) {
        showToast(context, messages,Gravity.TOP, 0, 100);
    }

    /**
     * 在底部提示
     * @param context 上下文对象
     * @param messages toast内容
     */
    public static void showToastBottom(final Activity context, final String messages) {
        showToast(context, messages,Gravity.BOTTOM, 0, 100);
    }

    /**
     * 在中心提示
     * @param context 上下文对象
     * @param messages toast内容
     */
    public static void showToastCenter(final Activity context, final String messages) {
        showToast(context, messages,Gravity.CENTER, 0, 0);
    }

    /**
     * 多线程访问集成
     * @param context 上下文对象
     * @param messages toast内容
     * @param gravity 位置
     * @param xOffset x偏移
     * @param yOffset y偏移
     */
    public static void showToast(final Activity context, final String messages,int gravity, int xOffset, int yOffset) {
        if ("main".equals(Thread.currentThread().getName())) {
            toastProcess(context, messages,gravity, xOffset, yOffset);
        } else {
            context.runOnUiThread(() -> toastProcess(context, messages,gravity, xOffset, yOffset));
        }
    }

    /**
     * 自定义toast
     * @param context  上下文对象
     * @param messages toast内容
     * @param gravity 位置
     * @param xOffset x偏移
     * @param yOffset y偏移
     */
    private static void toastProcess(Context context, String messages,int gravity, int xOffset, int yOffset) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.toast_layout, null);
        TextView text = view.findViewById(R.id.toast_content);
        text.setText(messages); //toast内容
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(gravity, xOffset, yOffset);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

}
