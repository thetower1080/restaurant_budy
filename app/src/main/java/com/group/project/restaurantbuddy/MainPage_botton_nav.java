package com.group.project.restaurantbuddy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.group.project.restaurantbuddy.ui.food.MenuFragment;
import com.group.project.restaurantbuddy.ui.cart.CartPage_fragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainPage_botton_nav extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_botton_nav);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new MainPage_fragment());

        MyApplication app = (MyApplication) getApplication();

        Toast.makeText(getApplicationContext(),app.getId(), Toast.LENGTH_LONG).show();

    }
    private  boolean loadFragment(Fragment fragement){
        if(fragement != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.f_container,fragement)
            .commit();
            return true;
        }
        return false;

    }

@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.navigation_b_main:
                fragment = new MainPage_fragment();
                break;
            case R.id.navigation_b_menu:
                fragment = new MenuFragment();
                break;
            case R.id.navigation_b_cart:
                fragment = new CartPage_fragment();


        }
        return loadFragment(fragment);
    }
}
