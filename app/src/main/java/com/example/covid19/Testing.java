package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Testing extends AppCompatActivity {

    private LinearLayout testingCenter1, testingCenter2, testingCenter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        getSupportActionBar().setTitle("Covid-19 Information App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        testingCenter1 = findViewById(R.id.Tc1);
        testingCenter2 = findViewById(R.id.Tc2);
        testingCenter3 = findViewById(R.id.Tc3);

        getSupportActionBar().setTitle("Covid-19 Information App");




    }
}
