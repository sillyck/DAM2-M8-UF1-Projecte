package com.example.orgue;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
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

        int i = ((int)Math.round((double)(100*LogicSingleton.currentScore)/LogicSingleton.totalScore));

//        StringBuilder sb = new StringBuilder(new StringBuilder().append("Aquest es el final de la guia, esperem que t'hagui agradat, ").append(LogicSingleton.getPlayerName()).append("\n\nPuntuació: ").append(LogicSingleton.currentScore).append("/").append(LogicSingleton.totalScore).append("\n(").append(i).append("%)").toString());
        String s = "Aquest es el final de la guia, esperem que t'hagui agradat, "+LogicSingleton.getPlayerName()+"\n\nPuntuació: "+LogicSingleton.currentScore+"/"+LogicSingleton.totalScore+"\n("+i+"%)";

        System.out.println("s = " + s);
        System.out.println("i = " + i);
        System.out.println("textView.getText() = " + textView.getText());


        textView.setText(s);
        System.out.println("textView.getText() = " + textView.getText());
    }

    private void onClick() {
        finish();
    }

    @Override
    public void finish() {
        this.finishAffinity();

    }

}