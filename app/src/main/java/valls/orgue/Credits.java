package valls.orgue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de la pregunta de reflexió dels escuts.
 */
public class Credits extends AppCompatActivity
{
    /**
     * Botó que al premel, va a la pantalla final.
     */
    public ImageButton aFinal;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_credits);
        TextView textView = findViewById(R.id.enunciat);
        textView.setText("Creat per:\nXavier Martínez i Jordi Ribellas");
        aFinal = findViewById(R.id.fletxaEscuts);
        aFinal.setOnClickListener(v -> onClick());
    }

    /**
     * Funció que s'executa en fer click al ImageButton.
     * Senzillament va a la pantalla final.
     */
    private void onClick()
    {
        if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
        Intent intent = new Intent(Credits.this, MainMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}