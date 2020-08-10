package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Travel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        getSupportActionBar().setTitle("Covid-19 Information App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
