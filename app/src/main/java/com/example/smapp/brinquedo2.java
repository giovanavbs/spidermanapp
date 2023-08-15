package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class brinquedo2 extends AppCompatActivity {

    private TextView txt;
    private Button btn;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brinquedo2);

        txt = findViewById(R.id.txtex);
        btn = findViewById(R.id.btnnext);
        i=0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                if (i == 1) {
                    txt.setText(getText(R.string.ex13));
                }
                else if (i == 2) {
                    txt.setText(getText(R.string.ex14));
                }
                else if (i == 3) {
                    txt.setText(getText(R.string.ex15));
                }
                else if (i == 3) {
                    txt.setText(getText(R.string.ex16));
                }
                else if (i == 3) {
                    txt.setText(getText(R.string.ex17));
                }
                else {

                    Intent intent = new Intent(brinquedo2.this, fim.class);
                    startActivity(intent);
                }

            } });
    }
}