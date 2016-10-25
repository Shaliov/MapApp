package com.shaliovgmail.andrey.mapapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

    private GoogleMap googleMap;
    private Marker marker;
    private double lat = 0.0;
    private double lng = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        createMapView();
        addMarker(lat, lng);
    }

    private void createMapView() {
        try{
            if(googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();
            }
            if(googleMap == null) {
                Toast.makeText(getApplicationContext(), "Error creating Map", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e) {
            Log.e("mapApp", e.toString());
        }
    }

    private void addMarker(double lat, double lng) {
        if(googleMap != null) {
            googleMap.addMarker(new MarkerOptions()
                                                .position(new LatLng(lat, lng))
                                                .title("test")
                                                .draggable(true));
        }

    }
}
