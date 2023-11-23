package com.example.smapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;
import android.Manifest;
 

public class foto extends AppCompatActivity implements SensorEventListener {

    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private long att;
    private static final int movimento = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

                sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                if (sensorManager != null) {
                    acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                }
                att = System.currentTimeMillis();
                } // acessar o acelerometro

    @Override
    protected void onResume() {
        super.onResume();
        if (acelerometro != null) {
            sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }
    }
            @Override
            protected void onPause() { //  se o acelerometro nao for nulo e a activity sair do primeiro plano o listener do acelerometro sera desativado
                super.onPause();
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this);
                }
            }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                abrirCam();
            } else {
                Toast.makeText(this, "permissão negada", Toast.LENGTH_SHORT).show();
            }
        }
    }

            @Override
            public void onSensorChanged(SensorEvent event) {
        // a cada vez que o sensor mudar, o tempo atual é registrado(currenttimemillis) e é feito a comparação com o att(tempo da atualização anterior)
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    long atualtemp = System.currentTimeMillis();
                    if ((atualtemp - att) > 100) { // verifica se o acelerometro foi ativado em menos de 100 milisegundos pra nao abrir a camera varias vezes
                        long intervalo = (atualtemp - att);
                        att = atualtemp;
                        // pegando os valores do acelerometro

                        float x = event.values[0];
                        float y = event.values[1];
                        float z = event.values[2];

                        double aceleracao = Math.sqrt(x * x + y * y + z * z) - SensorManager.GRAVITY_EARTH; // calculo da aceleração sem a gravidade
                        if (aceleracao > movimento) { // se o calculo da aceleração for maior que o movimento a camera sera aberta

                            abrirCam();
                        } else {
                            // toast teste para ver se o acelerometro detecta
                            Toast.makeText(this, "mudança detectada no acelerômetro", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            private void abrirCam() {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) { // resolveActivity verifica se existe algum app q possa abrir a intent(nesse caso, a camera)
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "nao foi possivel abrir a camera", Toast.LENGTH_SHORT).show();
                }


            }
        }

