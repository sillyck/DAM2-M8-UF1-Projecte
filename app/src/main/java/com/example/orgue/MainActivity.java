package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private ImageButton fletxa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.etnom);
    }

    public void onClick(View v) {
        //
        // Uncomment when class ready, otherwise it errors on compile!
        //

        // startActivity(new Intent(MainActivity.this, SeguentActivity.class));
    }
}