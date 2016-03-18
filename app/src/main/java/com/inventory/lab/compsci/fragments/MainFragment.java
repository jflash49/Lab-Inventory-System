package com.inventory.lab.compsci.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.Snackbar;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.models.TestItem;
import com.inventory.lab.compsci.tasks.AsyncResultMessage;
import com.inventory.lab.compsci.tasks.PostLogTask;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class MainFragment extends Fragment {
    Button mInventory, mTest,mViewLog,mUpload;
    List<TestItem> testItemList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.lab_tech);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(R.string.to_main);
        //getActivity().ActionBar().setSubtitle(R.string.to_main);
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
        mViewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                Fragment fragment = new TestItemListFragment();

                fm.beginTransaction()
                        .replace(R.id.inventory_container, fragment)
                        .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .addToBackStack(null)
                        .commit();
                 }
        });
        mUpload = (Button)v.findViewById(R.id.upload_log);
        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testItemList = SugarRecord.listAll(TestItem.class);
                TestItem testItem =testItemList.get(0);
               /* ArrayList<String>output = new ArrayList<String>();
                output.add(testItem.getItemrow().getItem().getName());
                output.add(testItem.getItemrow().getRow().getLoc());
                //output.add(testItem.getTestPeriods().toString());
                output.add("No Test Period");
                output.add(testItem.getItemStatus().getName());
                output.add(testItem.getComments());
                output.add("No user");
                //output.add(testItem.getUser().getFirstname());*/
                new PostLogTask(new AsyncResultMessage() {
                    @Override
                    public void onResult(String message) {
                        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }).execute(testItem.getItemrow().getItem().getName(), testItem.getItemrow().getRow().getLoc(),
                        "No Test Period", testItem.getItemStatus().getName(), testItem.getComments(), "No user");

            }
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.lab_tech);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(R.string.to_main);
        //getActivity().getActionBar().setSubtitle(R.string.to_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
