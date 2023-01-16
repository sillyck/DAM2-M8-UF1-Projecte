package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // WARNING!
        // ========
        // REMOVE THIS LINE OF CODE WHEN MERGING; JUST HERE FOR TESTING PROPUSES
        startActivity(new Intent(this, PantallaBotonsImatge.class));
    }
}