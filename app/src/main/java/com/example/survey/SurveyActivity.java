package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SurveyActivity extends AppCompatActivity {
    private final static String LOG_TAG = SurveyActivity.class.getName();
    private FirebaseUser user;

    private NotificationHandler notificationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Log.d(LOG_TAG, "Created user");
        } else {
            Log.d(LOG_TAG, "Not created user");
            finish();
        }
        notificationHandler = new NotificationHandler(this);
    }

    public void finish_survey(View view) {
        Intent intent  = new Intent(this, ExitActivity.class);
        startActivity(intent);
        notificationHandler.cancel();
    }
}