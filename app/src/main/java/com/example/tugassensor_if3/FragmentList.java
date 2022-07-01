package com.example.tugassensor_if3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FragmentList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);


        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {

                LatLng lok1 = new LatLng(-6.87407191252813, 107.58102452668388);
                MarkerOptions markerOptions1 = new MarkerOptions().position(lok1).title("Chi.koffiee");

                LatLng lok2 = new LatLng(-6.875804774956363, 107.58068655736902);
                MarkerOptions markerOptions2 = new MarkerOptions().position(lok2).title("Kerang Abuy");

                LatLng lok3 = new LatLng(-6.876083355070687, 107.57969432483421);
                MarkerOptions markerOptions3 = new MarkerOptions().position(lok3).title("Hanayosi");

                LatLng lok4 = new LatLng(-6.8750032333086, 107.58069777328726);
                MarkerOptions markerOptions4 = new MarkerOptions().position(lok4).title("Kedai Ceuceu");

                LatLng lok5 = new LatLng(-6.874613473774613, 107.5809811090421);
                MarkerOptions markerOptions5 = new MarkerOptions().position(lok5).title("Dapur Rizki");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lok3,15));
                googleMap.addMarker(markerOptions1);
                googleMap.addMarker(markerOptions2);
                googleMap.addMarker(markerOptions3);
                googleMap.addMarker(markerOptions4);
                googleMap.addMarker(markerOptions5);


            });
        }
        else {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        return view;
    }
}