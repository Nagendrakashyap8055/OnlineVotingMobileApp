package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class three extends AppCompatActivity implements View.OnClickListener {
    public CardView presidential, mp, mla, council;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        presidential = (CardView) findViewById(R.id.presidential);
        mp = (CardView) findViewById(R.id.mp);
        mla = (CardView) findViewById(R.id.Mla);
        council = (CardView) findViewById(R.id.council);
        presidential.setOnClickListener(this);
        mp.setOnClickListener(this);
        mla.setOnClickListener(this);
        council.setOnClickListener(this);

    }@Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.presidential:
                i = new Intent(this, voting.class);
                startActivity(i);
                break;
            case R.id.mp:
                i = new Intent(this, mpelection.class);
                startActivity(i);
                break;
            case R.id.Mla:
                i = new Intent(this, voting.class);
                startActivity(i);
                break;
            case R.id.council:
                i = new Intent(this, voting.class);
                startActivity(i);
                break;

        }

    }
}

