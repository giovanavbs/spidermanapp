package com.example.smapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tutorial extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Button btnb1 = (Button) findViewById(R.id.btntuto);

        Button btnb2 = (Button) findViewById(R.id.btnlogin);

        Button btnb3 = (Button) findViewById(R.id.btnvideos);

        btnb1.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), brinquedo1.class);

            //Intent intent = new Intent( this, menub1.class);
            startActivity(intent);
        });

        btnb2.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), login.class);

            //Intent intent = new Intent( this, login.class);
            startActivity(intent);
        });

        btnb3.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), videos.class);

            //Intent intent = new Intent( this, menub3.class);
            startActivity(intent);
        });
    }
}