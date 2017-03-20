package com.example.bjorn.shop;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> allDirectories = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        Button start = (Button)findViewById(R.id.start);
        Button stop = (Button)findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        System.out.println(" File List Start" );
        File file[] = Environment.getExternalStorageDirectory().listFiles();
        for (int i=1;i<=file.length;i++){
            System.out.println(" No. "+i+" : "+file[i-1].getAbsolutePath());
        }
        System.out.println(" File List End" );

    }




    public void onClick(View src){
        switch(src.getId()) {
            case R.id.start:
                startService(new Intent(this, MusicPlayerService.class));
                break;

            case R.id.stop:
                stopService(new Intent(this, MusicPlayerService.class ));
        }
    }
}