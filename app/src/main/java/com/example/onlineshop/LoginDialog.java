package com.example.onlineshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class LoginDialog {

    public Activity activity;
    public Dialog d;
    public Button ok, cancel;
/*
    public LoginDialog(Activity activity) {
        super(activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        ok = (Button) findViewById(R.id.button_ok_login);
        cancel = (Button) findViewById(R.id.button_cancel_login);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.login = true;
                TextView item = findViewById(R.id.login);
                item.setText("Log Out");
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dismiss();
            }
        });

    }

 */
}
