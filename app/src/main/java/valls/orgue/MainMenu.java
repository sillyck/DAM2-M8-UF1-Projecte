package valls.orgue;

import static androidx.core.app.ActivityCompat.finishAffinity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainMenu extends Fragment
{
    private static final String TAG = "MainMenu";
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        return inflater.inflate(R.layout.activity_main_menu, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_menu);

        v = getView();

        AudioHolder.Start(v.getContext());

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(v.getContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica", true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn", true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct", true);

        v.findViewById(R.id.tv_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              AudioHolder.PlaySfx(Sound.Standard);
//              AudioHolder.PlayBgm();
                AudioHolder.mediaPlayerMusic.stop();
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
        v.findViewById(R.id.tv_play2).setOnClickListener(v ->
        {
            if (AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if (AudioHolder.mediaPlayer.isPlaying()) AudioHolder.StopBgm();
//            AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), Music.class));
        });
        v.findViewById(R.id.imgBtn_settings).setOnClickListener(v ->
        {
            if (AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if (AudioHolder.mediaPlayer.isPlaying()) AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), Preferencies.class));
        });
        v.findViewById(R.id.imgBtn_exit).setOnClickListener(v ->
        {
            AudioHolder.mediaPlayerMusic.release();
            AudioHolder.soundPool.release();
            AudioHolder.mediaPlayer.release();
            getActivity().finishAffinity();
        });

        v.findViewById(R.id.imgBtn_play).setOnClickListener(v ->
        {
//            AudioHolder.PlaySfx(Sound.Standard);
//            AudioHolder.PlayBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), MainActivity.class));
        });
        v.findViewById(R.id.imgBtn_music).setOnClickListener(v ->
        {
            if (AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if (AudioHolder.mediaPlayer.isPlaying()) AudioHolder.StopBgm();
//            AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), Music.class));
        });
        v.findViewById(R.id.imgBtn_info).setOnClickListener(v ->
        {
//            AudioHolder.PlaySfx(Sound.Standard);
//            AudioHolder.PlayBgm();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), Credits.class));
        });
        v.findViewById(R.id.imgBtn_settings).setOnClickListener(v ->
        {
            if (AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            if (AudioHolder.mediaPlayer.isPlaying()) AudioHolder.mediaPlayer.pause();
            AudioHolder.mediaPlayerMusic.stop();
            startActivity(new Intent(v.getContext(), Preferencies.class));
        });
        v.findViewById(R.id.imgBtn_exit).setOnClickListener(v ->
        {
            AudioHolder.mediaPlayerMusic.release();
            AudioHolder.soundPool.release();
            AudioHolder.mediaPlayer.release();
            getActivity().finishAffinity();
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
    public void onResume()
    {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica",true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn",true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct",true);
    }
}