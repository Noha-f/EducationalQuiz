package com.example.android.educationalquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    String errorMessage;
    Boolean notAnswered = false;
    Boolean scoreClicked = false;
    Boolean firstAnswer = false;
    Boolean secondAnswer = false;
    Boolean thirdAnswer = false;
    Boolean fourthAnswer = false;
    Boolean fifthAnswer = false;
    Boolean sixthAnswer = false;
    private EditText nameBox;
    private CheckBox oneA;
    private CheckBox oneB;
    private CheckBox oneC;
    private CheckBox oneD;
    private RadioButton twoA;
    private RadioButton twoB;
    private RadioButton twoC;
    private RadioButton twoD;
    private EditText three;
    private CheckBox fourA;
    private CheckBox fourB;
    private CheckBox fourC;
    private CheckBox fourD;
    private RadioButton fiveA;
    private RadioButton fiveB;
    private RadioButton fiveC;
    private RadioButton fiveD;
    private EditText six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameBox = findViewById(R.id.name);
        oneA = findViewById(R.id.one_A);
        oneB = findViewById(R.id.one_B);
        oneC = findViewById(R.id.one_C);
        oneD = findViewById(R.id.one_D);
        twoA = findViewById(R.id.two_A);
        twoB = findViewById(R.id.two_B);
        twoC = findViewById(R.id.two_C);
        twoD = findViewById(R.id.two_D);
        three = findViewById(R.id.three);
        fourA = findViewById(R.id.four_A);
        fourB = findViewById(R.id.four_B);
        fourC = findViewById(R.id.four_C);
        fourD = findViewById(R.id.four_D);
        fiveA = findViewById(R.id.five_A);
        fiveB = findViewById(R.id.five_B);
        fiveC = findViewById(R.id.five_C);
        fiveD = findViewById(R.id.five_D);
        six = findViewById(R.id.six);
    }

    /**
     * This method is used when start button is clicked to scroll down to the first question
     */
    public void goToQuiz(View view) {
        ScrollView myView = (ScrollView) findViewById(R.id.scroll_main);
        ImageView questions = (ImageView) findViewById(R.id.quiz_top);
        int quizStart = questions.getTop();
        myView.scrollTo(0, quizStart);
    }

    /**
     * This method is called when the score button is clicked.
     * The right answers are 1C, 2B, 3 Egypt, 4A&D, 5A, 6 Turkey
     */
    public void scoreCalculation(View view) {
        scoreClicked = true;
        String userName = nameBox.getText().toString();
        score = 0;
        errorMessage = getString(R.string.hey) + userName + getString(R.string.no_answer);
        notAnswered = false;

        // check for no.1
        Boolean answerOneA = oneA.isChecked();
        Boolean answerOneB = oneB.isChecked();
        Boolean answerOneC = oneC.isChecked();
        Boolean answerOneD = oneD.isChecked();
        if (answerOneC && !answerOneA && !answerOneB && !answerOneD) {
            score = score + 1;
            firstAnswer = true;
        }
        if (!answerOneA && !answerOneB && !answerOneC && !answerOneD) {
            notAnswered = true;
            errorMessage = errorMessage + "1";
        }

        // check for no.2
        Boolean answerTwoA = twoA.isChecked();
        Boolean answerTwoB = twoB.isChecked();
        Boolean answerTwoC = twoC.isChecked();
        Boolean answerTwoD = twoD.isChecked();
        if (answerTwoB) {
            score = score + 1;
            secondAnswer = true;
        }
        if (!answerTwoA && !answerTwoB && !answerTwoC && !answerTwoD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 2";
        }

        // check for no.3
        String answerThree = three.getText().toString();
        if (answerThree.contains("EGYPT")) {
            score = score +1;
            thirdAnswer = true;
        }
        if (answerThree.isEmpty()){
            notAnswered = true;
            errorMessage = errorMessage + "\n 3";
        }

        // check for no.4
        Boolean answerFourA = fourA.isChecked();
        Boolean answerFourB = fourB.isChecked();
        Boolean answerFourC = fourC.isChecked();
        Boolean answerFourD = fourD.isChecked();
        if (answerFourA && !answerFourB && !answerFourC && answerFourD) {
            score = score + 1;
            fourthAnswer = true;
        }
        if (!answerFourA && !answerFourB && !answerFourC && !answerFourD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 4";
        }

        // check for no.5
        Boolean answerFiveA = fiveA.isChecked();
        Boolean answerFiveB = fiveB.isChecked();
        Boolean answerFiveC = fiveC.isChecked();
        Boolean answerFiveD = fiveD.isChecked();
        if (answerFiveA) {
            score = score + 1;
            fifthAnswer = true;
        }
        if (!answerFiveA && !answerFiveB && !answerFiveC && !answerFiveD) {
            notAnswered = true;
            errorMessage = errorMessage + "\n 5";
        }

        // check for no.6
        String answerSix = six.getText().toString();
        if (answerSix.contains("TURKEY")) {
            score = score +1;
            sixthAnswer = true;
        }
        if (answerSix.isEmpty()){
            notAnswered = true;
            errorMessage = errorMessage + "\n 6";
        }

        scoreMessage(score, errorMessage, notAnswered, userName);
    }

    /** This method is used to Toast the score/error
     *
     * @param score is the final score
     * @param errorMessage shows the skipped questions if exists
     * @param notAnswered unanswered questions
     * @param userName the name entered
     */
    private void scoreMessage(int score, String errorMessage, boolean notAnswered, String userName) {
        if (notAnswered == false) {
            Toast toast = Toast.makeText(getApplicationContext(), userName + ", you got " + score, Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG);
            toast.show();
        }
    }


    /**This method is used when the check the right answers button is clicked to open the new activity and pass
    the score, the name as strings and the answers status to it*/

    public void goToAnswers (View view) {
        EditText nameBox = (EditText)findViewById(R.id.name);
        String userName = nameBox.getText().toString();
        if(scoreClicked == false || notAnswered == true){
            Toast toast = Toast.makeText(getApplicationContext(), "Hey " + userName + ", you should score first", Toast.LENGTH_LONG);
            toast.show();
        } else {
            String scoreValue = Integer.toString(score);
            Intent intent = new Intent(this, answers.class);
            intent.putExtra("scoreValue", scoreValue);
            intent.putExtra("userName", userName);
            intent.putExtra("firstAnswer", firstAnswer);
            intent.putExtra("secondAnswer", secondAnswer);
            intent.putExtra("thirdAnswer", thirdAnswer);
            intent.putExtra("fourthAnswer", fourthAnswer);
            intent.putExtra("fifthAnswer", fifthAnswer);
            intent.putExtra("sixthAnswer", sixthAnswer);
            startActivity(intent);
        }
    }

}
