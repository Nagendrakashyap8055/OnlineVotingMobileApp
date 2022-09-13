package com.example.election2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

public class login_as_admin extends AppCompatActivity {

    private TextInputEditText AdminId,AdminPass;
    private Button AdminLogin;
    private TextView Info;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_admin);

        AdminId= (TextInputEditText) findViewById(R.id.adminid);
        AdminPass= (TextInputEditText) findViewById(R.id.adminpassword);
        AdminLogin=(Button)findViewById(R.id.adminlogin);
        Info=(TextView)findViewById(R.id.attempts);

        Info.setText("No. of attempts remaining: 5");

        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(AdminId.getText().toString(),AdminPass.getText().toString());
            }
        });

    }

    private void validate( String id, String pass) {
        if((id.equals("admin")) && (pass.equals("admin1234"))){
            startActivity(new Intent(getApplicationContext(), dashboard.class));

        }else{
            counter--;
            Toast.makeText(login_as_admin.this, "Failed to login as admin!", Toast.LENGTH_SHORT).show();
            Info.setText("No. of attempts remaining: "+ String.valueOf(counter));
            if(counter ==0){
                AdminLogin.setEnabled(false);
                startActivity(new Intent(getApplicationContext(), welcome.class));

            }
        }
    }
}