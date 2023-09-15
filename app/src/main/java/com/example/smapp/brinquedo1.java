package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class brinquedo1 extends AppCompatActivity {

    private TextView txt;
    private Button btn;
    int i;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brinquedo1);


        txt = findViewById(R.id.txtttuto2);
        btn = findViewById(R.id.btnnext);
        i=0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                if (i == 1) {
                    txt.setText(getText(R.string.ex10));
                } else if (i == 2) {
                    txt.setText(getText(R.string.ex11));
                } else if (i == 3) {
                    txt.setText(getText(R.string.ex12));
                }
                else {

                    Intent intent = new Intent(brinquedo1.this, brinquedo2.class);
                    startActivity(intent);
                }

            } });
    }
}