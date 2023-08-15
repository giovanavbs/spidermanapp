package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fim extends AppCompatActivity {

    private Button btnvoltamenu;
    private Button btnvoltainicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);

        btnvoltamenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), menu.class);

                //Intent intent = new Intent( this, menu.class);
                startActivity(intent);
            }
        });

        btnvoltainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                //Intent intent = new Intent( this, menu.class);
                startActivity(intent);
            }
        });

    }
}