package com.example.alarmmanagerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

public class MyBroadcast extends BroadcastReceiver {

    private MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {

        mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);

        mediaPlayer.setLooping(true);

        mediaPlayer.start();

    }
}
