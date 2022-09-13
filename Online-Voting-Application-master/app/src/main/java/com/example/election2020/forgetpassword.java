package com.example.election2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {

    private TextInputEditText resetemail;
    private Button reset;
    private ProgressBar p1;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        resetemail = (TextInputEditText) findViewById(R.id.forgetemail);
        reset = (Button) findViewById(R.id.resetbtn);
        p1 = (ProgressBar) findViewById(R.id.progressBar);

        fauth=FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String femail=resetemail.getText().toString().trim();

                if(femail.isEmpty()){
                    resetemail.setError("Email is required!");
                    resetemail.requestFocus();
                    return;
                }
                p1.setVisibility(view.VISIBLE);
                fauth.sendPasswordResetEmail(femail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgetpassword.this, "Check your email to reset your password!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), login.class));

                        }else{
                            Toast.makeText(forgetpassword.this, "Try again! Something is wrong!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), forgetpassword.class));

                        }
                    }
                });
            }
        });

    }


}