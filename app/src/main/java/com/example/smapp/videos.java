package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class videos extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Button btnmn1 = findViewById(R.id.btnplaylist);

        Button btnmn2 = findViewById(R.id.btnmenu);

        Button btnmn3 = findViewById(R.id.btnsite);

        Button btnmn4 = findViewById(R.id.btnfoto);

        btnmn1.setOnClickListener(v -> {
                Intent video = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/playlist?list=PLzer3ZsUmpUQ-AEgh8SdsX845V8uv7OMa"));
                // caso nao tenha app padrão, a caixa de escolha irá abrir
                Intent intent = Intent.createChooser(video, "abrir com :");
                startActivity(intent);
        });

        btnmn2.setOnClickListener(v -> {
                Intent intent = new Intent(getBaseContext(), tutorial.class);
                startActivity(intent);
        });

        btnmn3.setOnClickListener(v -> {
                Uri uri = Uri.parse("http://reutilizacaosolidaria.no.comunidades.net/reutilizacao-pros-e-contras");
                Intent reciclagem = new Intent(Intent.ACTION_VIEW, uri);
                // caso nao tenha app padrão, a caixa de escolha irá abrir
                Intent intent = Intent.createChooser(reciclagem, "abrir com:");
                startActivity(intent);
        });

        btnmn4.setOnClickListener(v -> {
                Intent intent = new Intent(getBaseContext(), foto.class);
                startActivity(intent);
            });

    }
}