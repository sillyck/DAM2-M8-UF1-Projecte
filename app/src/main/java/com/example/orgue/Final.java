package com.example.orgue;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity
{
    public Button tancar;
    public TextView textView;

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
    }

    private void onClick()
    {
        this.finishAffinity();
    }
}