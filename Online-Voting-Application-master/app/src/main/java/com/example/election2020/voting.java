package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class voting extends AppCompatActivity {
    Button button;
    votes votes;
    TextInputEditText textInputEditText;
    RadioButton radio1,radio2,radio3;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        textInputEditText = findViewById(R.id.enteruid);
        votes = new votes();
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        button = findViewById(R.id.submit);
        reference = database.getInstance().getReference().child("Presidential");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    i = (int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1 = radio1.getText().toString();
                String v2 = radio2.getText().toString();
                String v3 = radio3.getText().toString();
                votes.setUid(textInputEditText.getText().toString());
                if (radio1.isChecked()) {
                    votes.setVote(v1);
                    reference.child(String.valueOf(i + 1)).setValue(votes);
                    Toast.makeText(voting.this, "You have voted Narendra Modi", Toast.LENGTH_SHORT).show();
                } else if (radio2.isChecked()) {
                    votes.setVote(v2);
                    reference.child(String.valueOf(i + 1)).setValue(votes);
                    Toast.makeText(voting.this, "You have voted Rahul Gandhi", Toast.LENGTH_SHORT).show();
                } else if (radio3.isChecked()) {
                    votes.setVote(v3);
                    reference.child(String.valueOf(i + 1)).setValue(votes);
                    Toast.makeText(voting.this, "You have voted Arvind Singh Kejriwal", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), thank.class);
                startActivity(intent);
            }

        });
    }


}






