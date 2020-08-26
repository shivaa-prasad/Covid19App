package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class CovidStats extends AppCompatActivity {

    TextView Tcases, Trecovered, Tactive, Tcritical, Ttodaycases, Tdeaths;
    private SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_stats);

        Tcases = findViewById(R.id.Cases);
        Trecovered = findViewById(R.id.Recovered);
        Tactive = findViewById(R.id.Active);
        Ttodaycases = findViewById(R.id.TodayCases);
        Tdeaths = findViewById(R.id.TotalDeaths);
        Tcritical = findViewById(R.id.Critical);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportActionBar().setTitle("Covid-19 Information App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.resources){
                    Intent intent = new Intent(CovidStats.this, HomePage.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        fetchData();
    }

    private void fetchData() {

        String url  = "https://corona.lmao.ninja/v2/all/";

        StringRequest request = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    Tcases.setText(jsonObject.getString("cases"));
                    Trecovered.setText(jsonObject.getString("recovered"));
                    Tactive.setText(jsonObject.getString("critical"));
                    Tcritical.setText(jsonObject.getString("active"));
                    Ttodaycases.setText(jsonObject.getString("todayCases"));
                    Tdeaths.setText(jsonObject.getString("deaths"));


                } catch (JSONException e) {
                    e.printStackTrace();
                    scrollView.setVisibility(View.VISIBLE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(CovidStats.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        }
    }


