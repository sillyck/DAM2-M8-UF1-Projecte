package com.example.orgue;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity
{
    public ImageButton tancar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_final);
        tancar = findViewById(R.id.tancarButton);
        tancar.setOnClickListener(v -> onClick());
    }

    private void onClick() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();

    }

}