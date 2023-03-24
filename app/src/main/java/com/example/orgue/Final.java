package com.example.orgue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Classe que controla la pantalla final.
 * La pantalla en que dius els stats del jugador i tanca l'aplicació.
 */
public class Final extends AppCompatActivity
{
    /**
     * El botó que en fer-li click executa el metode per tancar l'aplicació.
     */
    public Button tancar;

    /**
     * El TextView a on es posará el text que contindrá els stats.
     */
    public TextView textView;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_final);
        tancar = findViewById(R.id.tancarButton);
        tancar.setOnClickListener(v -> onClick());
        textView = findViewById(R.id.despedida);
        LogicSingleton.StopTimer();

        int perc = ((int)Math.round((double)(100*LogicSingleton.currentScore)/LogicSingleton.totalScore));

        String string = "Aquest es el final de la guia, esperem que t'hagui agradat, "+LogicSingleton.getPlayerName()+"\n\nPuntuació: "+LogicSingleton.currentScore+"/"+LogicSingleton.totalScore+"\n("+ perc +"%)";

        if(LogicSingleton.durationSeconds<=120) string = string +"\nHas tardat "+LogicSingleton.durationSeconds+" segons.";
        else string = string +"\nHas tardat "+LogicSingleton.durationMinutes+" minuts.";

        textView.setText(string);

        AudioHolder.StopBgm();
        AudioHolder.PlaySfx(Sound.Warning);
    }

    /**
     * Tanca l'aplicació en fer click al botó.
     */
    private void onClick()
    {
        AudioHolder.PlaySfx(Sound.StandardThin);
//        this.finishAffinity();
        Intent intent = new Intent(Final.this, MainMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}