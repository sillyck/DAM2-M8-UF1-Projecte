package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        findViewById(R.id.joc).setOnClickListener(v -> startActivity(new Intent(MainMenu.this, MainActivity.class)));
        findViewById(R.id.musica).setOnClickListener(v -> startActivity(new Intent(MainMenu.this, Final.class)));
        findViewById(R.id.preferencies).setOnClickListener(v -> startActivity(new Intent(MainMenu.this, Final.class)));
        findViewById(R.id.tancarButton).setOnClickListener(v -> finishAffinity());

    }
}