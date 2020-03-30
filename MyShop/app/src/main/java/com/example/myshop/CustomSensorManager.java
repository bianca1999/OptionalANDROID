package com.example.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CustomSensorManager extends AppCompatActivity {
    ListView listView;
    SensorManager sensorManager;
    List<Sensor> listsensor;
    List<String> liststring;
    ArrayAdapter<String> adapter;

    
    private void initializaView() {
        listView = (ListView) findViewById(R.id.sensorListView);

        liststring = new ArrayList<String>();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 0; i < listsensor.size(); i++) {

            liststring.add(listsensor.get(i).getName());
        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );

        listView.setAdapter(adapter);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_sensor_manager);
        initializaView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
        initializaView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","onStart invoked");
        initializaView();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
        ContentValues values = new ContentValues();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }

}
