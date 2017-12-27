package com.el_ezz.geofancing;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.LOCATION_SERVICE;


public class DetecteLocation extends Fragment {

    private Button b;
    private TextView t;
    private LocationManager locationManager;
    private LocationListener listener;


    public DetecteLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detecte_location, container, false);
        t = (TextView) view.findViewById(R.id.textView);
        b = (Button) view.findViewById(R.id.button);

        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);


        listener = new LocationListener(getActivity()) {
            @Override
            public void onLocationChanged(Location location) {

                Location targetLocation = new Location("");//provider name is unnecessary
                targetLocation.setLatitude(31.6204855);//your coords of course
                targetLocation.setLongitude(-8.0798556);
                
                //hadi tat3tik degre ta3 position li biti
                float degre = targetLocation.getBearing();
                //hadi tat3tik distance
                float distanceInMeters =  location.distanceTo(targetLocation);
                //hadi tat3tik lfer9 b degre bin joj ta3 les point
                location.bearingTo(targetLocation);

                Toast.makeText(getActivity(),"Degre : "+Double.toString(degre)+" distanceInMeters : "+Double.toString(distanceInMeters),Toast.LENGTH_LONG).show();

                t.append("\n " + location.getLongitude() + " " + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button(){
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }
        // this code won't execute IF permissions are not allowed, because in the line above there is return statement.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
            }
        });
    }

}
