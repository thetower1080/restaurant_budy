package com.group.project.restaurantbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class reserveDatabase extends SQLiteOpenHelper {

    //variables to assign db names:
    public static final String DATABASE_NAME = "reservation.db";
    public static final String TABLE_RESERVE= "reservation_table";


    public static final String Col_1_reservation_id= "ID";
    public static final String Col_2_reservation_date = "rdate";
    public static final String Col_3_reservation_time = "rtime";
    public static final String Col_4_reservation_table = "rtable";
    public static final String Col_5_reservation_name = "rname";


   //String createReservationTable = "create table " + TABLE_RESERVE +
     //       "( ID INTEGER ," +
       //     " RDATE TEXT, " +
         //   " RTIME TEXT, " +
           // " RTABLE TEXT, " +
         //   " RNAME TEXT, " +
          //  "FOREIGN KEY(ID) REFERENCES TABLE_NAME(ID));";

    //private static final String CREATE_TABLE_RESERVATIONS = "CREATE TABLE "
    //      + TABLE_NAME3 + "(" + Col_1_reservation_id
    //    + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    //     + Col_2_reservation_date  + " TEXT,"
    //    + Col_3_reservation_time + " TEXT,"
    //    + Col_4_reservation_table + " TEXT,"
    //    + Col_5_reservation_name + "TEXT );";


    //Function to create Database table
    public reserveDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //Create DB and Table:
        //SQLiteDatabase db = this.getWritableDatabase();
        //Log.d("table", CREATE_TABLE_RESERVATIONS);
    }


    //Executes quary
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_RESERVE +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, RDATE TEXT,RTIME TEXT,RTABLE TEXT,RNAME TEXT)");
        // db.execSQL("create table " + TABLE_NAME2 +" (ID INTEGER ,ORDER1 TEXT,ORDER2 TEXT,ORDER3 TEXT,ORDER4 TEXT, ORDER5 TEXT)");
        //db.execSQL("create table " + RESERVATION_TABLE +"(RESERVATIONID INTEGER PRIMARY KEY AUTOINCREMENT, DATE INT, TIME TEXT, TABLENUM TEXT, NAME TEXT)")
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_RESERVE);
        onCreate(db);
    }


    public boolean insertData(String rdate, String rtime, String rtable, String rname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2_reservation_date, rdate);
        contentValues.put(Col_3_reservation_time, rtime);
        contentValues.put(Col_4_reservation_table, rtable);
        contentValues.put(Col_5_reservation_name, rname);
        long result = db.insert(TABLE_RESERVE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
