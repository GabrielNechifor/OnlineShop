package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sensors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ListView layoutSensorList = findViewById(R.id.sensors_list);
        List<String > sensorsInfo = new ArrayList<>();


        for(int index=0; index<sensors.size(); index++){
            Sensor sensor = sensors.get(index);
            sensorsInfo.add(String.valueOf(sensor));

            Log.i("Sensors", String.valueOf(sensors.get(index)));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorsInfo);
        layoutSensorList.setAdapter(arrayAdapter);
    }
}
