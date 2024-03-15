package com.example.duan.ScreenSplash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import com.example.duan.Login;
import com.example.duan.R;

public class SplashScreen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);

        Button buttonContinue = findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến SplashScreen2
                Intent splashScreen2Intent = new Intent(SplashScreen1.this, SplashScreen2.class);
                startActivity(splashScreen2Intent);
            }
        });

        Button buttonSkip = findViewById(R.id.buttonSkip);
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển đến LoginActivity
                Intent loginIntent = new Intent(SplashScreen1.this, Login.class);
                startActivity(loginIntent);
            }
        });
    }
}
