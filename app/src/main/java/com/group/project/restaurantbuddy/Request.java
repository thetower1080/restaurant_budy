package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group.project.restaurantbuddy.ui.request.RequestFragment;

public class Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RequestFragment.newInstance())
                    .commitNow();
        }
    }
}
