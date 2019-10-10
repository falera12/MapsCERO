package com.example.mapscero;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sydney = new LatLng(-34, 151);
        LatLng usil = new LatLng(-12.0726006,-76.9542409);
        LatLng asdfas = new LatLng(-12.072109425877514,-76.95155437043599);
        mMap.addMarker(new MarkerOptions().position(usil).title("USIL"));
        mMap.addMarker(new MarkerOptions().position(asdfas).title("USIL mas allacito :V "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(usil));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(asdfas));


        //Zoom
        CameraPosition posi = new CameraPosition.Builder()
                .target(usil)
                .zoom(17)//nivel 1 es para el mundo, 15 es para calles, limite es 21
                .bearing(90)//orientacion de la camara hacia el este 0-360
                .tilt(90)//3d  en grados limite es 90
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(posi));


        //Eventos
        //Clicksimple
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            mMap.addMarker(new MarkerOptions().position(latLng).title("Hola"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));


            }
        });

        //Click sostenido
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

                mMap.addMarker(new MarkerOptions().position(latLng).title("Hola"));
                CameraPosition posi2 = new CameraPosition.Builder().target(latLng)
                        .zoom(19).tilt(90).build();

                mMap.animateCamera(CameraUpdateFactory.zoomTo(3));

            }
        });




    }
}
