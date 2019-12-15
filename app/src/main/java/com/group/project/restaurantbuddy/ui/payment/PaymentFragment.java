package com.group.project.restaurantbuddy.ui.payment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.group.project.restaurantbuddy.R;
import com.group.project.restaurantbuddy.ui.cart.CartData;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment extends Fragment {

    private PaymentViewModel mViewModel;

    public static PaymentFragment newInstance() {
        return new PaymentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.payment_fragment, container, false);
        TextView totalView = rootView.findViewById(R.id.payment_total);
        List<String[]> cartContent = new ArrayList<>();
        cartContent = CartData.getCardData();
        if(!cartContent.isEmpty()){
            totalView.setText("Total: $" + calculateTotal(cartContent));
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PaymentViewModel.class);
        // TODO: Use the ViewModel
    }

    private float calculateTotal(List<String[]> cartContent){

        float total = 0;

        for(String[] eachItem : cartContent){
            total += Float.parseFloat(eachItem[5]);
        }
        return total;
    }
}
