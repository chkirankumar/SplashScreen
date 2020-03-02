package com.kiran.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    /**
     * This MainActivity will display 3 seconds.
     * Then this MainActivity call Main2Activity after 3 seconds.
     */
    private static int SPLASH_SCREEN_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The below line well off our screen title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // this below line is used to set our screen to fullscreen view.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        //By using Handler class we are passing 3 seconds MainActivity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // By using Intent we are calling another activity.
                Intent i = new Intent(MainActivity.this,
                        Main2Activity.class);
                startActivity(i);

                // Here this finish() after calling the Main2Activity, It removing MainActivity from the stack.
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}