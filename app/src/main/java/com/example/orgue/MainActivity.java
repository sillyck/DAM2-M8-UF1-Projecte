package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 *  Classe principal de l'activitat principal; la primera pantalla de totes;
 *  a on el jugador posa el seu nom.
 */
public class MainActivity extends AppCompatActivity
{
    /**
     * El camp de text on el jugador posa el seu nom.
     */
    private EditText nom;

    /**
     * ImageButton que al pretar, comença el joc.
     */
    private ImageButton fletxa;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.etnom);
        fletxa = findViewById(R.id.fletxa);
        fletxa.setOnClickListener(v -> onClick());
    }

    /**
     * Funció que s'executa en fer click al ImageButton principal, inicialitza el singleton iç
     * comença a per la primera pregunta.
     */
    public void onClick()
    {
        if(!nom.getText().toString().isEmpty())
        {
            LogicSingleton.Initialize();
            LogicSingleton.SetNewPlayerName(nom.getText().toString());
            startActivity(LogicSingleton.NextQuestion(MainActivity.this));
        }
    }
}