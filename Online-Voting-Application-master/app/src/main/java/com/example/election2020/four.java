package com.example.election2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class four extends AppCompatActivity {
    TextInputLayout reg_name, reg_dob, reg_phone, reg_id;
    Button reg_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticvity_four);
        reg_name = findViewById(R.id.name);
        reg_dob = findViewById(R.id.dob);
        reg_phone = findViewById(R.id.phone);
        reg_id = findViewById(R.id.id);
        reg_btn = findViewById(R.id.add_voter);


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

}