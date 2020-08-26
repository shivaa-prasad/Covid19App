package com.example.covid19;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.app.AlarmManager ;
import android.app.Notification ;
import android.app.PendingIntent ;
import android.content.Context ;
import android.content.Intent ;
import android.os.SystemClock ;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class HomePage extends AppCompatActivity {

    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default";

    private LinearLayout about_covid, prevent_covid,sick_covid, testing_covid, travel_covid, help_covid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        about_covid = findViewById(R.id.about);
        prevent_covid = findViewById(R.id.prevent);
        sick_covid = findViewById(R.id.sick);
        testing_covid = findViewById(R.id.testing);
        travel_covid = findViewById(R.id.travel);
        help_covid = findViewById(R.id.help);

        getSupportActionBar().setTitle("Covid-19 Information App");

        about_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Aboutpage.class));
            }
        });

        prevent_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Prevent.class);
                startActivity(i);
            }
        });

        sick_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Sick.class);
                startActivity(i);
            }
        });

        testing_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, CenterMaps.class);
                startActivity(i);
            }
        });

        travel_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Travel.class);
                startActivity(i);
            }
        });

        help_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Help.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.logout){
            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notify){
            scheduleNotification(getNotification( "Wear a Mask " ) , 5000 ) ;
        }
        else if (id==R.id.notify){
            scheduleNotification(getNotification( "Carry a Hand Sanitizer " ) , 6000 ) ;
        }

        else if (item.getItemId()== android.R.id.home){
            finish();
        }
        return true;
    }
    private void scheduleNotification (Notification notification , int delay) {
        
        Intent notificationIntent = new Intent( this, MyNotification. class ) ;
        notificationIntent.putExtra(MyNotification. NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(MyNotification. NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent. getBroadcast ( this, 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context. ALARM_SERVICE ) ;
        assert alarmManager != null;

        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }
    private Notification getNotification (String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;

        builder.setContentTitle( "Scheduled Notification" ) ;
        builder.setContentText(content) ;
        builder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
        builder.setAutoCancel( true ) ;
        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
        return builder.build() ;
    }
}
