package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Music extends AppCompatActivity
{
    TextView textName;
    TextView textTime;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        findViewById(R.id.pin).setOnClickListener(v -> Fix());
        findViewById(R.id.prev).setOnClickListener(v -> Prev());
        findViewById(R.id.control).setOnClickListener(v -> PlayOrPause());
        findViewById(R.id.next).setOnClickListener(v -> Next());
        findViewById(R.id.mode).setOnClickListener(v -> Stop());

        textName = findViewById(R.id.nom);
        textTime = findViewById(R.id.timer);
        progressBar = findViewById(R.id.progressBar);

        textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
        textTime.setText(String.format("%dm %ds",
                TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));
    }

    public void Fix()
    {
        AudioHolder.mediaPlayer = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
    }

    public void Prev()
    {
        if(AudioHolder.selectedIndex!=0)
        {
            AudioHolder.selectedIndex--;
            AudioHolder.mediaPlayerMusic.stop();
            AudioHolder.mediaPlayerMusic = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
            textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
            textTime.setText(String.format("%dm %ds",
                    TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
                    TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));
        }
    }

    public void PlayOrPause()
    {
        if(AudioHolder.mediaPlayerMusic.isPlaying())
        {
            AudioHolder.mediaPlayerMusic.pause();
        }
        else
        {
            AudioHolder.mediaPlayerMusic.start();
        }
    }

    public void Next()
    {
        if(AudioHolder.selectedIndex!=AudioHolder.listOfSongs.length-1)
        {
            AudioHolder.selectedIndex++;
            AudioHolder.mediaPlayerMusic.stop();
            AudioHolder.mediaPlayerMusic = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
            textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
            textTime.setText(String.format("%dm %ds",
                    TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
                    TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));
        }
    }

    public void Stop()
    {
        AudioHolder.mediaPlayerMusic.stop();
    }
}