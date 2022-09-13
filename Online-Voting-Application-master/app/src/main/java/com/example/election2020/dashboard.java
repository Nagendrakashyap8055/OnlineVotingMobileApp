package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class dashboard extends AppCompatActivity implements View.OnClickListener{
    public CardView card1,card2,card3,card4,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        card1= (CardView) findViewById(R.id.card1);
        card2= (CardView) findViewById(R.id.card2);
        card3= (CardView) findViewById(R.id.card3);
        card4= (CardView) findViewById(R.id.card4);
        card5= (CardView) findViewById(R.id.card5);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.card1:
                i = new Intent(this, currentleadership.class);
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(this, showuserlist.class);
                startActivity(i);
                break;
            case R.id.card3:
                i = new Intent(this, two.class);
                startActivity(i);
                break;
            case R.id.card4:
                i = new Intent(this, registervoter.class);
                startActivity(i);
                break;
            case R.id.card5:
                i = new Intent(this, votecount.class);
                startActivity(i);
                break;
        }
    }
    public void calladminlogout(View view){
        Toast.makeText(dashboard.this, "Logged out!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), welcome.class));
    }
}
