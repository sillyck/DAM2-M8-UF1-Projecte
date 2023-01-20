package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
{
    private EditText nom;
    private ImageButton fletxa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.etnom);
        fletxa = findViewById(R.id.fletxa);
        fletxa.setOnClickListener(v -> onClick());
    }

    public void onClick()
    {
        LogicSingleton.Initialize();
        LogicSingleton.SetNewPlayerName(nom.getText().toString());
        startActivity(LogicSingleton.NextQuestion(MainActivity.this));
    }
}