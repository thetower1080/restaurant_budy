package com.group.project.restaurantbuddy.ui.home;

import android.net.sip.SipSession;
import android.widget.Button;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.snackbar.Snackbar;
import com.group.project.restaurantbuddy.R;
import androidx.appcompat.app.AppCompatActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

        public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);
            Button btnOpen = (Button) view.findViewById(R.id.SignIn_button);
            Button btnOpen2 = (Button) view.findViewById(R.id.SignUp_button);
            btnOpen.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent in =  new Intent(getActivity(),com.group.project.restaurantbuddy.SignIn.class);
                    startActivity(in);

                    }


            });

            btnOpen2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent in =  new Intent(getActivity(),com.group.project.restaurantbuddy.SignUp.class);
                    startActivity(in);

                }


            });


            return view;

    }


            };

