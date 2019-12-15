package com.group.project.restaurantbuddy;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class SignUp extends AppCompatActivity {

    Database userDb;
    EditText editName, editEmail, editPhone, editPassword;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        userDb = new Database(this);
        setContentView(R.layout.fragment_signup);
        editName = (EditText) findViewById(R.id.editText_Name);
        editEmail = (EditText) findViewById(R.id.editText_Email);
        editPhone = (EditText) findViewById(R.id.editText_Phone);
        editPassword = (EditText) findViewById(R.id.editText_Password);

        btnAddData = (Button) findViewById(R.id.button_add);

        AddData();

    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        boolean isInserted = userDb.insertData(editName.getText().toString(),
                                editEmail.getText().toString(),
                                editPhone.getText().toString(),
                                editPassword.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                    }
                }

        );
    }

    }
