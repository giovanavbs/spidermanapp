package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menub1 extends AppCompatActivity {

    private Button btnmn1;

    private Button btnmv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menub1);

        btnmn1 = (Button)findViewById(R.id.btnmn1);

        btnmv1 = (Button)findViewById(R.id.btnmv1);

        btnmn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), brinquedo1.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });

        btnmv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), brinquedo1.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });

    }
}