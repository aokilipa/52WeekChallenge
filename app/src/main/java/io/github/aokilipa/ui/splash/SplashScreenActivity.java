package io.github.aokilipa.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import io.github.aokilipa.MainActivity;
import io.github.aokilipa.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        navigateToMainActivity();
    }

    void navigateToMainActivity(){
        Intent intent = MainActivity.newIntent(SplashScreenActivity.this);
        startActivity(intent);
    }

}
