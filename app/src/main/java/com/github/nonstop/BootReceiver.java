package com.github.nonstop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;


/**
 * Listens for booted signal
 * Responsible for listening to Boot completed signal and starting the
 * Service
 */
public class BootReceiver extends BroadcastReceiver {

    /**
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");

        String action = intent.getAction();
        String message = "BootDeviceReceiver onReceive, action is " + action;
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(context, service.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
              Toast.makeText(context, message, Toast.LENGTH_LONG).show();
//            context.startForegroundService(intent);
        } else {
              Toast.makeText(context, message, Toast.LENGTH_LONG).show();
//            context.startService(intent);
        }
    }
}