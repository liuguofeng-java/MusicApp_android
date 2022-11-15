package io.music.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import io.music.app.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View viewById = findViewById(R.id.but);
        viewById.setOnClickListener((v) -> {
            ToastUtil.showToastTop(this,"当前网络不可用,请检查你的网络设置");
        });
    }
}