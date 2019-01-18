package com.chandra.piyush.project3b.android.project3b;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    private static final String NY_TOAST_INTENT = "edu.uic.cs478.f18.project3.showNYToast";
    private static final String CA_TOAST_INTENT = "edu.uic.cs478.f18.project3.showCAToast";
    IntentFilter nyFilter = new IntentFilter(NY_TOAST_INTENT);
    IntentFilter caFilter = new IntentFilter(CA_TOAST_INTENT);

    BroadcastReceiver mReceiver = new ForeignReceiver(); // reciever defined in other class

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if permission granted, otherwise request for permission
                if (ContextCompat.checkSelfPermission(Activity2.this, "edu.uic.cs478.f18.project3") != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Activity2.this, new String[]{"edu.uic.cs478.f18.project3"}, 0);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(Activity2.this, "edu.uic.cs478.f18.project3") == PackageManager.PERMISSION_GRANTED) {
            nyFilter.setPriority(100);
            registerReceiver(mReceiver, nyFilter);
            caFilter.setPriority(100);
            registerReceiver(mReceiver, caFilter);
        }
    }
}
