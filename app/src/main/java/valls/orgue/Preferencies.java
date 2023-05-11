package valls.orgue;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class Preferencies extends PreferenceActivity
{
    @SuppressWarnings("deprecation")
    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}