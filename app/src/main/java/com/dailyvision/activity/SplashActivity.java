package com.dailyvision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.dailyvision.R;

/**
 * Created by ssharma on 04,January,2019
 **/
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openHomeScreen();
    }

    private void openHomeScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(SplashActivity.this, MainActivity.class));
              finish();
            }
        },2000);
    }
}
