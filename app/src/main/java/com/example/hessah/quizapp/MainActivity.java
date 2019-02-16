package com.example.hessah.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreQ1;
    int scoreQ2;
    int scoreQ3;
    int scoreQ4;
    int scoreQ5;
    int totalScore = 0;
    boolean checked1;
    boolean checked2;
    boolean checked3;
    boolean checked4;
    boolean checked5 = false;
    RadioGroup group1;
    RadioGroup group2;
    RadioGroup group3;
    CheckBox box1;
    CheckBox box2;
    CheckBox box3;
    CheckBox box4;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Question1(View view) {
        group1 = findViewById(R.id.q1);
        checked1 = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.q1_a1:
                if (checked1)
                    scoreQ1 = 0;
                break;
            case R.id.q1_a2:
                if (checked1)
                    scoreQ1 = 20;
                break;
            case R.id.q1_a3:
                if (checked1)
                    scoreQ1 = 0;

                break;
            case R.id.q1_a4:
                if (checked1)
                    scoreQ1 = 0;
                break;
        }
    }

    public void Question2(View view) {
        group2 = findViewById(R.id.q2);
        checked2 = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.q2_a1:
                if (checked2)
                    scoreQ2 = 0;
                break;
            case R.id.q2_a2:
                if (checked2)
                    scoreQ2 = 20;
                break;
        }
    }

    public void Question3(View view) {
        group3 = findViewById(R.id.q3);
        checked3 = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.q3_a1:
                if (checked3)
                    scoreQ3 = 0;
                break;
            case R.id.q3_a2:
                if (checked3)
                    scoreQ3 = 0;
                break;
            case R.id.q3_a3:
                if (checked3)
                    scoreQ3 = 20;
                break;
            case R.id.q3_a4:
                if (checked3)
                    scoreQ3 = 0;
                break;
        }
    }

    public void Question4(View view) {

        box1 = findViewById(R.id.q4_a1);
        box2 = findViewById(R.id.q4_a2);
        box3 = findViewById(R.id.q4_a3);
        box4 = findViewById(R.id.q4_a4);

        checked4 = box1.isChecked() || box2.isChecked() || box3.isChecked() || box4.isChecked();

        if (!box1.isChecked() && box2.isChecked() && box3.isChecked() && !box4.isChecked())
            scoreQ4 = 20;
        else
            scoreQ4 = 0;

    }

    public void submit(View view) {

        //Question #5
        editText = findViewById(R.id.q5);
        String text = editText.getText().toString();
        text = text.toLowerCase();
        if (text.equals("java")) {
            checked5 = true;
            scoreQ5 = 20;
        }else {
            checked5 = true;
            scoreQ5 = 0;
        }
        if(checked1 && checked2 && checked3 && checked4 && checked5) {
            totalScore = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5;
            Toast.makeText(getApplicationContext(), "Total Score is: " + Integer.toString(totalScore), Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getApplicationContext(), "Make sure to answer all questions", Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        group1.clearCheck();
        group2.clearCheck();
        group3.clearCheck();
        box1.setChecked(false);
        box2.setChecked(false);
        box3.setChecked(false);
        box4.setChecked(false);
        editText.setText("");
        checked4 = false;
        checked5 = false;
    }
}
