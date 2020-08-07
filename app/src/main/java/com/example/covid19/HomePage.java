package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomePage extends AppCompatActivity {

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

        about_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Aboutpage.class));
            }
        });


    }
}
