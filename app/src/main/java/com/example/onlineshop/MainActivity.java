package com.example.onlineshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    Items items = new Items();
    public static final String EXTRA_POSITION = "position";
    public static Boolean login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view_id);
        createListViewItems(listView);
        setOnClickListView(listView);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(int index=0; index<sensors.size(); index++) {
            Log.i("Sensors", String.valueOf(sensors.get(index)));
        }

    }

    public void createListViewItems(ListView listView){
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items.getListItems());

        listView.setAdapter(arrayAdapter);
    }

    public void setOnClickListView(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openInfoActivity(position);
            }
        });
    }

    private void openInfoActivity(int position){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.home:
                goHome();
                return true;
            case R.id.login:
                doLogin();
                return true;
            case R.id.settings:
                openSettings();
                return true;
            case R.id.sensors_layout:
                openSensorsActivity();
                return true;
            case R.id.location_layout:
                openLocationActivity();
                return true;
            case R.id.camera_layout:
                openCameraActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void doLogin(){
        if (!MainActivity.login){
            AlertDialog.Builder loginDialog = new AlertDialog.Builder(this).setView(R.layout.activity_login);

            loginDialog.setPositiveButton("OK", null);
            loginDialog.setNegativeButton("Cancel", null);

            loginDialog.create();

            loginDialog.show();
        }
    }


    public void openSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openSensorsActivity(){
        Intent intent = new Intent(this, SensorsActivity.class);
        startActivity(intent);
    }

    public void openLocationActivity(){
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }

    public void openCameraActivity(){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
/*
    public void goAddItemActivity(){
        Intent intent = new Intent(this, R.layout.activity_add_item);
        startActivity(intent);
    }

 */
}

