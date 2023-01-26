package com.example.orgue;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaRelacionar extends AppCompatActivity
{
    public int state = 0;
    public int[] didItGetItRight = new int[]{-1,-1,-1,-1};
    public int didItGetItRightInGeneral = -1;

    public int[] correctAnswersInt = new int[]{3,0,2,1};
    public String[] correctAnswers = new String[]
    {
        "Té milers de tubs i necessita un espai gran per a posar-lo",
        "Es porta a sobre mentre es toca",
        "Es pot posar a diferents llocs",
        "Té només un teclat però ja té dimensions considerables"
    };

    public String[] dropdownOptions = new String[]
    {
        "Té només un teclat però ja té dimensions considerables",
        "Es porta a sobre mentre es toca",
        "Es pot posar a diferents llocs",
        "Té milers de tubs i necessita un espai gran per a posar-lo"
    };

    public Spinner dropdown1, dropdown2, dropdown3, dropdown4;
    public ImageButton imageButton;

    @SuppressWarnings("Convert2Diamond")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacionar);

        dropdown1 = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);
        dropdown3 = findViewById(R.id.spinner3);
        dropdown4 = findViewById(R.id.spinner4);
        imageButton = findViewById(R.id.fletxa);
        imageButton.setOnClickListener(v -> onClick());

        ArrayAdapter<String> adapterView1 = new ArrayAdapter<String>
        (
            this,
            android.R.layout.simple_spinner_item, dropdownOptions
        );
        adapterView1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(adapterView1);
        dropdown2.setAdapter(adapterView1);
        dropdown3.setAdapter(adapterView1);
        dropdown4.setAdapter(adapterView1);


    }

    private void onClick()
    {
        switch(state)
        {
            case 0:
                state++;
                dropdown1.setEnabled(false);
                dropdown2.setEnabled(false);
                dropdown3.setEnabled(false);
                dropdown4.setEnabled(false);
                checkAnswers();
                break;
            case 1: startActivity(LogicSingleton.NextQuestion(PantallaRelacionar.this)); break;
        }
    }

    private void checkAnswers()
    {
//        if(dropdown1.getPrompt().toString().equals(correctAnswers[0]))
        if(dropdown1.getSelectedItem().toString().equals(correctAnswers[0]))
        {
            didItGetItRight[0] = 1;
        }
        else didItGetItRight[0] = 0;
//        if(dropdown2.getPrompt().toString().equals(correctAnswers[1]))
        if(dropdown2.getSelectedItem().toString().equals(correctAnswers[1]))
        {
            didItGetItRight[1] = 1;
        }
        else didItGetItRight[1] = 0;
//        if(dropdown3.getPrompt().toString().equals(correctAnswers[2]))
        if(dropdown3.getSelectedItem().toString().equals(correctAnswers[2]))
        {
            didItGetItRight[2] = 1;
        }
        else didItGetItRight[2] = 0;
//        if(dropdown4.getPrompt().toString().equals(correctAnswers[3]))
        if(dropdown4.getSelectedItem().toString().equals(correctAnswers[3]))
        {
            didItGetItRight[3] = 1;
        }
        else didItGetItRight[3] = 0;

        for(int i=0; i<didItGetItRight.length; i++)
        {
            System.out.println("didItGetItRight["+i+"] = " + didItGetItRight[i]);
        }

//        if(dropdown1.getPrompt().toString().equals(correctAnswers[0])
//            && dropdown2.getPrompt().toString().equals(correctAnswers[1])
//            && dropdown3.getPrompt().toString().equals(correctAnswers[2])
//            && dropdown4.getPrompt().toString().equals(correctAnswers[3]))
        System.out.println("1");
        if(dropdown1.getSelectedItem().toString().equals(correctAnswers[0]))
            if(dropdown2.getSelectedItem().toString().equals(correctAnswers[1]))
                if(dropdown3.getSelectedItem().toString().equals(correctAnswers[2]))
                    if(dropdown4.getSelectedItem().toString().equals(correctAnswers[3]))
        {
            System.out.println("2");
            didItGetItRightInGeneral = 1;
        }
//        else
//        {
            System.out.println("3");
            didItGetItRightInGeneral = 0;
//        }
        System.out.println("4");

        System.out.println("didItGetItRightInGeneral = " + didItGetItRightInGeneral);

        if(didItGetItRightInGeneral==1)
        {
            dropdown1.setBackgroundColor(Color.rgb(162, 240, 163));
            dropdown2.setBackgroundColor(Color.rgb(162, 240, 163));
            dropdown3.setBackgroundColor(Color.rgb(162, 240, 163));
            dropdown4.setBackgroundColor(Color.rgb(162, 240, 163));
        }
        else if(didItGetItRightInGeneral==0)
        {
            if(didItGetItRight[0]==1) dropdown1.setBackgroundColor(Color.rgb(162, 240, 163));
            else dropdown1.setBackgroundColor(Color.rgb(225, 123, 123));
            if(didItGetItRight[1]==1) dropdown2.setBackgroundColor(Color.rgb(162, 240, 163));
            else dropdown2.setBackgroundColor(Color.rgb(225, 123, 123));
            if(didItGetItRight[2]==1) dropdown3.setBackgroundColor(Color.rgb(162, 240, 163));
            else dropdown3.setBackgroundColor(Color.rgb(225, 123, 123));
            if(didItGetItRight[3]==1) dropdown4.setBackgroundColor(Color.rgb(162, 240, 163));
            else dropdown4.setBackgroundColor(Color.rgb(225, 123, 123));
        }
    }
}
