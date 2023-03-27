package com.example.orgue;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioHolder
{
    public static int[] listOfSongs = new int[]
    {
        R.raw.fe_awakening_ost_conquest,
        R.raw.layton1_puzzle
    };

    public static String[] namesOfSongs = new String[]
    {
        "Placeholder 1: \"FE:A\"",
        "Placeholder 2: \"L1\""
    };

    public static int selectedIndex = 0;
    public static SoundPool soundPool;
    public static MediaPlayer mediaPlayer;
    public static MediaPlayer mediaPlayerMusic;
    public static Context currentContext;
    public static int sfxid_standard;
    public static int sfxid_standardthin;
    public static int sfxid_warning;
    public static int sfxid_quit;
    public static boolean canPlayBGM = true;
    public static boolean canPlaySFX = true;
    public static boolean canPlayOkKo = true;
    public static boolean isStarted = false;

    public static void Start()
    {
        Start(currentContext);
    }

    public static void Start(Context context)
    {
        if(isStarted==false)
        {
            isStarted = true;
            currentContext = context;
            soundPool = new SoundPool.Builder().setMaxStreams(3).build();
//          mediaPlayer = MediaPlayer.create(currentContext,R.raw.fe_awakening_ost_conquest);
            mediaPlayer = MediaPlayer.create(currentContext,listOfSongs[selectedIndex]);
            mediaPlayer.setVolume(0.35f,0.35f);
            mediaPlayerMusic = MediaPlayer.create(currentContext,listOfSongs[selectedIndex]);

            sfxid_standard     = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standard,    1);
            sfxid_standardthin = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standardthin,1);
            sfxid_warning      = soundPool.load(currentContext, R.raw.correct,1);
            sfxid_quit         = soundPool.load(currentContext, R.raw.fail,   1);
        }
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

    public static void StopBgm()
    {
        mediaPlayer.stop();
    }
}

enum Sound
{
    Standard,
    StandardThin,
    Warning,
    Quit
}