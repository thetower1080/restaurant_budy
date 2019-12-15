package com.group.project.restaurantbuddy.restaurants;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private final File DB_FILE;
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    public DataBaseHelper(Context context) {
        super(context, "Restraurants.db", null, DB_VERSION);
        DB_FILE = context.getDatabasePath("Restraurants.db");
        this.mContext = context;
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_FILE.getPath(), null, SQLiteDatabase.OPEN_READONLY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if(mDataBase != null) {
            mDataBase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}