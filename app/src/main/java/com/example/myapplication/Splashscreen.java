package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress = 0;
    private int progressbarStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //It will hide title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splashscreen);

        progressBar = findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            public void run() {
                while (progressbarStatus < 100) {
                    progressbarStatus += 5;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressbarStatus);

                            if(progressbarStatus > 95){
                                Intent next  = new Intent(getApplicationContext(), MapsActivity.class);
                                startActivity(next);
                            }
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
