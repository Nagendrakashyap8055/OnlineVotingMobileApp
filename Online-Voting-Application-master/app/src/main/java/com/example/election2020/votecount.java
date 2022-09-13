package com.example.election2020;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class votecount extends AppCompatActivity {
    private Button users ,prestt , rahul_votes , ak_votes;
    DatabaseReference userreference;
    Query presidentialreference ;
    int usercount=0 ,presidetialcount=0, rahul= 0 , ak =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votecount);
        users = (Button) findViewById(R.id.vvvv);
        prestt = (Button) findViewById(R.id.pres_total);
        rahul_votes= (Button)findViewById(R.id.rahul_votes);
        ak_votes = (Button)findViewById(R.id.ak_votes);
        userreference = FirebaseDatabase.getInstance().getReference().child("Presidential");
        Query query = userreference.orderByChild("vote").equalTo("Narendra Modi");
        Query query1 = userreference.orderByChild("vote").equalTo("Rahul Gandhi");
        Query query2 = userreference.orderByChild("vote").equalTo("Arvind Kejriwal");

        userreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    usercount = (int) snapshot.getChildrenCount();
                    users.setText(Integer.toString(usercount) + "Votes");
                } else {
                    users.setText("0 Votes");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                        presidetialcount = (int) snapshot.getChildrenCount();
                        prestt.setText(Integer.toString(presidetialcount) + "Votes");
                    } else {
                        prestt.setText("0 votes");
                    }

                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    rahul = (int) snapshot.getChildrenCount();
                    rahul_votes.setText(Integer.toString(rahul) + "Votes");
                } else {
                    rahul_votes.setText("0 votes");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    ak = (int) snapshot.getChildrenCount();
                    ak_votes.setText(Integer.toString(ak) + "Votes");
                } else {
                    ak_votes.setText("0 votes");
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



}