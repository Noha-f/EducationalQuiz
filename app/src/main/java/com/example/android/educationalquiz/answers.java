package com.example.android.educationalquiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
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
        String userName = intent.getStringExtra("userName");
        TextView resultView = findViewById(R.id.score_result);
        resultView.setText( userName + ", you got " + scoreValue + " out of 6");
        int colorId = Color.parseColor("#689F38");
        Boolean firstAnswer = intent.getExtras().getBoolean("firstAnswer");
        if(firstAnswer == true){
            TextView firstBox = findViewById(R.id.first);
            firstBox.setBackgroundColor(colorId);
        }
        Boolean secondAnswer = intent.getExtras().getBoolean("secondAnswer");
        if(secondAnswer == true){
            TextView secondBox = findViewById(R.id.second);
            secondBox.setBackgroundColor(colorId);
        }
        Boolean thirdAnswer = intent.getExtras().getBoolean("thirdAnswer");
        if(thirdAnswer == true){
            TextView thirdBox = findViewById(R.id.third);
            thirdBox.setBackgroundColor(colorId);
        }
        Boolean fourthAnswer = intent.getExtras().getBoolean("fourthAnswer");
        if(fourthAnswer == true){
            TextView fourthBox = findViewById(R.id.fourth);
            fourthBox.setBackgroundColor(colorId);
        }
        Boolean fifthAnswer = intent.getExtras().getBoolean("fifthAnswer");
        if(fifthAnswer == true){
            TextView fifthBox = findViewById(R.id.fifth);
            fifthBox.setBackgroundColor(colorId);
        }
        Boolean sixthAnswer = intent.getExtras().getBoolean("sixthAnswer");
        if(sixthAnswer == true){
            TextView sixthBox = findViewById(R.id.sixth);
            sixthBox.setBackgroundColor(colorId);
        }
    }


}
