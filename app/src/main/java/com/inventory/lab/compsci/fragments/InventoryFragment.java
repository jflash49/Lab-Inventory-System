package com.inventory.lab.compsci.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.inventory.lab.compsci.R;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class InventoryFragment extends Fragment {
    Button mMonitor, mCPU,mKeyboard,mMice;
    public InventoryFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.inventory_fragment,container,false);
        return v;
    }
}
