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
        textView.setText("Aquest es el final de la guia, esperem que t'hagui agradat, "+LogicSingleton.getPlayerName());
    }

    private void onClick() {
        finish();
    }

    @Override
    public void finish() {
        this.finishAffinity();

    }

}