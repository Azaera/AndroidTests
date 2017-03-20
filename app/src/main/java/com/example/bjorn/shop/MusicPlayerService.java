package com.example.bjorn.shop;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;



public class MusicPlayerService extends Service {

    MediaPlayer myPlayer;


    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }

    public void onCreate() {
        myPlayer = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/reason.mp3"));
        myPlayer.start();
        myPlayer.setLooping(true);
    }


    public void onDestroy() {
        myPlayer.stop();
    }
}
