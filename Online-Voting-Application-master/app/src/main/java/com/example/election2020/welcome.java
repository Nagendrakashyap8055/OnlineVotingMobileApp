package com.example.election2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public Void calllogin(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
        return null;
    }

    public void callsignup(View view) {
        Intent intent = new Intent(getApplicationContext(), signup.class);
        startActivity(intent);
    }

    public void callloginasadmin(View view) {
        Intent intent = new Intent(getApplicationContext(), login_as_admin.class);
        startActivity(intent);
    }
}