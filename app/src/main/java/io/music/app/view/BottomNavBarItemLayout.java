package io.music.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.music.app.R;

/**
 * 底部菜单item
 *
 * @author liuguofeng
 * @date 2022/12/05 11:34
 **/
public class BottomNavBarItemLayout extends LinearLayout {
    //默认图标
    private int barIcon;
    //选中的图标
    private int barIconSelect;
    //菜单名称
    private String barName;
    //是否显示消息提示
    private boolean barMsg;
    //是否选中
    private boolean barIsSelect;

    //菜单图标
    @BindView(R.id.bar_img)
    ImageView barImgView;

    //菜单文字
    @BindView(R.id.bar_text)
    TextView barTextView;

    //菜单消息
    @BindView(R.id.bar_msg)
    View barMsgView;

    public BottomNavBarItemLayout(Context context) {
        super(context);
    }

    public BottomNavBarItemLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        dealAttrs(context, attrs);
    }

    public BottomNavBarItemLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        dealAttrs(context, attrs);
    }

    private void dealAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomNavBarItem);
        if (typedArray != null) {
            //图标
            barIcon = typedArray.getResourceId(R.styleable.BottomNavBarItem_bar_icon, 0);
            //选中图标
            barIconSelect = typedArray.getResourceId(R.styleable.BottomNavBarItem_bar_icon_select, 0);
            //菜单名称
            barName = typedArray.getString(R.styleable.BottomNavBarItem_bar_name);
            //消息提示标志
            barMsg = typedArray.getBoolean(R.styleable.BottomNavBarItem_bar_msg, false);
            barIsSelect = typedArray.getBoolean(R.styleable.BottomNavBarItem_bar_is_select, false);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.view_bottom_nav_bar_item, this, true);
            ButterKnife.bind(view);

            //是否选中
            setBarIsSelect(this, barIsSelect);
            //设置菜单文字
            setBarName(barName);

            //是否显示消息提示
            setBarMsg(this, barMsg);

            typedArray.recycle();
        }
    }


    public void setBarName(String barName) {
        this.barName = barName;
        barTextView.setText(barName);
    }

    @BindingAdapter("bar_msg")
    public static void setBarMsg(BottomNavBarItemLayout view, boolean barMsg) {
        view.setBarMsg(barMsg);
        view.getBarMsgView().setVisibility(!barMsg ? View.GONE : View.VISIBLE);
    }

    @BindingAdapter("bar_is_select")
    public static void setBarIsSelect(BottomNavBarItemLayout view, boolean barIsSelect) {
        view.setBarIsSelect(barIsSelect);
        ImageView barImgView = view.getBarImgView();
        TextView barTextView = view.getBarTextView();
        if (barIsSelect) {
            barImgView.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(),view.getBarIconSelect(),null));
            barTextView.setTextColor(view.getResources().getColor(R.color.color_bottom_tab_bar_select_text));
        } else {
            barImgView.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(),view.getBarIcon(),null));
            barTextView.setTextColor(view.getResources().getColor(R.color.color_bottom_tab_bar_text));
        }
    }

    public ImageView getBarImgView() {
        return barImgView;
    }

    public TextView getBarTextView() {
        return barTextView;
    }

    public View getBarMsgView() {
        return barMsgView;
    }

    public int getBarIcon() {
        return barIcon;
    }

    public int getBarIconSelect() {
        return barIconSelect;
    }

    public void setBarMsg(boolean barMsg) {
        this.barMsg = barMsg;
    }

    public void setBarIsSelect(boolean barIsSelect) {
        this.barIsSelect = barIsSelect;
    }
}
