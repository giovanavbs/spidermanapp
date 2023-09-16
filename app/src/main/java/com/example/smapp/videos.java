package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videos extends AppCompatActivity {

    private Button btnmn1;

    private Button btnmn2;

    private Button btnmn3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        btnmn1 = findViewById(R.id.btnplaylist);

        btnmn2 = findViewById(R.id.btnmenu);

        btnmn3 = findViewById(R.id.btnsite);

        btnmn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent video = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/playlist?list=PLzer3ZsUmpUQ-AEgh8SdsX845V8uv7OMa"));
                // caso nao tenha app padrão, a caixa de escolha irá abrir
                Intent intent = Intent.createChooser(video, "abrir com :");
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

        btnmn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://reutilizacaosolidaria.no.comunidades.net/reutilizacao-pros-e-contras");
                Intent reciclagem = new Intent(Intent.ACTION_VIEW, uri);
                // caso nao tenha app padrão, a caixa de escolha irá abrir
                Intent intent = Intent.createChooser(reciclagem, "abrir com:");
                startActivity(intent);
            }
        });
    }
}