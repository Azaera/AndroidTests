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
        Button back = (Button) findViewById(R.id.back);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        back.setOnClickListener(this);
    }




    public void onClick(View src){
        switch(src.getId()) {
            case R.id.start:
                startService(new Intent(this, MusicPlayerService.class));
                break;

            case R.id.stop:
                stopService(new Intent(this, MusicPlayerService.class ));
                break;

            case R.id.back:
                Intent intent = new Intent(MusicPlayer.this, MainActivity.class);
                startActivity(intent);
        }


    }
}