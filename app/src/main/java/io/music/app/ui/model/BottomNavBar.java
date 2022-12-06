package io.music.app.ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

import io.music.app.BR;

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
        private boolean isMsg;
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
