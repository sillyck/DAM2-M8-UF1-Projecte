package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class PantallaBotonsImatge extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botons_imatge);

        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
    }

    public static void setComponentState(Context context, String packageName, String componentClassName, boolean enabled)
    {
        PackageManager pm  = context.getApplicationContext().getPackageManager();
        ComponentName componentName = new ComponentName(packageName, componentClassName);
        int state = enabled
                ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                : PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        pm.setComponentEnabledSetting(componentName, state, PackageManager.DONT_KILL_APP);
    }
}