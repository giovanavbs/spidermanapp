package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menub3 extends AppCompatActivity {

    private Button btnmn3;

    private Button btnmv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menub3);

        btnmn3 = (Button)findViewById(R.id.btnmn3);

        btnmv3 = (Button)findViewById(R.id.btnmv3);

        btnmn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), brinquedo3.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });
    }
}