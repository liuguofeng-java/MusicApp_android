package io.music.app.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.music.app.ui.model.BottomNavBar;

/**
 * @author liuguofeng
 * @date 2022/12/06 15:19
 **/
public class BottomNavBarViewModel extends ViewModel {
    public MutableLiveData<BottomNavBar> bar;

    public MutableLiveData<BottomNavBar> getBar(){
        if(bar == null){
            bar = new MutableLiveData<>();
        }
        return bar;
    }
}
