package com.example.mjvl.positioncheck;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private Button btnCheck;
    private Double longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = (Button)findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                analyzeLocation(location);
            }
        });
    }

    private void analyzeLocation(Location l) {
        if (l == null) {
            Toast.makeText(MainActivity.this, "Null Location",
                    Toast.LENGTH_LONG).show();
        } else {
            GPSTracker tracker = new GPSTracker(this);
            if (!tracker.canGetLocation()) {
                tracker.showSettingsAlert();
            } else {
                latitude = tracker.getLatitude();
                longitude = tracker.getLongitude();
            }
            longitude = l.getLongitude();
            latitude = l.getLatitude();
            if (LibraryBounds.checkBounds(latitude,longitude)) {
                Toast.makeText(MainActivity.this, "In Bounds",
                        Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Out of Bounds",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
