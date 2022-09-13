package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    TextInputEditText full,user,email,pass,phn;
    Button signup;
    FirebaseAuth fauth;
    FirebaseDatabase mydatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        full= (TextInputEditText) findViewById(R.id.fullname);
        user= (TextInputEditText)findViewById(R.id.user);
        email= (TextInputEditText)findViewById(R.id.email);
        pass=(TextInputEditText)findViewById(R.id.password);
        phn= (TextInputEditText)findViewById(R.id.phn);
        signup=(Button)findViewById(R.id.signup);

        fauth=FirebaseAuth.getInstance();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullname=full.getText().toString();
                final String username=user.getText().toString();
                final String emailid=email.getText().toString();
                final String password=pass.getText().toString();
                final String phoneno=phn.getText().toString();

                final signupdata sd=new signupdata(fullname,username,emailid,password,phoneno);



                if (TextUtils.isEmpty(emailid)) {
                    email.setError("Email is Required.");
                } else if (TextUtils.isEmpty(password)) {
                    pass.setError("Password is Required");
                } else if (password.length() < 6) {
                    pass.setError("Password Must be>=6 Characters");
                } else {

                    fauth.createUserWithEmailAndPassword(emailid, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), login.class));
                            } else {
                                Toast.makeText(signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
                mydatabse=FirebaseDatabase.getInstance();
                Object rf= mydatabse.getReference("Users").child(fullname).setValue(sd);




            }


        });

    }



}