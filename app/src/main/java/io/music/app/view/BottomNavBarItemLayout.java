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
    //父控件标识
    private int barId;
    //默认图标
    private int barIcon;
    //选中的图标
    private int barIconSelect;

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
            //父控件标识
            barId = typedArray.getResourceId(R.styleable.BottomNavBarItem_bar_id, 0);
            //图标
            barIcon = typedArray.getResourceId(R.styleable.BottomNavBarItem_bar_icon, 0);
            //选中图标
            barIconSelect = typedArray.getResourceId(R.styleable.BottomNavBarItem_bar_icon_select, 0);
            //菜单名称
            String barName = typedArray.getString(R.styleable.BottomNavBarItem_bar_name);
            //消息提示标志
            boolean barMsg = typedArray.getBoolean(R.styleable.BottomNavBarItem_bar_msg, false);
            boolean barIsSelect = typedArray.getBoolean(R.styleable.BottomNavBarItem_bar_is_select, false);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.view_bottom_nav_bar_item, this, true);
            ButterKnife.bind(view);

            //是否选中
            if (barIsSelect) {
                barImgView.setImageDrawable(getResources().getDrawable(barIconSelect));
                barTextView.setTextColor(getResources().getColor(R.color.color_bottom_tab_bar_select_text));
            } else {
                barImgView.setImageDrawable(getResources().getDrawable(barIcon));
                barTextView.setTextColor(getResources().getColor(R.color.color_bottom_tab_bar_text));
            }
            //设置菜单文字
            barTextView.setText(barName);

            //是否显示消息提示
            barMsgView.setVisibility(!barMsg ? View.GONE : View.VISIBLE);

            typedArray.recycle();
        }
    }

}
