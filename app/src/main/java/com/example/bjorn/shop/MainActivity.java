package com.example.bjorn.shop;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button browse = (Button)findViewById(R.id.browse);
        Button afr = (Button)findViewById(R.id.afr);
        Button e_intent = (Button)findViewById(R.id.explicit);
        Button menu = (Button)findViewById(R.id.option);
        Button service = (Button)findViewById(R.id.service);
        Button stop = (Button)findViewById(R.id.stop);

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicPlayer.class);
                startActivity(intent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionMenu.class);
                startActivity(intent);
            }
        });

        browse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, browse.class);
                startActivity(intent);
            }
        });

        afr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AFR.class);
                startActivity(intent);
            }
        });

        e_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Explicit.class);
                startActivity(intent);
            }
        });

        if (isServiceRunning(MusicPlayerService.class)) {
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopService(new Intent(getBaseContext(), MusicPlayerService.class));
                }
            });
        }
    }

    private boolean isServiceRunning(Class<?> MusicPlayerService){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        // Loop through the running services
        for(ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (MusicPlayerService.getName().equals(service.service.getClassName())) {
                // If the service is running then return true
                return true;
            }
        }
        return false;
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MusicPlayerService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MusicPlayerService.class));
    }

}
