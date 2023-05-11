package valls.orgue;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;

/**
 * Classe estatica que controla la musica de la partida, la musica del reproductor i els efectes de so.
 */
public class AudioHolder
{
    /**
     * Array de codis de recursos de les cançons del reproductor.
     */
    public static int[] listOfSongs = new int[]
    {
        R.raw.fe_awakening_ost_conquest,
        R.raw.layton1_puzzle
    };

    /**
     * Array de noms de les musiques del reproductor.
     */
    public static String[] namesOfSongs = new String[]
    {
        "Placeholder 1: \"FE:A\"",
        "Placeholder 2: \"L1\""
    };

    /**
     * Numero de la canço de la llista que esta seleccionada ara mateix.
     */
    public static int selectedIndex = 0;

    /**
     * Objecte SoundPool que s'usará per reproduir els efectes de so.
     */
    public static SoundPool soundPool;

    /**
     * Objecte MediaPlayer que s'usará per reproduir la musica durant la partida.
     */
    public static MediaPlayer mediaPlayer;

    /**
     * Objecte MediaPlayer que s'usará per reproduir la musica del reproductor.
     */
    public static MediaPlayer mediaPlayerMusic;

    /**
     * Contexte de la pantalla inicial.
     */
    public static Context currentContext;

    /**
     * Id d'audio del so de pulsació standard.
     */
    public static int sfxid_standard;

    /**
     * Id d'audio del so de pulsació menor.
     */
    public static int sfxid_standardthin;

    /**
     * Id d'audio del so "d'avis" (usat per a senyalar una pregunta correcta).
     */
    public static int sfxid_warning;

    /**
     * Id d'audio del so "sortida" (usat per a senyalar respostes incorrectes).
     */
    public static int sfxid_quit;

    /**
     * Boolean que beu de les preferencies. Si esta a true, es reproduirá la musica de fons.
     */
    public static boolean canPlayBGM = true;

    /**
     * Boolean que beu de les preferencies. Si esta a true, sonaran els efectes de so en premer botons i opcions.
     */
    public static boolean canPlaySFX = true;

    /**
     * Boolean que beu de les preferencies. Si esta a true, sonaran els sons de preguntes correctes e incorrectes.
     */
    public static boolean canPlayOkKo = true;

    /**
     * Si esta a true, es que el Start(9 ja s'ha executat; aixi evitar sobreescriure objectes ja inicialitzats i evita errors.
     */
    public static boolean isStarted = false;

    /**
     * Inicialitza el singleton perque es pugui usar.
     */
    public static void Start()
    {
        Start(currentContext);
    }

    /**
     * Inicialitza el singleton perque es pugui usar.
     *
     * @param context Contexte actual
     */
    public static void Start(Context context)
    {
        if(!isStarted)
        {
            isStarted = true;
            currentContext = context;
            soundPool = new SoundPool.Builder().setMaxStreams(3).build();
            mediaPlayer = MediaPlayer.create(currentContext,listOfSongs[selectedIndex]);
            mediaPlayer.setVolume(0.35f,0.35f);
            mediaPlayerMusic = MediaPlayer.create(currentContext,listOfSongs[selectedIndex]);

            sfxid_standard     = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standard,    1);
            sfxid_standardthin = soundPool.load(currentContext, R.raw.marieta_r3_sfx_standardthin,1);
            sfxid_warning      = soundPool.load(currentContext, R.raw.correct,1);
            sfxid_quit         = soundPool.load(currentContext, R.raw.fail,   1);
        }
    }

    /**
     * Reprodueix un efecte de so.
     *
     * @param sound L'efecte de so que es vol reproduir.
     */
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

    /**
     * Pausa tots els efectes de so.
     */
    public static void StopSfx()
    {
        soundPool.autoPause();
    }

    /**
     * Comença a reproduir la musica de fons de la partida.
     */
    public static void PlayBgm()
    {
        mediaPlayer.start();
    }

    /**
     * Comença a reproduir una canço en espeficic en el MediaPlayer de la musica en la partida.
     *
     * @param resid El ResourceID de la musica a reproduir.
     */
    public static void PlayBgm(int resid)
    {
        mediaPlayer = MediaPlayer.create(currentContext, resid);
        PlayBgm();
    }

    /**
     * Pausa la musica de fons de la partida.
     */
    public static void PauseBgm()
    {
        mediaPlayer.pause();
    }

    /**
     * Continua la reproducció de la musica de fons de la partida.
     */
    public static void ResumeBgm()
    {
        mediaPlayer.reset();
    }

    /**
     * Reinicia la musica de fons de la partida.
     */
    public static void ResetBgm()
    {
        mediaPlayer.reset();
    }

    /**
     * Atura la musica de fons de la partida.
     */
    public static void StopBgm()
    {
        mediaPlayer.stop();
    }
}

/**
 * Enum amb tots els tipus de sons que poden sonar com a efectes de so.
 */
enum Sound
{
    Standard,
    StandardThin,
    Warning,
    Quit
}