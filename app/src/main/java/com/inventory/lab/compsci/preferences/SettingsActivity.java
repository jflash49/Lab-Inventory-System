package com.inventory.lab.compsci.preferences;

import android.preference.PreferenceActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by peoplesoft on 3/1/2016.
 */
public class SettingsActivity extends AppCompatPreferenceActivity {
    LinearLayout root;
    Toolbar toolbar;

    public static final String PREFS_NAME = "LABSYS Preferences";
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setupActionBar();

        settings = PreferenceManager.getDefaultSharedPreferences(this);
//        settings.edit().putBoolean("timetable_notification",true).commit();
//        settings.edit().putBoolean("vibrate_notification",true).commit();
//        setContentView(R.layout.fragment_sas_setting);
//        ToprightBar.setTopOverflow(this);
//       /* ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
//        View content = root.getChildAt(0);
//        LinearLayout toolbarContainer = (LinearLayout) View.inflate(this, R.layout.toolbar_settings, null);
//
//        root.removeAllViews();
//        toolbarContainer.addView(content,1);
//        root.addView(toolbarContainer,0);
////        setContentView(R.layout.fragment_sas_setting);*/
//        toolbar =(Toolbar)findViewById(R.id.toolbar);
//        toolbar.setTitle(getTitle());
//        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
////        setSupportActionBar(toolbar);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new MainSettingsFragment()).commit();
    }
    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

}
