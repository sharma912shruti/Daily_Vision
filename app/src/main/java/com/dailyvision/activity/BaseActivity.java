package com.dailyvision.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.dailyvision.R;

/**
 * Created by ssharma on 06,January,2019
 **/
public class BaseActivity extends AppCompatActivity {

    public void setHeader(String title, Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
        TextView titleView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        titleView.setText(title);
    }
}
