package com.el_ezz.geofancing;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

public class LocationListener implements android.location.LocationListener {
    Context context;


    public LocationListener(Context context) {
        this.context = context;
    }

    @Override
    public void onLocationChanged(Location location) {
       Toast.makeText(context,"log"+Double.toString(location.getLongitude())+",lat"+Double.toString(location.getAltitude()),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(context,"GPS status is changed"+"provider"+provider+",status"+Integer.toString(status),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(context,"GPS is On",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {

        Toast.makeText(context,"GPS is Off",Toast.LENGTH_LONG).show();
    }


}