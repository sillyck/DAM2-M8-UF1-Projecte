package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        AudioHolder.Start(MainMenu.this);

        findViewById(R.id.joc).setOnClickListener(v ->
        {
//            AudioHolder.PlaySfx(Sound.Standard);
//            AudioHolder.PlayBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, MainActivity.class));
        });
        findViewById(R.id.musica).setOnClickListener(v ->
        {
            AudioHolder.PlaySfx(Sound.Standard);
            AudioHolder.StopBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, Music.class));
        });
        findViewById(R.id.preferencies).setOnClickListener(v ->
        {
            AudioHolder.PlaySfx(Sound.Standard);
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, Preferencies.class));
        });
        findViewById(R.id.tancarButton).setOnClickListener(v ->
        {
            AudioHolder.mediaPlayerMusic.release();
            AudioHolder.soundPool.release();
            AudioHolder.mediaPlayer.release();
            finishAffinity();
        });
    }
}