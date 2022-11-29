package io.music.app.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.music.app.R;
import io.music.app.api.DemoApi;
import io.music.app.base.BaseActivity;
import io.music.app.common.network.HttpServer;
import io.music.app.common.network.observer.BaseObserver;

public class MainActivity extends BaseActivity {

    @BindView(R.id.but)
    Button button;

    private DemoApi demoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        demoApi = HttpServer.createService(DemoApi.class);
    }


    @OnClick({R.id.but})
    void onclick(){
        showToastBottom("xxxx");
    }


    @Override
    protected void initData() {

        HttpServer
                .applyObservable(demoApi.playlistDetail(1))
                .safeSubscribe(new BaseObserver<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {

            }

            @Override
            public void onFailure(Throwable e) {

            }
        });

    }


}