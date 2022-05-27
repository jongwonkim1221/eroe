package com.example.eroe;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

import net.daum.mf.map.api.MapView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.mapView);
        mapViewContainer.addView(mapView);


    }
}





//네이티브 키 값 : b9db38bdcbe294d8902eb53180f04402