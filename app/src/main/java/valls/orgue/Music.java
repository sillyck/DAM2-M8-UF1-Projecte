package valls.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Music extends AppCompatActivity
{
    TextView textName;
    TextView textTime;

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

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica",true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn",true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct",true);

        textName = findViewById(R.id.nom);
        textTime = findViewById(R.id.timer);

        textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
        textTime.setText(String.format("Duració: %dm %ds",
            TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
            TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));

        Next();
        Prev();
    }

    /**
     * Fa que la canço que sona ara mateix en el reproductor de musica sigui la musica que sonará a la partida.
     */
    public void Fix()
    {
        AudioHolder.mediaPlayer = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
        Toast.makeText(this, "Aquesta canço será ara la que sonará enmig de la partida", Toast.LENGTH_SHORT).show();
    }

    /**
     * Passa a la canço anterior de la llista (si es que hi ha una canço anterior).
     */
    public void Prev()
    {
        if(AudioHolder.selectedIndex!=0)
        {
            AudioHolder.selectedIndex--;
            AudioHolder.mediaPlayerMusic.stop();
            AudioHolder.mediaPlayerMusic = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
            textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
            textTime.setText(String.format("Duració: %dm %ds",
                TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));
        }
    }

    /**
     * Reprodueix o pausa la canço del reproductor.
     */
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

    /**
     * Passa a la canço seguent de la llista (si es que hi ha una canço seguent).
     */
    public void Next()
    {
        if(AudioHolder.selectedIndex!=AudioHolder.listOfSongs.length-1)
        {
            AudioHolder.selectedIndex++;
            AudioHolder.mediaPlayerMusic.stop();
            AudioHolder.mediaPlayerMusic = MediaPlayer.create(AudioHolder.currentContext,AudioHolder.listOfSongs[AudioHolder.selectedIndex]);
            textName.setText(AudioHolder.namesOfSongs[AudioHolder.selectedIndex]);
            textTime.setText(String.format("Duració: %dm %ds",
                TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(AudioHolder.mediaPlayerMusic.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioHolder.mediaPlayerMusic.getDuration()))));
        }
    }

    /**
     * Atura la canço del reproductor.
     */
    public void Stop()
    {
        AudioHolder.mediaPlayerMusic.stop();
    }
}