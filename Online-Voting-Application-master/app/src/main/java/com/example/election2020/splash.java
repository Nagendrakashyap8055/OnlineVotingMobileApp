package com.example.election2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;


public class splash extends AppCompatActivity {

    ImageView SplashImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashImage=(ImageView)findViewById(R.id.imagesplash);

        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        SplashImage.startAnimation(myanim);

        Thread mythread=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(5000);
                    Intent i=new Intent(splash.this,welcome.class);
                    startActivity(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        mythread.start();
    }



}