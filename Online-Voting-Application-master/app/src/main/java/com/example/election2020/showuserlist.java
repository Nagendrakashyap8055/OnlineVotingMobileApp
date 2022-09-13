package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showuserlist extends AppCompatActivity {

    ListView mylistview;
    Button logoutadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showuserlist);

        logoutadmin=(Button)findViewById(R.id.logoutadmin);
        mylistview=(ListView)findViewById(R.id.listview1);

        logoutadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(showuserlist.this, "Logged out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), welcome.class));
            }
        });
        final ArrayList<String> list=new ArrayList<>();
        final ArrayAdapter<String> myarrayadapter=new ArrayAdapter<String>(this, R.layout.list_item,list);
        mylistview.setAdapter(myarrayadapter);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){

                    list.add("\n"+snapshot1.getValue().toString());
                }
                myarrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}