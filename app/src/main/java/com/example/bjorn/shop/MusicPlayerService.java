package com.example.bjorn.shop;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;


public class MusicPlayerService extends Service {

    MediaPlayer myPlayer;


    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }

    public void onCreate() {

        myPlayer = MediaPlayer.create(this, Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/reason.mp3"));
        myPlayer.start();
        myPlayer.setLooping(true);

        Toast.makeText(getApplicationContext(), "A stop button will now be shown in all activities to stop the music", Toast.LENGTH_LONG).show();
    }


    public void onDestroy() {
        myPlayer.stop();
    }
}
