package com.inventory.lab.compsci.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inventory.lab.compsci.R;

/**
 * Created by peoplesoft on 3/1/2016.
 */
public class MainSettingsFragment  extends PreferenceFragment {
    //Switch mvibrate;
   // CheckBox mnotify;
    SharedPreferences settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Oh yeah");
        addPreferencesFromResource(R.xml.main_preferences);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
