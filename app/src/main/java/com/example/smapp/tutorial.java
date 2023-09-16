package com.example.smapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class tutorial extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

    btn1 = (Button) findViewById(R.id.btntuto);

    btn2 = (Button) findViewById(R.id.btnlogin);

    btn3 = (Button) findViewById(R.id.btnvideos);

    btn4 = findViewById(R.id.btncompartilhe);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), brinquedo11.class);
            startActivity(intent);
        }});

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), login.class);

            //Intent intent = new Intent( this, login.class);
            startActivity(intent);
        }});

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), videos.class);
            startActivity(intent);
        }});

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "https://github.com/giovanavbs/spidermanapp");
                intent.setType("text/plain");
                Intent intentcomp = Intent.createChooser(intent, "compartilhar usando:");
                startActivity(intentcomp);
            }});
    }
}