package com.example.orgue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Escuts extends AppCompatActivity
{

    public ImageButton aFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_escuts);
        aFinal = findViewById(R.id.fletxaEscuts);
        aFinal.setOnClickListener(v -> onClick());
    }

    private void onClick() {
        Intent intent = new Intent(Escuts.this, Final.class);
        startActivity(intent);
    }

}
