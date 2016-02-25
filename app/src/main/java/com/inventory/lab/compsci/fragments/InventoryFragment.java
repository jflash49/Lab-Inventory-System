package com.inventory.lab.compsci.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.InventoryActivity;

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
        mMonitor = (Button)v.findViewById(R.id.to_monitors);
        mMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                i.putExtra(InventoryListFragment.TITLE,getResources().getString(R.string.to_monitors));
                i.putExtra(InventoryListFragment.ITEMTYPE,1);
                startActivity(i);
            }
        });
        mCPU = (Button)v.findViewById(R.id.to_cpus);
        mCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                i.putExtra(InventoryListFragment.TITLE,getResources().getString(R.string.to_cpus));
                i.putExtra(InventoryListFragment.ITEMTYPE,2);
                startActivity(i);
            }
        });
        mKeyboard = (Button)v.findViewById(R.id.to_keyboards);
        mKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                i.putExtra(InventoryListFragment.TITLE,getResources().getString(R.string.to_keyboards));
                i.putExtra(InventoryListFragment.ITEMTYPE,3);
                startActivity(i);
            }
        });
        mMice = (Button)v.findViewById(R.id.to_mice);
        mMice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                i.putExtra(InventoryListFragment.TITLE,getResources().getString(R.string.to_mice));
                i.putExtra(InventoryListFragment.ITEMTYPE,4);
                startActivity(i);
            }
        });
        return v;
    }
}
