package com.github.nonstop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;


import com.github.nonstop.Services.ForegroundService;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE);

        // build the GUI
        setContentView(R.layout.activity_main);

        Switch recorderSwitch = findViewById(R.id.switchRecording);
        recorderSwitch.setChecked(Utils.shouldRecord(getApplicationContext()));

        recorderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { startService(); }
                else {stopService(); }
            }
        });
    }
    public void startService() {
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");
        ContextCompat.startForegroundService(this, serviceIntent);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("RECORDING", true);
        editor.apply();

    }
    public void stopService() {
        Intent serviceIntent = new Intent(this, ForegroundService.class);
        stopService(serviceIntent);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("RECORDING", false);
        editor.apply();
    }
}