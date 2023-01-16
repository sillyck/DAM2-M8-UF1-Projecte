package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class PantallaBotonsImatge extends AppCompatActivity
{
    public int state = 0;
    public int question = -1;

    private LinearLayout linearLayoutPregunta, linearLayoutResposta, linearLayoutContinuar;
    private ImageButton imageButton001, imageButton002, imageButton003, imageButton004,
                        imageButton005, imageButton006, imageButton007, imageButton008,
                        imageButton009, imageButton010, imageButton011, imageButton012;
    private ImageButton imageButtonPregunta, imageButtonResposta, imageButtonContinuar;
    private TextView textViewPregunta, textViewResposta, textViewTitle;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botons_imatge);

        identificarComponents();
//        imageButtonPregunta.setOnClickListener(v -> setState(0));
//        imageButtonResposta.setOnClickListener(v -> setState(1));

        setState(0);

        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
    }

    public void setState(int state)
    {
        System.out.println(state);
        this.state = state;
        changeComponentStates(state);
    }

    public void changeComponentStates(int state)
    {
        linearLayoutPregunta.setVisibility(View.GONE);
        linearLayoutResposta.setVisibility(View.GONE);
        linearLayoutContinuar.setVisibility(View.GONE);
        tableLayout.setVisibility(View.GONE);
        textViewTitle.setVisibility(View.GONE);
        switch(state)
        {
            case 0:
                linearLayoutPregunta.setVisibility(View.GONE);
                linearLayoutResposta.setVisibility(View.VISIBLE);
                linearLayoutContinuar.setVisibility(View.GONE);
                tableLayout.setVisibility(View.GONE);
                textViewTitle.setVisibility(View.VISIBLE);
                break;
            case 1:
                linearLayoutPregunta.setVisibility(View.VISIBLE);
                linearLayoutResposta.setVisibility(View.GONE);
                linearLayoutContinuar.setVisibility(View.GONE);
                tableLayout.setVisibility(View.VISIBLE);
                textViewTitle.setVisibility(View.GONE);
                break;
            case 2:
                linearLayoutPregunta.setVisibility(View.GONE);
                linearLayoutResposta.setVisibility(View.GONE);
                linearLayoutContinuar.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.VISIBLE);
                textViewTitle.setVisibility(View.GONE);
            break;
        }
    }

    @SuppressWarnings("unused")
    public static void setComponentState(Context context, String packageName, String componentClassName, boolean enabled)
    {
        PackageManager pm = context.getApplicationContext().getPackageManager();
        ComponentName componentName = new ComponentName(packageName, componentClassName);
        int state = enabled
                ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                : PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        pm.setComponentEnabledSetting(componentName, state, PackageManager.DONT_KILL_APP);
    }

    private void identificarComponents()
    {
        linearLayoutPregunta = findViewById(R.id.linearLayoutPregunta);
        linearLayoutResposta = findViewById(R.id.linearLayoutResposta);
        linearLayoutContinuar = findViewById(R.id.linearLayoutContinuar);

        imageButtonPregunta = findViewById(R.id.imageButtonPregunta);
        imageButtonResposta = findViewById(R.id.imageButtonResposta);
        imageButtonContinuar = findViewById(R.id.imageButtonContinuar);
        textViewPregunta = findViewById(R.id.textViewPregunta);
        textViewResposta = findViewById(R.id.textViewRespota);
        textViewTitle = findViewById(R.id.textViewTitle);
        tableLayout = findViewById(R.id.tableLayout);

        imageButton001 = findViewById(R.id.imageButton001);
        imageButton002 = findViewById(R.id.imageButton002);
        imageButton003 = findViewById(R.id.imageButton003);
        imageButton004 = findViewById(R.id.imageButton004);
        imageButton005 = findViewById(R.id.imageButton005);
        imageButton006 = findViewById(R.id.imageButton006);
        imageButton007 = findViewById(R.id.imageButton007);
        imageButton008 = findViewById(R.id.imageButton008);
        imageButton009 = findViewById(R.id.imageButton009);
        imageButton010 = findViewById(R.id.imageButton010);
        imageButton011 = findViewById(R.id.imageButton011);
        imageButton012 = findViewById(R.id.imageButton012);
    }

    @Deprecated
    public void imageButtonBottomOnClick(View v)
    {
        setState(1);
    }

    public void imageButtonPreguntaOnClick(View v)
    {
        setState(0);
    }

    public void imageButtonRespostaOnClick(View v)
    {
        setState(1);
    }

    public void imageButtonContinuarOnClick(View v)
    {
        setState(2);
    }
}