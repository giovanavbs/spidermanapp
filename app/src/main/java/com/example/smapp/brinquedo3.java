package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class brinquedo3 extends AppCompatActivity {

    private TextView txt;
    private Button btn;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brinquedo3);

        txt = findViewById(R.id.txtex);
        btn = findViewById(R.id.btnnext);
        i=0;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                if (i == 1) {
                    txt.setText(getText(R.string.ex));
                } else if (i == 2) {
                    txt.setText(getText(R.string.ex2));
                } else if (i == 3) {
                    txt.setText(getText(R.string.ex3));
                } else if (i == 4) {
                    txt.setText(getText(R.string.ex4));
                } else if (i == 5) {
                    txt.setText(getText(R.string.ex5));
                } else if (i == 6) {
                    txt.setText(getText(R.string.ex6));
                } else if (i == 7) {
                    txt.setText(getText(R.string.ex7));
                } else if (i == 8) {
                    txt.setText(getText(R.string.ex7));
                } else if (i == 9) {
                    txt.setText(getText(R.string.ex8));
                } else {

                    Intent intent = new Intent(brinquedo3.this, fim.class);
                    startActivity(intent);
                }

            } });
    }
}