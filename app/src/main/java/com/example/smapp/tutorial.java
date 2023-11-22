package com.example.smapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class tutorial extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 1;

    private LocationManager locationManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


    Button btn1 = findViewById(R.id.btntuto);

    Button btn2 = findViewById(R.id.btnlogin);

    Button btn3 = findViewById(R.id.btnvideos);

    Button btn4 = findViewById(R.id.btncompartilhe);

    Button btn5 = findViewById(R.id.btnloc);

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), brinquedo11.class);
            startActivity(intent);
        });

        btn2.setOnClickListener(v -> {

            Intent intent = new Intent(getBaseContext(), login.class);

            //Intent intent = new Intent( this, login.class);
            startActivity(intent);
        });

        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), videos.class);
            startActivity(intent);
        });

        btn4.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "https://github.com/giovanavbs/spidermanapp");
                intent.setType("text/plain");
                Intent intentcomp = Intent.createChooser(intent, "compartilhar usando:");
                startActivity(intentcomp);

            });

        btn5.setOnClickListener(v -> checarpermissao());
    }

                @Override
                protected void onStart() {
                    super.onStart();
                    checargps();
                }

                private void checargps() {
                    if (!isLocationEnabled()) {
                        Toast.makeText(this, "ative a localização", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }


                private void checarpermissao() {
                    if (ContextCompat.checkSelfPermission(tutorial.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(tutorial.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                REQUEST_LOCATION_PERMISSION);
                    } else {
                        pegarloc();
                    }
                }

                private void pegarloc() {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
                        return;
                    }

                    // pegando a ultima localização do usuario
                    Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    if (loc != null) {
                        double latitude = loc.getLatitude();
                        double longitude = loc.getLongitude();

                        abrirMaps(latitude, longitude);
                    }
                    else {
                        Toast.makeText(this, "Não foi possível obter a localização atual", Toast.LENGTH_SHORT).show();
                    }
                }

                private boolean isLocationEnabled() {
                    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                }
                // mudar a query para procurar as ongs proximas, por enquanto só marca a loc atual
                private void abrirMaps(double latitude, double longitude) {
                    Uri uri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }

                @Override
                public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults); // nao é redundante?
                    if (requestCode == REQUEST_LOCATION_PERMISSION) {
                        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            pegarloc();
                        } else {
                            Toast.makeText(this, "acesso a localizaçõa negado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                protected void onDestroy() { // parar de atualizar a loc atual quando a activity for destruida
                    super.onDestroy();
                    if (locationManager != null) {
                        locationManager.removeUpdates(locationListener);
                    }
                }

                private final LocationListener locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(@NonNull Location location) {
                    } // caso a loc mude


                    @Override
                    public void onProviderEnabled(@NonNull String provider) {
                    } // gps habilitado

                    @Override
                    public void onProviderDisabled(@NonNull String provider) {
                    } // gps desabilitado
                };
            }
