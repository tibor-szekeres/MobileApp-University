package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        int secret_key = getIntent().getIntExtra("SECRET_KEY", 99);

        if(secret_key != 99) {
            finish();
        }
    }
}