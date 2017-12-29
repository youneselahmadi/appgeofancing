package com.el_ezz.geofancing;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.el_ezz.geofancing.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    //change this variables to wath you want
    static final long meter=0;
    static final long mill=100;
    Context context;
    ProgressDialog dialog;
    EditText username;
    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=(EditText) findViewById(R.id.username);
        databaseUser= FirebaseDatabase.getInstance().getReference("users");

        //get update position every 100s and 0 meter

       /* LocationManager locationManager=(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,mill,meter,new LocationListener(this));*/


    }

    public void signUp(View view){
        context=this;

        dialog=new ProgressDialog(SignUp.this);
        dialog.show();
        dialog.setMessage("Save in progress ...");
       /* LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location lastlocation= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(lastlocation==null){
            lastlocation= locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }
        Toast.makeText(context,"latlang("+lastlocation.getAltitude()+","+lastlocation.getLongitude()+")"+"hhhhh"+lastlocation.getBearing(),Toast.LENGTH_LONG).show();
*/
       String userName=username.getText().toString().trim();
       if(!TextUtils.isEmpty(userName)){

           //generate auto id
           String id=databaseUser.push().getKey();
           //get getCurrentDate
           Calendar calendar = Calendar.getInstance();
           SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
           String dateCreate = "Current Date : " + mdformat.format(calendar.getTime());

           User user = new User(id,userName,0.0,0.0,dateCreate,dateCreate);

           //save user to fairebase

           databaseUser.child(id).setValue(user);
           Toast.makeText(this,"user added",Toast.LENGTH_LONG).show();
           Intent intent=new Intent(this,MainActivity.class);
           startActivity(intent);
       }else {
           Toast.makeText(this,"you should entry a username !!!",Toast.LENGTH_LONG).show();
       }
        dialog.dismiss();





    }




}
