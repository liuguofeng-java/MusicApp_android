package io.music.app.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.music.app.R;
import io.music.app.base.BaseActivity;
import io.music.app.databinding.ActivityMainBinding;
import io.music.app.ui.model.MainModel;
import io.music.app.ui.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainViewModel();
        viewModel.getMainModel().setValue(new MainModel(){{
            setName("你好");
        }});
        MutableLiveData<MainModel> mainModel = viewModel.getMainModel();
        mainModel.observe(this, t -> binding.setViewModel(viewModel));

    }


    @Override
    protected void initData() {

    }



}