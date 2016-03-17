package com.inventory.lab.compsci.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.inventory.lab.compsci.R;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class MainFragment extends Fragment {
    Button mInventory, mTest,mViewLog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        mInventory = (Button) v.findViewById(R.id.to_inventory);
        mInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Fragment fragment = new InventoryFragment();

                fm.beginTransaction()
                        .replace(R.id.inventory_container, fragment)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .addToBackStack(null)
                        .commit();
            }
        });

        mTest = (Button)v.findViewById(R.id.to_test);
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Fragment fragment = new TestFragment();

                fm.beginTransaction()
                        .replace(R.id.inventory_container, fragment)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .addToBackStack(null)
                        .commit();
            }
        });
        mViewLog = (Button)v.findViewById(R.id.to_log);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
