package com.dailyvision.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.dailyvision.R;
import com.dailyvision.custom_views.GothamTextViewBook;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ssharma on 04,January,2019
 **/
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.tag_line)
    GothamTextViewBook mTagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setText();
        openHomeScreen();
    }

    private void setText(){
        mTagLine.setText(getString(R.string.have_a_look_on_your_daily_updates_with_us) + getEmojiByUnicode(0x1F60A));
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    private void openHomeScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(SplashActivity.this, HomeActivity.class));
              finish();
            }
        },2000);
    }
}
