package com.example.covid19;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class CenterMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng CHU = new LatLng(45.5052584,-73.5640771);
    LatLng Cavendish = new LatLng(45.4761,-73.6657);
    LatLng CDE = new LatLng(45.5777,-73.6816);
    LatLng MontréalNord = new LatLng(45.564530,-73.644610);
    LatLng GMF_MédiCentre = new LatLng(45.454671,-73.697328);
    LatLng CliniqueChauveau = new LatLng(45.5705746,-73.5500395);
    LatLng MonetChartrand = new LatLng(45.5362942,-73.4606453);
    LatLng ArenaSaintFrançois = new LatLng(45.6759887,-73.581904);
    LatLng Beaconsfield = new LatLng(45.4351768,-73.8540716);
    LatLng SorelTracy = new LatLng(45.7783832,-73.6623309);

    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    private static final int LOCATION_REQUEST_CODE = 1;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_maps);
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_REQUEST_CODE);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(CHU);
        arrayList.add(Cavendish);
        arrayList.add(CDE);
        arrayList.add(MontréalNord);
        arrayList.add(GMF_MédiCentre);
        arrayList.add(CliniqueChauveau);
        arrayList.add(MonetChartrand);
        arrayList.add(ArenaSaintFrançois);
        arrayList.add(Beaconsfield);
        arrayList.add(SorelTracy);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

       for(int i=0 ; i<arrayList.size() ; i++){
           mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Covid-19 Test Center").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
           mMap.animateCamera(CameraUpdateFactory.zoomTo(21f));
           mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
       }

    }


}
