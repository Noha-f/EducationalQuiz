package com.example.android.educationalquiz;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int score;
    String errorMessage = "Hey Noha, you did not answer number ";
    Boolean notAnswered = false;
    Boolean scoreClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is used when start button is clicked to scroll down to the first question
     */
    public void goToQuiz(View view) {
        ScrollView myView = (ScrollView) findViewById(R.id.scroll_main);
        ImageView questions = (ImageView) findViewById(R.id.noha_test);
        int quizStart = questions.getTop();
        myView.scrollTo(0, quizStart);
    }


    /**
     * This method is called when the score button is clicked.
     * The right answers are 1C, 2B, 3 Egypt, 4A&D, 5A, 6 Turkey
     */
    public void scoreCalculation(View view) {
        scoreClicked = true;
        score = 0;
        errorMessage = "Hey Noha, you did not answer number ";
        notAnswered = false;
        // check for no.1
        CheckBox oneA = findViewById(R.id.one_A);
        Boolean answerOneA = oneA.isChecked();
        CheckBox oneB = findViewById(R.id.one_B);
        Boolean answerOneB = oneB.isChecked();
        CheckBox OneC = findViewById(R.id.one_C);
        Boolean answerOneC = OneC.isChecked();
        CheckBox oneD = findViewById(R.id.one_D);
        Boolean answerOneD = oneD.isChecked();
        if (answerOneC && !answerOneA && !answerOneB && !answerOneD) {
            score = score + 1;
        }
        if (!answerOneA && !answerOneB && !answerOneC && !answerOneD) {
            notAnswered = true;
            errorMessage = errorMessage + "1";
        }

        // check for no.2
        RadioButton twoA = findViewById(R.id.two_A);
        Boolean answerTwoA = twoA.isChecked();
        RadioButton twoB = findViewById(R.id.two_B);
        Boolean answerTwoB = twoB.isChecked();
        RadioButton twoC = findViewById(R.id.two_C);
        Boolean answerTwoC = twoC.isChecked();
        RadioButton twoD = findViewById(R.id.two_D);
        Boolean answerTwoD = twoD.isChecked();
        if (answerTwoB) {
            score = score + 1;
        }
        if (!answerTwoA && !answerTwoB && !answerTwoC && !answerTwoD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 2";
        }

        // check for no.3
        EditText three = findViewById(R.id.three);
        String answerThree = three.getText().toString();
        if (answerThree.contains("EGYPT")) {
            score = score +1;
        }
        if (answerThree.isEmpty()){
            notAnswered = true;
            errorMessage = errorMessage + "\n 3";
        }

        // check for no.4
        CheckBox fourA = findViewById(R.id.four_A);
        Boolean answerfourA = fourA.isChecked();
        CheckBox fourB = findViewById(R.id.four_B);
        Boolean answerfourB = fourB.isChecked();
        CheckBox fourC = findViewById(R.id.four_C);
        Boolean answerfourC = fourC.isChecked();
        CheckBox fourD = findViewById(R.id.four_D);
        Boolean answerfourD = fourD.isChecked();
        if (answerfourA && !answerfourB && !answerfourC && answerfourD) {
            score = score + 1;
        }
        if (!answerfourA && !answerfourB && !answerfourC && !answerfourD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 4";
        }

        // check for no.5
        RadioButton fiveA = findViewById(R.id.five_A);
        Boolean answerfiveA = fiveA.isChecked();
        RadioButton fiveB = findViewById(R.id.five_B);
        Boolean answerfiveB = fiveB.isChecked();
        RadioButton fiveC = findViewById(R.id.five_C);
        Boolean answerfiveC = fiveC.isChecked();
        RadioButton fiveD = findViewById(R.id.five_D);
        Boolean answerfiveD = fiveD.isChecked();
        if (answerfiveA) {
            score = score + 1;
        }
        if (!answerfiveA && !answerfiveB && !answerfiveC && !answerfiveD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 5";
        }

        // check for no.6
        EditText six = findViewById(R.id.six);
        String answerSix = six.getText().toString();
        if (answerSix.contains("TURKEY")) {
            score = score +1;
        }
        if (answerSix.isEmpty()){
            notAnswered = true;
            errorMessage = errorMessage + "\n 6";
        }

        scoreMessage(score, errorMessage, notAnswered);
    }

    /** This method is used to Toast the score/error
     *
     * @param score is the final score
     * @param errorMessage shows the skipped questions if exists
     */
    private void scoreMessage(int score, String errorMessage, boolean notAnswered) {
        if (notAnswered == false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Hey Noha, you got " + score, Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG);
            toast.show();
        }

        Log.v("my_tag", "at the end of the method, score is: "+score);
    }


    String scoreValue = Integer.toString(score);


    //This method is used when the check the right answers button is clicked

    public void goToAnswers (View view) {
        openActivity2(scoreValue);
    }

    public void openActivity2(String scoreValue){

        Intent intent = new Intent(this, answers.class);
        intent.putExtra("scoreValue", scoreValue);
        startActivity(intent);
    }
}
