package com.dailyvision.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.dailyvision.R;
import com.dailyvision.custom_views.NavigationDrawerManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ssharma on 04,January,2019
 **/
public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.button)
    TextView mButton;

    private NavigationDrawerManager mNavigationDrawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setToolBar(getResources().getString(R.string.home_screen), mToolbar);
        setupNavigationDrawer(mDrawer);
    }

    @Override
    public void onBackPressed() {
        if (!mNavigationDrawerManager.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.button)
    void onHelloClick(){
        startActivity(new Intent(this,MapsActivity.class));
    }

    @SuppressLint("RestrictedApi")
    private void setToolBar(String string, Toolbar mToolbar){
        setSupportActionBar(mToolbar);
//        setHeader(getResources().getString(R.string.home_screen), mToolbar);
    }

    @OnClick(R.id.menu_icon)
    void toggleMenu() {
        mNavigationDrawerManager.toggleMenu();
    }


    private void setupNavigationDrawer(DrawerLayout drawer) {
        mNavigationDrawerManager = new NavigationDrawerManager(this, drawer);
    }
}
