package com.group.project.restaurantbuddy.ui.cart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.group.project.restaurantbuddy.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartPage_fragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    //FirebaseDatabase database;
    //DatabaseReference request;
    TextView txtTotalPrice;
    Button btnPlace;
    List<String[]> cart = new ArrayList<String[]>();
    CartAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart_page, container, false);


//        String[] order1;
//        String[] order2;
//        String[] order3;
//        String[] order4;
//        String[] order5;
//        //TextView title =(TextView) view.findViewById(R.id.cart_title);
//        String[] details;
//        MyApplication app = (MyApplication) this.getActivity().getApplication();
//
//        order1 = app._getOrder();
//        arrayList.add(order1);

      cart = CartData.getCardData();
     //Init
        recyclerView = (RecyclerView) view.findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        txtTotalPrice = (TextView) view.findViewById(R.id.total);
        btnPlace = (Button) view.findViewById(R.id.btnPlaceOrder);
        loadListFood();


        return view;
    }

    private void loadListFood(){

       //cart = CardData.getCardData();
       adapter = new CartAdapter(cart,getActivity());
       recyclerView.setAdapter(adapter);
    }
}
