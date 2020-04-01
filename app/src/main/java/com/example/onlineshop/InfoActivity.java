package com.example.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class InfoActivity extends AppCompatActivity {
    Items items = new Items();
    private String currentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        Integer position =  intent.getIntExtra("position", 0);

        TextView textView = findViewById(R.id.textViewInfo);
        currentText = items.getItemInfo(position);
        textView.setText(currentText);
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
}
