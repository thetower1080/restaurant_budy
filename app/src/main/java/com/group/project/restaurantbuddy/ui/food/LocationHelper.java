package com.group.project.restaurantbuddy.ui.food;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Collections;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class LocationHelper {

    public static void getNearbyPlace(Context context){

        Places.initialize(context, "AIzaSyB56qURBmiCUwoS3Z9fIuYKWaFsiQ0YHqk");
        PlacesClient placesClient = Places.createClient(context);

        List<Place.Field> placeFields = Collections.singletonList(Place.Field.NAME);

        FindCurrentPlaceRequest request =
                FindCurrentPlaceRequest.newInstance(placeFields);

        try {
            if (ContextCompat.checkSelfPermission(context, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Task<FindCurrentPlaceResponse> placeResponse = placesClient.findCurrentPlace(request);
                placeResponse.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FindCurrentPlaceResponse response = task.getResult();
                        String closestPlace = response.getPlaceLikelihoods().get(0).getPlace().getName();
                        try {
                            MenuFragment.loadMenuData(closestPlace);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    /*for (PlaceLikelihood placeLikelihood : response.getPlaceLikelihoods()) {
                            Log.i("Places API: ", String.format("Place '%s' has likelihood: %f",
                                    placeLikelihood.getPlace().getName(), placeLikelihood.getLikelihood()));
                        }*/
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            ApiException apiException = (ApiException) exception;
                            Log.e("Places API: ", "Place not found: " + apiException.getStatusCode());
                        }
                    }
                });
            } else {
                Log.e("Places API: ", "Missing Permissions");
            }
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
    }
}
