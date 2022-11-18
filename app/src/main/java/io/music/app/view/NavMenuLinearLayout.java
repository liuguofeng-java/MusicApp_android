package io.music.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import io.music.app.R;

/**
 * 侧边栏导航中菜单
 *
 * @author liuguofeng
 * @date 2022/11/16 16:59
 **/
public class NavMenuLinearLayout extends LinearLayout {
    //图标
    private int menuIcon;
    //标题
    private String menuName;
    //副标题
    private String menuSubName;
    //消息提示标志
    private int menuMsgNum;

    public NavMenuLinearLayout(Context context) {
        super(context);
    }

    public NavMenuLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        dealAttrs(context, attrs);

    }

    public NavMenuLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        dealAttrs(context, attrs);
    }

    private void dealAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavMenuLinearLayout);
        if (typedArray != null) {
            menuIcon = typedArray.getResourceId(R.styleable.NavMenuLinearLayout_menu_icon, 0);
            menuName = typedArray.getString(R.styleable.NavMenuLinearLayout_menu_name);
            menuSubName = typedArray.getString(R.styleable.NavMenuLinearLayout_menu_sub_name);
            menuMsgNum = typedArray.getInt(R.styleable.NavMenuLinearLayout_menu_msg_num, menuMsgNum);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.menu_linear_layout, this, true);
            View menuIconView = view.findViewById(R.id.menu_icon);
            if(menuIcon == 0){
                menuIconView.setVisibility(View.GONE);
            }else{
                menuIconView.setBackgroundResource(menuIcon);
            }

            TextView menuNameView = view.findViewById(R.id.menu_name);
            if(menuName == null){
                menuNameView.setVisibility(View.GONE);
            }else{
                menuNameView.setText(menuName);
            }

            TextView menuSubNameView = view.findViewById(R.id.menu_sub_name);
            if(menuSubName == null){
                menuSubNameView.setVisibility(View.GONE);
            }else{
                menuSubNameView.setText(menuSubName);
            }

            TextView menuMsgNumView = view.findViewById(R.id.menu_msg_num);
            if(menuMsgNum == 0){
                menuMsgNumView.setVisibility(View.GONE);
            }else{
                menuMsgNumView.setText(String.valueOf(menuMsgNum));
            }

            typedArray.recycle();
        }
    }





}
