package com.example.orgue;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityRadioButtons extends AppCompatActivity
{
    public int state = 0;

    public int question = -1;
    public int correctAnswer = -1;
    public int selectedAnswer = -1;
    public int didItGetItRight = -1; //-1: Not answered yet; 0: Wrong answer; 1: Correct answer

    public ImageButton imageButton;
    public RadioGroup radioGroup;
    public RadioButton radioButton1, radioButton2, radioButton3;
    public TextView textView;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttons);

        imageButton = findViewById(R.id.fletxa);
        textView = findViewById(R.id.benvinguda);
        imageView = findViewById(R.id.foto);
        radioButton1 = findViewById(R.id.resposta1);
        radioButton2 = findViewById(R.id.resposta2);
        radioButton3 = findViewById(R.id.resposta3);
        radioGroup = findViewById(R.id.radioGroup);

        imageButton.setOnClickListener(v -> onClick());

        setThingsToQuestion();
    }

    public void setThingsToQuestion()
    {
        question = LogicSingleton.GetCurrentQuestion();
        correctAnswer = Integer.parseInt(LogicSingleton.getCurrentQuestionInformation().answers[0]);
        textView.setText(LogicSingleton.getCurrentQuestionInformation().questionTitle);
        imageView.setImageResource(getResources().getIdentifier(LogicSingleton.getCurrentQuestionInformation().images[0],"drawable",getPackageName()));
        radioButton1.setText(LogicSingleton.getCurrentQuestionInformation().texts[0]);
        radioButton2.setText(LogicSingleton.getCurrentQuestionInformation().texts[1]);
        radioButton3.setText(LogicSingleton.getCurrentQuestionInformation().texts[2]);
    }

    public void onClick()
    {
        if(state==0)
        {
            if(radioGroup.getCheckedRadioButtonId()!=-1)
            {
                state = 1;
                comprovarRadioButtons();
                radioButton1.setEnabled(false);
                radioButton2.setEnabled(false);
                radioButton3.setEnabled(false);
            }
        }
        else if(state==1)
        {
            if(didItGetItRight==1) LogicSingleton.PushMoreScores(1,1);
            else LogicSingleton.PushMoreScores(0,1);
            startActivity(LogicSingleton.NextQuestion(ActivityRadioButtons.this));
        }
    }

    public void comprovarRadioButtons()
    {
        if(radioGroup.getCheckedRadioButtonId()!=-1)
        {
            System.out.println("radiooooooo "+radioGroup.getCheckedRadioButtonId());
//            if(radioGroup.getCheckedRadioButtonId()==R.id.resposta1)
//            {
//                selectedAnswer = 0;
//                checkIfAnswerCorrect(0);
//            }
//            else if(radioGroup.getCheckedRadioButtonId()==R.id.resposta2)
//            {
//                selectedAnswer = 1;
//                checkIfAnswerCorrect(1);
//            }
//            else if(radioGroup.getCheckedRadioButtonId()==R.id.resposta3)
//            {
//                selectedAnswer = 2;
//                checkIfAnswerCorrect(2);
//            }
            switch(radioGroup.getCheckedRadioButtonId())
            {
                case R.id.resposta1:
                    selectedAnswer = 0;
                    checkIfAnswerCorrect(0);
                    break;
                case R.id.resposta2:
                    selectedAnswer = 1;
                    checkIfAnswerCorrect(1);
                    break;
                case R.id.resposta3:
                    selectedAnswer = 2;
                    checkIfAnswerCorrect(2);
                    break;
            }
            System.out.println("correctAnswer = " + correctAnswer);
            System.out.println("selectedAnswer = " + selectedAnswer);
            System.out.println("didItGetItRight = " + didItGetItRight);
            paint();
        }
    }

    public void checkIfAnswerCorrect(int choice)
    {
        if(choice==correctAnswer) didItGetItRight = 1;
        else didItGetItRight = 0;
    }

    public void paint()
    {
        if(didItGetItRight==1)
        {
            switch(selectedAnswer)
            {
                case 0: radioButton1.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 1: radioButton2.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 2: radioButton3.setBackgroundColor(Color.rgb(162, 240, 163)); break;
            }
        }
        else if(didItGetItRight==0)
        {
            switch(selectedAnswer)
            {
                case 0: radioButton1.setBackgroundColor(Color.rgb(225, 123, 123)); break;
                case 1: radioButton2.setBackgroundColor(Color.rgb(225, 123, 123)); break;
                case 2: radioButton3.setBackgroundColor(Color.rgb(225, 123, 123)); break;
            }
            switch(correctAnswer)
            {
                case 0: radioButton1.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 1: radioButton2.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 2: radioButton3.setBackgroundColor(Color.rgb(162, 240, 163)); break;
            }
        }
    }
}
