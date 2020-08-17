package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomePage extends AppCompatActivity {

    private LinearLayout about_covid, prevent_covid,sick_covid, testing_covid, travel_covid, help_covid;
    ClipData.Item logout;

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
        return true;
    }
}
