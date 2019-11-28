package com.example.richa_000.Brake_Cooling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView aboutView = (TextView) findViewById(R.id.textViewVersion);
        String numberTemp = BuildConfig.VERSION_NAME;
        aboutView.setText("Version number " + numberTemp);
    }



}
