package com.chandra.piyush.project3c.android.project3cfin;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private static final String NY_TOAST_INTENT = "edu.uic.cs478.f18.project3.showNYToast";
    private static final String CA_TOAST_INTENT = "edu.uic.cs478.f18.project3.showCAToast";
    IntentFilter nyFilter = new IntentFilter(NY_TOAST_INTENT);
    IntentFilter caFilter = new IntentFilter(CA_TOAST_INTENT);
    MyReceiver mReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // check self permissions, if not granted ask again.
        if (ContextCompat.checkSelfPermission(this, "edu.uic.cs478.f18.project3") != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"edu.uic.cs478.f18.project3"}, 0);
        }
    }
}
