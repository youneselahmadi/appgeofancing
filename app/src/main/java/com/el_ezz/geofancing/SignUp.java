package com.el_ezz.geofancing;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SignUp extends AppCompatActivity {
    //change this variables to wath you want
    static final long meter=0;
    static final long mill=100;
    Context context;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //get update position every 100s and 0 meter

       /* LocationManager locationManager=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,mill,meter,new LocationListener(this));*/


    }

    public void signUp(View view){
        context=this;

        dialog=new ProgressDialog(SignUp.this);
        dialog.show();
        dialog.setMessage("Getting last Locaion ...");
       /* LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location lastlocation= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(lastlocation==null){
            lastlocation= locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }
        Toast.makeText(context,"latlang("+lastlocation.getAltitude()+","+lastlocation.getLongitude()+")"+"hhhhh"+lastlocation.getBearing(),Toast.LENGTH_LONG).show();
*/
        dialog.dismiss();

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }




}
