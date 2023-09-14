package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videos extends AppCompatActivity {

    private Button btnmn1;

    private Button btnmn2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        btnmn1 = (Button)findViewById(R.id.btnplaylist);

        btnmn2 = (Button)findViewById(R.id.btnmenu);

        btnmn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), brinquedo1.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });

        btnmn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), tutorial.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });

    }
}