package com.chandra.piyush.project3c.android.project3cfin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getStringExtra("val").equalsIgnoreCase("NY")) {
            Toast.makeText(context, "New York information under construction! ",
                    Toast.LENGTH_LONG).show();
        } else if (intent.getStringExtra("val").equalsIgnoreCase("CA")) {
            Intent i = new Intent(context, Activity3.class);
            context.startActivity(i);
        }
    }
}
