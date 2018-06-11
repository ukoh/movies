package com.example.babybest.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //radioButtons
    final int answerQuizOne = R.id.answerQuizOne;
    final int answerQuizFour = R.id.answerQuizFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean checkQuizOne() {
        RadioGroup radioButton = findViewById(R.id.quizOne);
        if (radioButton.getCheckedRadioButtonId() == answerQuizOne) {
            return true;
        }
        return false;
    }

    private boolean checkQuizFour() {
        RadioGroup radioButton = findViewById(R.id.quizFour);
        if (radioButton.getCheckedRadioButtonId() == answerQuizFour) {
            return true;
        }
        return false;
    }

    private boolean checkQuizThree() {
        CheckBox box_one = findViewById(R.id.box_one);
        CheckBox box_two = findViewById(R.id.box_two);
        CheckBox box_three = findViewById(R.id.box_three);

        if (box_one.isChecked() && box_two.isChecked() && box_three.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean checkQuizTwo() {
        EditText answerTwo = findViewById(R.id.answerQuizTwo);
        return answerTwo.getText().toString().equalsIgnoreCase("Joshua");
    }

    private boolean checkQuizFive() {
        EditText answerTwo = findViewById(R.id.answerQuizFive);
        return answerTwo.getText().toString().equalsIgnoreCase("Bethel");
    }

    // the logic for right and wrong answer

    public void submit(View v) {
        ArrayList<String> wrongAnswersList = new ArrayList<String>();

        int numbersOfRightQuestions = 0;

        if (checkQuizOne()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 1");
        }
        if (checkQuizTwo()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 2");
        }
        if (checkQuizThree()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 3");
        }
        if (checkQuizFour()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 4");
        }
        if (checkQuizFive()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 5");
        }

        //Store the wrongs answer in a string message
        StringBuilder string = new StringBuilder();
        for (String s : wrongAnswersList) {
            string.append(s);
            string.append("\n");
        }
        //This string message will be displayed in a toast
        Context context = getApplicationContext();
        if (numbersOfRightQuestions == 5) {
            CharSequence text = "Congratulations! You got all answers right." + string.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else if (numbersOfRightQuestions < 1) {
            CharSequence text = "What a pity! You need to study more. You got zero answers right.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            CharSequence text = "Keep trying! You got " + numbersOfRightQuestions + "/5 answers right.\n\nCheck again the following:\n" + string.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void viewAnswers(View v) {
        Intent intent = new Intent(MainActivity.this, AnswersActivity.class);
        startActivity(intent);
    }
    public  void resetButton(View v){

        EditText editText = findViewById(R.id.answerQuizTwo);
        editText.setText("");
        EditText text = findViewById(R.id.answerQuizFive);
        text.setText("");

        RadioGroup radioGroup = findViewById((R.id.quizOne));
        radioGroup.clearCheck();
        RadioGroup group = findViewById((R.id.quizFour));
        group.clearCheck();

        CheckBox checkBox = findViewById(R.id.box_one);
        checkBox.setChecked(false);
        CheckBox Box = findViewById(R.id.box_two);
        Box.setChecked(false);
        CheckBox box = findViewById(R.id.box_three);
        box.setChecked(false);
    }

}

