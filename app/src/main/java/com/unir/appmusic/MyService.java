package com.unir.appmusic;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int id = intent.getIntExtra("id", 0);
        String musica = intent.getStringExtra("musica");
        if (isPlaying){
            mediaPlayer = MediaPlayer.create(this, id);
            tocarSom();
            mediaPlayer.setLooping(true);
            isPlaying = false;
        }
        final String CHANNELID = "Music Player ID";
        NotificationChannel channel = new NotificationChannel(
                CHANNELID,
                CHANNELID,
                NotificationManager.IMPORTANCE_DEFAULT);
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANNELID);
        notification.setContentTitle("Qual é a música?");
        notification.setContentText("Tocando agora: " + musica);
        notification.setSmallIcon(R.drawable.icon);
        startForeground(1, notification.build());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tocarSom(){
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        isPlaying = true;
        mediaPlayer = null;
    }
}