package com.example.mac.flickrbrowser;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by mac on 1/30/17.
 */

public class BaseActivity extends AppCompatActivity {
    static final String FLICKR_QUERY = "FLICKR_QUERY";
    static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";
    private final String TAG = "BaseActivity";

    void activateToolBar(boolean enableHome) {
        Log.d(TAG, "activateToolBar: starts");
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

            if (toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }


        }

        if (actionBar != null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(enableHome);
        }
    }
}
