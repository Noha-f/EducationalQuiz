package com.example.android.educationalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class answers extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        Intent intent =getIntent();
        String scoreValue= intent.getStringExtra("scoreValue");
        Toast.makeText(getApplicationContext(), scoreValue, Toast.LENGTH_LONG).show();
    }


}
