package io.music.app.common.enevt;

/**
 * 事件类型
 *
 * @author liuguofeng
 * @date 2022/12/07 09:10
 **/
public enum ServiceEvent {

    MENU_SWITCH("menu_switch", "菜单开关滑动"),

    BOTTOM_TAB_BAR("bottom_tab_bar", "底部导航点击");

    /**
     * 编号
     */
    private final String code;
    /**
     * 备注
     */
    private final String remark;

    ServiceEvent(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }
}
