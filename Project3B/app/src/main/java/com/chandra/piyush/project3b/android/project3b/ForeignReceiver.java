package com.chandra.piyush.project3b.android.project3b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ForeignReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getStringExtra("val").equalsIgnoreCase("NY")) {
            Toast.makeText(context, "NY receiver in action! ",
                    Toast.LENGTH_LONG).show();
        } else if (intent.getStringExtra("val").equalsIgnoreCase("CA")) {
            Toast.makeText(context, "CA receiver in action! ",
                    Toast.LENGTH_LONG).show();
        }
    }
}
