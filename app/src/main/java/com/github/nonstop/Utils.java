package com.github.nonstop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.github.nonstop.Services.ForegroundService;

public class Utils {

    public static boolean inRecordingState(Context context) {
        return context
                .getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
                .getBoolean("RECORDING", false);
    }

    public static void startService(Context context) {
        // after API-26 the service should be a Foreground Service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startAPI26UpService(context);
        } else {
            // TODO: place the start for older version of Android
//            context.startService(intent);
        }
    }

    public static void stopService(Context context) {
        Intent serviceIntent = new Intent(context, ForegroundService.class);
        context.stopService(serviceIntent);

        // register the app to stop recording
        SharedPreferences prefs = context.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("RECORDING", false);
        editor.apply();
    }

    private static void startAPI26UpService(Context context) {
        ContextCompat.startForegroundService(context, new Intent(context, ForegroundService.class));

        // register the app to be recording
        SharedPreferences prefs = context.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("RECORDING", true);
        editor.apply();

    }

}
