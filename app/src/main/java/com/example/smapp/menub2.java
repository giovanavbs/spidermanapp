package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menub2 extends AppCompatActivity {

    private Button btnmn2 = (Button)findViewById(R.id.btnmn2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menub2);

        btnmn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), brinquedo1.class);

                //Intent intent = new Intent( this, brinquedo1.class);
                startActivity(intent);
            }
        });
    }
}