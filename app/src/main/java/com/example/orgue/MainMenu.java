package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;

public class MainMenu extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        AudioHolder.Start(MainMenu.this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica",true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn",true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct",true);

        findViewById(R.id.joc).setOnClickListener(v ->
        {
//            AudioHolder.PlaySfx(Sound.Standard);
//            AudioHolder.PlayBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, MainActivity.class));
        });
        findViewById(R.id.musica).setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if(AudioHolder.mediaPlayer.isPlaying()) AudioHolder.StopBgm();
//            AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, Music.class));
        });
        findViewById(R.id.preferencies).setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if(AudioHolder.mediaPlayer.isPlaying()) AudioHolder.mediaPlayer.pause();
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

        findViewById(R.id.imgBtn_play).setOnClickListener(v ->
        {
//            AudioHolder.PlaySfx(Sound.Standard);
//            AudioHolder.PlayBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, MainActivity.class));
        });
        findViewById(R.id.imgBtn_music).setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if(AudioHolder.mediaPlayer.isPlaying()) AudioHolder.StopBgm();
//            AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, Music.class));
        });
        findViewById(R.id.imgBtn_settings).setOnClickListener(v ->
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if(AudioHolder.mediaPlayer.isPlaying()) AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(MainMenu.this, Preferencies.class));
        });
        findViewById(R.id.imgBtn_exit).setOnClickListener(v ->
        {
            AudioHolder.mediaPlayerMusic.release();
            AudioHolder.soundPool.release();
            AudioHolder.mediaPlayer.release();
            finishAffinity();
        });
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    protected void onResume()
    {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica",true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn",true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct",true);
    }
}