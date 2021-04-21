package com.brijlathia.mobilequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.brijlathia.mobilequiz.helper.Helper;

public class QuizInstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_instruction);

        setTitle(getString(R.string.quiz_information_notice));

        TextView instructionText = (TextView)findViewById(R.id.quiz_instruction);
        instructionText.setText(Helper.instruction);
    }
}
