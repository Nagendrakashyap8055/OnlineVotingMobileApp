package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class thank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank);
    }

    public void calllogout(View view) {
        Toast.makeText(thank.this, "Logged out!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), userdashboard.class));
    }
}