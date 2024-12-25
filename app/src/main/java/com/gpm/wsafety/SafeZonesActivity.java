package com.gpm.wsafety;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SafeZonesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_zones);

        Button btnPoliceStation = findViewById(R.id.btn_police_station);
        Button btnAmbulance = findViewById(R.id.btn_ambulance);
        Button btnHospital = findViewById(R.id.btn_hospital);

        btnPoliceStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToGoogleMaps("Police Station");
            }
        });

        btnAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToGoogleMaps("Ambulance");
            }
        });

        btnHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToGoogleMaps("Hospital");
            }
        });
    }

    private void redirectToGoogleMaps(String locationType) {
        String locationQuery = "";

        switch (locationType) {
            case "Police Station":
                locationQuery = "police station";
                break;
            case "Ambulance":
                locationQuery = "ambulance";
                break;
            case "Hospital":
                locationQuery = "hospital";
                break;
        }

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(locationQuery));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Show a message if Google Maps is not installed
        }
    }
}
