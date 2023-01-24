package com.example.orgue;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaRelacionar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Spinner miSpinner = (Spinner) findViewById(R.id.spinner1);

    miSpinner.setPrompt("Seleccione una opción");


}
