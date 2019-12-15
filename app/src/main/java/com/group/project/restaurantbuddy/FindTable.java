package com.group.project.restaurantbuddy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FindTable extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    reserveDatabase reserveDB;
    Button btnAddData;

    EditText chooseTime, editName;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;

    private static final String TAG = "FindTable";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reserveDB = new reserveDatabase(this);
        setContentView(R.layout.fragment_choose_date_time);
        editName = (EditText) findViewById(R.id.reservationName);
        mDisplayDate = (TextView) findViewById(R.id.textViewDate);
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tableNumbers, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout .simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FindTable.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });
        //setContentView(R.layout.fragment_choose_date_time);
        chooseTime = findViewById(R.id.textViewTime);
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(FindTable.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        btnAddData = (Button) findViewById(R.id.submitBtn);
        AddData();
    }

     public void AddData() {
       btnAddData.setOnClickListener(
             new View.OnClickListener() {
               @Override
            public void onClick(View v) {

               boolean isInserted = reserveDB.insertData(mDisplayDate.getText().toString(),chooseTime.getText().toString(), chooseTime.getText().toString(),editName.getText().toString());
                if (isInserted = true)
                Toast.makeText(FindTable.this, "DATA INSERTED", Toast.LENGTH_SHORT).show();
                else
                Toast.makeText(FindTable.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        }
    );
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}




//SELECT DATE AND TIME:
    /*
    Show Available table platform (IMAGE)
     Select table to reserve
    Access ReservationDB
    Reserve Table/Table taken already
    Set Reservation DATE TIME NAME
    Go Back
    */

