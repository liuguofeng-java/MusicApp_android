package io.music.app.ui.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.music.app.ui.model.MainModel;
import io.music.app.util.ToastUtil;

/**
 * @author liuguofeng
 * @date 2022/11/20 17:23
 **/
public class MainViewModel extends ViewModel {
    public MutableLiveData<MainModel> model;

    public MutableLiveData<MainModel> getMainModel(){
        if(model == null){
            model = new MutableLiveData<>();
        }
        return model;
    }

    public void onClick(View v) {

    }


}
