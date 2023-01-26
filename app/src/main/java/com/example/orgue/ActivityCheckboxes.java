package com.example.orgue;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCheckboxes extends AppCompatActivity
{
    public int state = 0;
    public int[] didItGetItRight = new int[]{-1,-1,-1,-1};
    public int didItGetItRightInGeneral = -1;

    public boolean[] correctAnswers = new boolean[]{false,false,true,false,true,true,true,false,true};
    public boolean[] currentAnswers = new boolean[]{false,false,false,false,false,false,false,false,false};
    public boolean[] paintableAnswers = new boolean[]{false,false,false,false,false,false,false,false,false};

    public CheckBox checkBox1,checkBox2,checkBox3,
                    checkBox4,checkBox5,checkBox6,
                    checkBox7,checkBox8,checkBox9;
    public ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_boxes);

        checkBox1 = findViewById(R.id.opcio1);
        checkBox2 = findViewById(R.id.opcio2);
        checkBox3 = findViewById(R.id.opcio3);
        checkBox4 = findViewById(R.id.opcio4);
        checkBox5 = findViewById(R.id.opcio5);
        checkBox6 = findViewById(R.id.opcio6);
        checkBox7 = findViewById(R.id.opcio7);
        checkBox8 = findViewById(R.id.opcio8);
        checkBox9 = findViewById(R.id.opcio9);
        imageButton = findViewById(R.id.fletxa);
        imageButton.setOnClickListener(v -> onClick());
        checkBox1.setOnClickListener(v -> alterCheckbox(0));
        checkBox2.setOnClickListener(v -> alterCheckbox(1));
        checkBox3.setOnClickListener(v -> alterCheckbox(2));
        checkBox4.setOnClickListener(v -> alterCheckbox(3));
        checkBox5.setOnClickListener(v -> alterCheckbox(4));
        checkBox6.setOnClickListener(v -> alterCheckbox(5));
        checkBox7.setOnClickListener(v -> alterCheckbox(6));
        checkBox8.setOnClickListener(v -> alterCheckbox(7));
        checkBox9.setOnClickListener(v -> alterCheckbox(8));
    }

    public void alterCheckbox(int checkbox)
    {
//        switch(checkbox)
//        {
//            case 1:
                if(currentAnswers[checkbox]==true)
                {
                    currentAnswers[checkbox]=false;
                }
                else
                {
                    currentAnswers[checkbox]=true;
                }
//        }
    }

    private void onClick()
    {
        if(state==0)
        {
            state++;
            checkBox1.setEnabled(false);
            checkBox2.setEnabled(false);
            checkBox3.setEnabled(false);
            checkBox4.setEnabled(false);
            checkBox5.setEnabled(false);
            checkBox6.setEnabled(false);
            checkBox7.setEnabled(false);
            checkBox8.setEnabled(false);
            checkBox9.setEnabled(false);
            setPaintableAnswers();
            paintCheckboxes();
        }
        else startActivity(LogicSingleton.NextQuestion(ActivityCheckboxes.this));
    }

    private void setPaintableAnswers()
    {
        for(int i=0; i<paintableAnswers.length; i++)
        {
            if(correctAnswers[i]==currentAnswers[i]) paintableAnswers[i] = true;
            else paintableAnswers[i] = false;
        }
    }

    private void paintCheckboxes()
    {
        if(paintableAnswers[0]==true) checkBox1.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox1.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[1]==true) checkBox2.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox2.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[2]==true) checkBox3.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox3.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[3]==true) checkBox4.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox4.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[4]==true) checkBox5.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox5.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[5]==true) checkBox6.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox6.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[6]==true) checkBox7.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox7.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[7]==true) checkBox8.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox8.setBackgroundColor(Color.rgb(225,123,123));
        if(paintableAnswers[8]==true) checkBox9.setBackgroundColor(Color.rgb(162,240,163));
        else checkBox9.setBackgroundColor(Color.rgb(225,123,123));
    }
}
