package com.example.orgue;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioHolder
{
    public static SoundPool soundPool;
    public static MediaPlayer mediaPlayer;
    public static Context currentContext;
    public static int sfxid_standard;
    public static int sfxid_standardthin;
    public static int sfxid_warning;
    public static int sfxid_quit;

    public static void Start()
    {
        Start(currentContext);
    }

    public static void Start(Context context)
    {
        currentContext = context;

        soundPool = new SoundPool.Builder().setMaxStreams(3).build();

        sfxid_standard     = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standard,    1);
        sfxid_standardthin = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standardthin,1);
        sfxid_warning      = soundPool.load(currentContext, R.raw.marieta_r3_sfx_warning,     1);
        sfxid_quit         = soundPool.load(currentContext, R.raw.marieta_r3_sfx_quit,        1);
    }

    public static void PlaySfx(Sound sound)
    {
        switch(sound)
        {
            case Standard:
                soundPool.play(sfxid_standard,1.0f,1.0f,1,0,1.0f);
                break;
            case StandardThin:
                soundPool.play(sfxid_standardthin,1.0f,1.0f,1,0,1.0f);
                break;
            case Warning:
                soundPool.play(sfxid_warning,1.0f,1.0f,1,0,1.0f);
                break;
            case Quit:
                soundPool.play(sfxid_quit,1.0f,1.0f,1,0,1.0f);
                break;
        }
    }

    public static void StopSfx()
    {
        soundPool.autoPause();
    }

    public static void StopSfx(Sound sound)
    {

    }

    public static void PlayBgm()
    {
        mediaPlayer.start();
    }

    public static void PlayBgm(int resid)
    {
        mediaPlayer = MediaPlayer.create(currentContext, resid);
        PlayBgm();
    }

    public static void PauseBgm()
    {
        mediaPlayer.pause();
    }

    public static void ResumeBgm()
    {
        mediaPlayer.reset();
    }

    public static void ResetBgm()
    {
        mediaPlayer.reset();
    }
}

enum Sound
{
    Standard,
    StandardThin,
    Warning,
    Quit
}