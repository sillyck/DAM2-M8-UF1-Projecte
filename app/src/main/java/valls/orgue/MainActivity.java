package valls.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 *  Classe principal de l'activitat principal; la primera pantalla de totes;
 *  a on el jugador posa el seu nom.
 */
public class MainActivity extends AppCompatActivity
{
    /**
     * El camp de text on el jugador posa el seu nom.
     */
    private EditText nom;

    /**
     * ImageButton que al pretar, comença el joc.
     */
    private ImageButton fletxa;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.etnom);
        fletxa = findViewById(R.id.fletxa);
        fletxa.setOnClickListener(v -> onClick());

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        AudioHolder.canPlayBGM = pref.getBoolean("musica",true);
        AudioHolder.canPlaySFX = pref.getBoolean("sfx_btn",true);
        AudioHolder.canPlayOkKo = pref.getBoolean("sfx_correct",true);

        if(AudioHolder.canPlayBGM) AudioHolder.PlayBgm();
        if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
    }

    @Override
    public void onBackPressed()
    {
        return;
    }

    /**
     * Funció que s'executa en fer click al ImageButton principal, inicialitza el singleton iç
     * comença a per la primera pregunta.
     */
    public void onClick()
    {
        if(!nom.getText().toString().isEmpty())
        {
            if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
            LogicSingleton.Initialize();
            LogicSingleton.SetNewPlayerName(nom.getText().toString());
            startActivity(LogicSingleton.NextQuestion(MainActivity.this));
        }
    }
}