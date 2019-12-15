package com.group.project.restaurantbuddy.ui.food;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MenuViewModel extends AndroidViewModel {

    public MenuViewModel(@NonNull Application application) {
        super(application);
    }

    //private String closestPlace = "IHOP";

    public void loadLocation() throws SQLException, IOException {

        LocationHelper.getNearbyPlace(getApplication());
    }
}

//DataBaseHelper openHelper = new DataBaseHelper(this.getApplication().getApplicationContext());
//openHelper.openDataBase();
//SQLiteDatabase userDb = openHelper.getReadableDatabase();

            /*Cursor cursor = userDb.rawQuery("SELECT * FROM ihop", null);
            int columnsCount = cursor.getColumnCount();

            while (cursor.moveToNext()) {
                String[] row = new String[columnsCount];
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row[i] = cursor.getString(i);
                }
                items.add(row);
            }*/