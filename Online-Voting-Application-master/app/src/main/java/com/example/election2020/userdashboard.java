package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class userdashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
    }
    public void showresult(View view){
        Intent intent = new Intent(this, votecount.class);
        startActivity(intent);
    }


    public void callvote(View view) {
        Intent intent = new Intent(this, voting.class);
        startActivity(intent);
    }

    public void calllogout(View view) {
        Toast.makeText(userdashboard.this, "Logged out!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), welcome.class));
    }
}