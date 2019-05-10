package com.example.jimmyhou.livedatabus;

import android.arch.lifecycle.Observer;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LiveDataBus.get()
                .with("key_test", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(Main2Activity.this, "get msg--" + s, Toast.LENGTH_SHORT).show();
                    }
                });

    }
    public void sendMsg(View view) {
        LiveDataBus.get().with("key_test", String.class).postValue("nihao");
    }


}
