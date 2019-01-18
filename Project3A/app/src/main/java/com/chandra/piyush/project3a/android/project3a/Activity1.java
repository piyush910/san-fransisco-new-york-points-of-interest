package com.chandra.piyush.project3a.android.project3a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private BroadcastReceiver mReceiver;

    private static final String NY_TOAST_INTENT = "edu.uic.cs478.f18.project3.showNYToast"; // intent for New York
    private static final String CA_TOAST_INTENT = "edu.uic.cs478.f18.project3.showCAToast"; // intent for California

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NY_TOAST_INTENT);
                a.putExtra("val", "NY");
                sendOrderedBroadcast(a, null); // send ordered broadcast on click of button 1
            }
        });
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(CA_TOAST_INTENT);
                a.putExtra("val", "CA");
                sendOrderedBroadcast(a, null); // send ordered broadcast on click of button 2
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, "edu.uic.cs478.f18.project3") != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"edu.uic.cs478.f18.project3"}, 0);
        }
    }
}