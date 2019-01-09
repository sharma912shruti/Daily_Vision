package com.dailyvision.custom_views;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.View;

import com.dailyvision.R;


/**
 * Created by ssharma on 04,January,2019
 **/

public class NavigationDrawerManager {

    private Activity mActivity;
    DrawerLayout mDrawer;

    public NavigationDrawerManager(Activity activity, DrawerLayout drawerLayout) {
        mActivity = activity;
        mDrawer = drawerLayout;
        setup(mDrawer);
    }

    private void setup(final DrawerLayout drawer) {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mActivity, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });
    }

    public boolean onBackPressed() {
        if (mDrawer.isDrawerOpen(Gravity.LEFT)) {
            mDrawer.closeDrawer(Gravity.LEFT);
            return true;
        } else {
            return false;
        }
    }

    public void toggleMenu() {
        if (mDrawer.isDrawerOpen(Gravity.LEFT)) {
            mDrawer.closeDrawer(Gravity.LEFT);
        } else {
            mDrawer.openDrawer(Gravity.LEFT);
        }
    }

}
