package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


CardView length,weight;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            length = findViewById(R.id.length);
            weight = findViewById(R.id.weight);

length.setOnClickListener(this);
weight.setOnClickListener(this);


        }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {



            case R.id.length:
                intent = new Intent(MainActivity.this, meters.class);
                startActivity(intent);
                break;

            case R.id.weight:
                intent = new Intent(MainActivity.this, kilogram.class);
                startActivity(intent);
                break;


        }

    }
}