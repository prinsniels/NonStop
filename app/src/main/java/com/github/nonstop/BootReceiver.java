package com.github.nonstop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.github.nonstop.Services.ServiceFactory;

/**
 * Listens for booted signal
 * Responsible for listening to Boot completed signal and starting the
 * Service
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: @ check if the right application is sending the request
        if (ServiceFactory.inRecordingState(context)){
            ServiceFactory.startService(context);}
    }
}