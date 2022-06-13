package com.example.alarmmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int setSecond = Integer.parseInt( ((EditText) findViewById(R.id.editTextNumber) ).getText().toString().trim() );

                long tirT = System.currentTimeMillis()+(setSecond * 1000L);

                Intent intent = new Intent(MainActivity.this, MyBroadcast.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1000, intent, PendingIntent.FLAG_UPDATE_CURRENT);


                alarmManager.set(AlarmManager.RTC_WAKEUP, tirT, pendingIntent);

            }
        });
    }
}