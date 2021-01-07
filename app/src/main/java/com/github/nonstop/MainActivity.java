package com.github.nonstop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.github.nonstop.Services.ServiceFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // build the GUI
        setContentView(R.layout.activity_main);

        Switch recorderSwitch = findViewById(R.id.switchRecording);
        recorderSwitch.setChecked(ServiceFactory.inRecordingState(getApplicationContext()));

        recorderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { ServiceFactory.startService(getApplicationContext()); }
                else {
                    ServiceFactory.stopService(getApplicationContext()); }
            }
        });
    }


}