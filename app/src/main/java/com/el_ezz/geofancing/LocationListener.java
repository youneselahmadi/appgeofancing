package com.el_ezz.geofancing;

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
      /*  geoField = new GeomagneticField(
                Double.valueOf(location.getLatitude()).floatValue(),
                Double.valueOf(location.getLongitude()).floatValue(),
                Double.valueOf(location.getAltitude()).floatValue(),
                System.currentTimeMillis()
        );*/


       //  had lfonction hiya li tat3tik degre aba zaydi
       //  location.getBearing();
       //  hadi tat3tik lfer9 b lmitro bin lposition dyalk olpition lokhra
       //  location.distanceTo(Location b)


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