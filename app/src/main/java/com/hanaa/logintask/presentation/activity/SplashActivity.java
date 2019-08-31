package com.hanaa.logintask.presentation.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanaa.logintask.R;
import com.hanaa.logintask.presentation.navigation.NavigationManagement;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(
                ()->{
                    NavigationManagement.Navigator.goToLoginActivity(this);
                    finish();
                }
        ,4000);
    }
}
