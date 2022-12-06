package io.music.app.ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import java.util.List;


/**
 * @author liuguofeng
 * @date 2022/12/06 15:18
 **/
public class BottomNavBar extends BaseObservable {

    private List<BottomNavBarItem> bottomNavBarItems;

    @Bindable
    public List<BottomNavBarItem> getBottomNavBarItems() {
        return bottomNavBarItems;
    }

    public void setBottomNavBarItems(List<BottomNavBarItem> bottomNavBarItems) {
        this.bottomNavBarItems = bottomNavBarItems;
    }

    public static class BottomNavBarItem extends BaseObservable {
        /**
         * 是否有消息
         */
        private boolean isMsg;
        /**
         * 是否选中
         */
        private boolean isSelect;

        @Bindable
        public boolean isMsg() {
            return isMsg;
        }

        public void setMsg(boolean msg) {
            isMsg = msg;
            notifyPropertyChanged(BR.select);
        }

        @Bindable
        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
            notifyPropertyChanged(BR.select);
        }
    }

}
