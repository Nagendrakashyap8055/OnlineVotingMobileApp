package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private TextInputEditText lemail,lpass;
    private TextView forget;
    private Button login;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        login = (Button) findViewById(R.id.login);


        lemail = (TextInputEditText) findViewById(R.id.loginemail);
        lpass = (TextInputEditText) findViewById(R.id.loginpassword);

        forget= (TextView)findViewById(R.id.forgetpassword);

        fauth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=lemail.getText().toString().trim();
                String pass=lpass.getText().toString().trim();

                if(email.isEmpty()){
                    lemail.setError("Email is required!");
                    lemail.requestFocus();
                    return;
                }
                if(pass.isEmpty()){
                    lemail.setError("Password is required!");
                    lpass.requestFocus();
                    return;
                }

                fauth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(login.this,userdashboard.class));
                            Toast.makeText(login.this, "Welcome!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(login.this, "Failed to login!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
    public void callforgetpassword(View view) {
        Intent intent = new Intent(getApplicationContext(), forgetpassword.class);
        startActivity(intent);
    }

}








