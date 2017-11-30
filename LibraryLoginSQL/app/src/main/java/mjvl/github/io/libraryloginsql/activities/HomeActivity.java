package mjvl.github.io.libraryloginsql.activities;

/**
 * Created by micha on 11/12/2017.
 */

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mjvl.github.io.libraryloginsql.R;
import mjvl.github.io.libraryloginsql.helper.GPSTracker;
import mjvl.github.io.libraryloginsql.helper.LibraryBounds;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lblWelcome;
    private TextView lblStatus;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lblWelcome = (TextView) findViewById(R.id.lblWelcome);
        lblStatus = (TextView) findViewById(R.id.lblStatus);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        lblWelcome.setText("Logged in as " + nameFromIntent);
        btnCheck.setOnClickListener(this);
    }

    @Override
<<<<<<< HEAD
    public void onClick(View v){
=======
    public void onClick(View v) {
>>>>>>> d016c9aeba71111b7ab3b964e44313caa17a4fd6
        switch (v.getId()) {
            case R.id.btnCheck:
                double lat, lon;
                lat = lon = 0;
                GPSTracker GPS = new GPSTracker(HomeActivity.this);
                // check if GPS enabled
                if (GPS.canGetLocation()){
                    lat = GPS.getLatitude();
                    lon = GPS.getLongitude();
<<<<<<< HEAD
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG).show();
                    if (LibraryBounds.checkBounds(lat,lon)) {
                        Toast.makeText(getApplicationContext(), "In Bounds", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Out of Bounds", Toast.LENGTH_SHORT).show();
                    }
                } else {
=======
                    if (LibraryBounds.checkBounds(lat,lon)) {
                        Toast.makeText(getApplicationContext(), lat + "," + lon + "In Bounds", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), lat + "," + lon + "Out of Bounds", Toast.LENGTH_SHORT).show();
                    }
                }else{
>>>>>>> d016c9aeba71111b7ab3b964e44313caa17a4fd6
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    Toast.makeText(getApplicationContext(), "Can't Get Position", Toast.LENGTH_SHORT).show();
                    GPS.showSettingsAlert();
                }
                break;
        }
    }
}
