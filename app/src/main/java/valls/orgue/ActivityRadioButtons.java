package valls.orgue;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activitat de la pantalla de radiobuttons.
 */
public class ActivityRadioButtons extends AppCompatActivity
{
    /**
     * Estat de la pregunta. Si esta en 0, accepta respostes; 1: contestada.
     */
    public int state = 0;

    /**
     *  Pregunta actual.
     */
    public int question = -1;

    /**
     * Número del radiobutton correcte, segons el LogicSingleton.
     */
    public int correctAnswer = -1;

    /**
     * Número del radiobutton que el jugador ha seleccionat.
     */
    public int selectedAnswer = -1;

    /**
     * Int32 de 3 valors segons si s'ha respost be, malament o no a la preguta.
     * -1: encara no contestat; 0: resposta incorrecta; 1: resposta correcta.
     */
    public int didItGetItRight = -1;

    /**
     * L'ImageButton del botó amb la fletxa per canviar d'estat o continuar amb la seguent pantalla.
     */
    public ImageButton imageButton;

    /**
     * El RadioGroup on passa tota la acció de la pantalla.
     */
    public RadioGroup radioGroup;

    /**
     * Un dels 3 RadioButtons que hi ha a la pantalla.
     */
    public RadioButton radioButton1, radioButton2, radioButton3;

    /**
     * El textView on hi será el titul de la pregunta
     */
    public TextView textView;

    /**
     * L'imatge de la pregunta.
     */
    public ImageView imageView;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
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

        radioButton1.setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.StandardThin);
        });
        radioButton2.setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.StandardThin);
        });
        radioButton3.setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.StandardThin);
        });

        setThingsToQuestion();
    }

    @Override
    public void onBackPressed()
    {
        return;
    }

    /**
     * Metode que es comunica amb el LogicSingleton i obté tota la informació de la pregunta i
     * l'aplica o guarda a on correspongui.
     */
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

    /**
     * Metode que s'executa en fer click al ImageButton principal. Segons correspongui revel·la les
     * respostes o passa a la següent pantalla.
     */
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
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if(didItGetItRight==1) LogicSingleton.PushMoreScores(1,1);
            else LogicSingleton.PushMoreScores(0,1);
            startActivity(LogicSingleton.NextQuestion(ActivityRadioButtons.this));
        }
    }

    /**
     * Comprova cada RadioButton per veure si estan correctes o no.
     */
    @SuppressLint("NonConstantResourceId")
    public void comprovarRadioButtons()
    {
        if(radioGroup.getCheckedRadioButtonId()!=-1)
        {
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

    /**
     * Comprova si la resposta del jugador es correcte o no.
     * @param choice Resposta del jugador
     */
    public void checkIfAnswerCorrect(int choice)
    {
        if(choice==correctAnswer) didItGetItRight = 1;
        else didItGetItRight = 0;
    }

    /**
     * Pinta els colors de fons dels radiobuttons segons si s'ha fet bé o no.
     */
    public void paint()
    {
        if(didItGetItRight==1)
        {
            if(AudioHolder.canPlayOkKo) AudioHolder.PlaySfx(Sound.Warning);
            switch(selectedAnswer)
            {
                case 0: radioButton1.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 1: radioButton2.setBackgroundColor(Color.rgb(162, 240, 163)); break;
                case 2: radioButton3.setBackgroundColor(Color.rgb(162, 240, 163)); break;
            }
        }
        else if(didItGetItRight==0)
        {
            if(AudioHolder.canPlayOkKo) AudioHolder.PlaySfx(Sound.Quit);
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