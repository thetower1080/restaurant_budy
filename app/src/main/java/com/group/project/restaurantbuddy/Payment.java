package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group.project.restaurantbuddy.ui.payment.PaymentFragment;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PaymentFragment.newInstance())
                    .commitNow();
        }
    }
}
