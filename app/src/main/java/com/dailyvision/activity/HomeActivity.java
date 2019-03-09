package com.dailyvision.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.dailyvision.R;
import com.dailyvision.custom_views.NavigationDrawerManager;
import com.dailyvision.models.LocationModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ssharma on 04,January,2019
 **/
public class HomeActivity extends BaseActivity {

    private final static String TAG = "Value_Listner";
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.button)
    TextView mButton;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReferenceToPutData;
    private NavigationDrawerManager mNavigationDrawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setToolBar(getResources().getString(R.string.home_screen), mToolbar);
        setupNavigationDrawer(mDrawer);
        initialiseFCMDatabase();
        writeNewLocation("Ujjain",22.7196,75.8577);
    }

    private void initialiseFCMDatabase() {
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReferenceToPutData = mDatabase.getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Log.d(TAG,"OnDatachange");
//                Post post = dataSnapshot.getValue(Post.class);
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabaseReferenceToPutData.addValueEventListener(postListener);
    }

    private void writeNewLocation(String cityName, Double latitude,Double longitude) {
        LocationModel locationModel = new LocationModel(cityName,latitude,longitude);
        mDatabaseReferenceToPutData.child("location").child(cityName).setValue(locationModel);
    }

    @Override
    public void onBackPressed() {
        if (!mNavigationDrawerManager.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.button)
    void onHelloClick() {
        startActivity(new Intent(this, MapsActivity.class));
    }

    @SuppressLint("RestrictedApi")
    private void setToolBar(String string, Toolbar mToolbar) {
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
