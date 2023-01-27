package com.example.orgue;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activitat de les checkboxes.
 */
public class ActivityCheckboxes extends AppCompatActivity
{
    /**
     *  Estat de la pregunta.
     *  0: Pagina de pregunta; 1: pagina de respondre; 2: respós.
     */
    public int state = 0;

    /**
     * Array a on es guardará si cada dropdown s'ha respós bé.
     * -1: encara no contestat; 0: resposta incorrecta; 1: resposta correcta.
     */
    public int[] didItGetItRight = new int[]{-1,-1,-1,-1};

    /**
     * Com el didItGetItRight, pero en general. De tota la pregunta.
     * -1: encara no contestat; 0: resposta incorrecta; 1: resposta correcta.
     */
    public int didItGetItRightInGeneral = -1;

    /**
     * Array de les respostes correctes de les checkboxes.
     */
    public boolean[] correctAnswers = new boolean[]
    {
        false, false, true,
        false, true,  true,
        true,  false, true
    };

    /**
     * Array de les respostes que l'usuari ha posat.
     */
    public boolean[] currentAnswers = new boolean[]
    {
        false, false, false,
        false, false, false,
        false, false, false
    };

    /**
     *  Array de les respostes segons si coincideixen entre les del jugador i les correctes.
     *  Quan el jugador respongui a tot, els true d'aqui serán pintat en verd i els false en vermell.
     */
    public boolean[] paintableAnswers = new boolean[]
    {
        false,false,false,
        false,false,false,
        false,false,false
    };

    /**
     * Totes les checkboxes.
     */
    public CheckBox checkBox1,checkBox2,checkBox3,
                    checkBox4,checkBox5,checkBox6,
                    checkBox7,checkBox8,checkBox9;

    /**
     * ImageButton principal.
     */
    public ImageButton imageButton;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
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

    /**
     * Funció que gira l'estat d'una checkbox just despres que el jugador l'hi faci click.
     * @param checkbox La checkbox a girar.
     */
    private void alterCheckbox(int checkbox)
    {
        if(currentAnswers[checkbox]) currentAnswers[checkbox]=false;
        else currentAnswers[checkbox]=true;
    }

    /**
     * Funció que s'executa en fer click al ImageButton.
     * Comprova l'estat de les respostes o canvia d'activitat.
     */
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
        else
        {
            int corrects = 0;
            for(int i=0; i<paintableAnswers.length; i++) if(correctAnswers[i]==currentAnswers[i]) corrects++;
            LogicSingleton.PushMoreScores(corrects,9);
            startActivity(LogicSingleton.NextQuestion(ActivityCheckboxes.this));
        }
    }

    /**
     * Omple el array de paintableAnswers que conté informació de quines checkboxes s'han de pintar verd o vermell.
     */
    private void setPaintableAnswers()
    {
        for(int i=0; i<paintableAnswers.length; i++)
        {
            if(correctAnswers[i]==currentAnswers[i]) paintableAnswers[i] = true;
            else paintableAnswers[i] = false;
        }
    }

    /**
     * Pinta les checkboxes segons si estan correctes o incorrectes.
     */
    private void paintCheckboxes()
    {
        if(paintableAnswers[0])
        {
            checkBox1.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox1.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[1])
        {
            checkBox2.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox2.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[2])
        {
            checkBox3.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox3.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[3])
        {
            checkBox4.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox4.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[4])
        {
            checkBox5.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox5.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[5])
        {
            checkBox6.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox6.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[6])
        {
            checkBox7.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox7.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[7])
        {
            checkBox8.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox8.setBackgroundColor(Color.rgb(225,123,123));
        }
        if(paintableAnswers[8])
        {
            checkBox9.setBackgroundColor(Color.rgb(162,240,163));
        }
        else
        {
            checkBox9.setBackgroundColor(Color.rgb(225,123,123));
        }
    }
}
