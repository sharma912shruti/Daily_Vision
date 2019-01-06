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
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT);
                } else {
                    drawer.openDrawer(Gravity.RIGHT);
                }
            }
        });
    }

    public boolean onBackPressed() {
        if (mDrawer.isDrawerOpen(Gravity.RIGHT)) {
            mDrawer.closeDrawer(Gravity.RIGHT);
            return true;
        } else {
            return false;
        }
    }

    public void toggleMenu() {
        if (mDrawer.isDrawerOpen(Gravity.RIGHT)) {
            mDrawer.closeDrawer(Gravity.RIGHT);
        } else {
            mDrawer.openDrawer(Gravity.RIGHT);
        }
    }

}
