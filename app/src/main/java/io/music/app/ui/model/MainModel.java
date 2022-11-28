package io.music.app.ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import io.music.app.BR;

/**
 * @author liuguofeng
 * @date 2022/11/20 17:23
 **/
public class MainModel extends BaseObservable {

    @Bindable
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);//只通知改变的参数
    }
}
