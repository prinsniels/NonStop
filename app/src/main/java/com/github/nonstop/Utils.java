package com.github.nonstop;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.github.nonstop.Services.ForegroundService;

public class Utils {

    public static boolean shouldRecord(Context context) {
        return context
                .getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
                .getBoolean("RECORDING", false);
    }

    public static void startService(Context context) {
        // after API-26 the service should be a Foreground Service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, ForegroundService.class));
        } else {

//            context.startService(intent);
        }
    }

}
