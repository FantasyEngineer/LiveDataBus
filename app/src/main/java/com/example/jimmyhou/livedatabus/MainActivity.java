package com.example.jimmyhou.livedatabus;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LiveDataBus.get()
                .with("key_test", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(MainActivity.this, "get msg--" + s, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void sendMsg(View view) {
        LiveDataBus.get().with("key_test", String.class).postValue("nihao");

    }

    public void jump(View view) {

        startActivity(new Intent(this, Main2Activity.class));
    }
}
