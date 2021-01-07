package com.github.nonstop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // build the GUI
        setContentView(R.layout.activity_main);

        Switch recorderSwitch = findViewById(R.id.switchRecording);
        recorderSwitch.setChecked(Utils.inRecordingState(getApplicationContext()));

        recorderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { Utils.startService(getApplicationContext()); }
                else {Utils.stopService(getApplicationContext()); }
            }
        });
    }


}