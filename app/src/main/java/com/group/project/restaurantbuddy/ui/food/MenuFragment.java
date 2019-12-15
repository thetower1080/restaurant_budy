package com.group.project.restaurantbuddy.ui.food;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group.project.restaurantbuddy.R;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MenuFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static RecyclerView.Adapter mAdapter;
    private static RecyclerView.LayoutManager layoutManager;
    private static View rootView;
    private static FragmentActivity activity;
    private static MenuViewModel menuViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = rootView.findViewById(R.id.my_recycler_view);
        activity = getActivity();


        menuViewModel = ViewModelProviders.of(this).get(MenuViewModel.class);
        try {
            menuViewModel.loadLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    public static void loadMenuItems(List<String[]> menuItems, boolean locationConfirmed){

        if(locationConfirmed) {
            recyclerView.setLayoutManager(layoutManager);
            mAdapter = new MyAdapter(menuItems, activity);
            recyclerView.setAdapter(mAdapter);
        }else{

        }
    }

    public static void loadMenuData(String closestPlace) {
        FirebaseHelper firebaseHelper = new FirebaseHelper();
        firebaseHelper.loadMenuData(closestPlace.toLowerCase());

    }
}