package io.music.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import io.music.app.R;
import io.music.app.entity.EventEntity;

/**
 * 侧边栏导航中菜单
 *
 * @author liuguofeng
 * @date 2022/11/16 16:59
 **/
public class NavMenuLinearLayout extends LinearLayout {

    //父控件标识
    private int menuId;

    @BindView(R.id.menu_container)
    RelativeLayout menuContainer;

    @BindView(R.id.menu_icon)
    View menuIconView;

    @BindView(R.id.menu_name)
    TextView menuNameView;

    @BindView(R.id.menu_sub_name)
    TextView menuSubNameView;

    @BindView(R.id.menu_msg_num)
    TextView menuMsgNumView;

    @BindView(R.id.right_arrow)
    View rightArrow;

    @BindView(R.id.menu_switch)
    SwitchCompat menuSwitchView;


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
            //父控件标识
            menuId = typedArray.getResourceId(R.styleable.NavMenuLinearLayout_menu_id, 0);
            //图标
            int menuIcon = typedArray.getResourceId(R.styleable.NavMenuLinearLayout_menu_icon, 0);
            //标题
            String menuName = typedArray.getString(R.styleable.NavMenuLinearLayout_menu_name);
            //副标题
            String menuSubName = typedArray.getString(R.styleable.NavMenuLinearLayout_menu_sub_name);
            //消息提示标志
            int menuMsgNum = typedArray.getInt(R.styleable.NavMenuLinearLayout_menu_msg_num, 0);
            //开关按钮
            int menuSwitch = typedArray.getInt(R.styleable.NavMenuLinearLayout_menu_switch, -1);


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.view_menu_linear, this, true);
            ButterKnife.bind(view);

            //图标
            if (menuIcon == 0) {
                menuIconView.setVisibility(View.GONE);
            } else {
                menuIconView.setBackgroundResource(menuIcon);
            }

            //菜单名称
            if (menuName == null) {
                menuNameView.setVisibility(View.GONE);
            } else {
                menuNameView.setText(menuName);
            }

            //副标题
            if (menuSubName == null) {
                menuSubNameView.setVisibility(View.GONE);
            } else {
                menuSubNameView.setText(menuSubName);
            }

            //消息提示标志
            if (menuMsgNum == 0) {
                menuMsgNumView.setVisibility(View.GONE);
            } else {
                menuMsgNumView.setText(String.valueOf(menuMsgNum));
            }

            //开关按钮
            if (menuSwitch == -1) {
                menuSwitchView.setVisibility(View.GONE);
            } else {
                rightArrow.setVisibility(View.GONE);
                menuSwitchView.setChecked(menuSwitch == 1);
            }
            typedArray.recycle();
        }
    }

    /**
     * 点击菜单容器改变开关状态
     */
    @OnClick(R.id.menu_container)
    public void onClick() {
        if (menuSwitchView.getVisibility() != View.GONE) {
            boolean clickable = menuSwitchView.isChecked();
            menuSwitchView.setChecked(!clickable);
        } else {
            EventBus.getDefault().post(new EventEntity<Boolean>() {{
                setId(menuId);
            }});
        }
    }

    /**
     * 开关改变时
     *
     * @param buttonView
     * @param isChecked
     */
    @OnCheckedChanged(R.id.menu_switch)
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        EventBus.getDefault().post(new EventEntity<Boolean>() {{
            setServiceId("menu_switch");
            setId(menuId);
            setData(isChecked);
        }});
    }

}
