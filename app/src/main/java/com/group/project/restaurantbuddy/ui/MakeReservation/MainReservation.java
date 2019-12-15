package com.group.project.restaurantbuddy.ui.MakeReservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.group.project.restaurantbuddy.R;

public class MainReservation extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        Button  btnFindTable = (Button) view.findViewById(R.id.button1_from_reservation);
        Button  btnMakeReservation = (Button) view.findViewById(R.id.button2_from_reservation);
        //Button  btnCancelReservation = (Button) view.findViewById(R.id.button3_from_reservation);

        btnFindTable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in =  new Intent(getActivity(),com.group.project.restaurantbuddy.FindTable.class);
                startActivity(in);

            }


        });

        btnMakeReservation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent in =  new Intent(getActivity(),com.group.project.restaurantbuddy.ManageReservation.class);
                startActivity(in);

            }


        });

        return view;

    }

}



