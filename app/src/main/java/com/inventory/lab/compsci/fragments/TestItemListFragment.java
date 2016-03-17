package com.inventory.lab.compsci.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.UpdateActivity;
import com.inventory.lab.compsci.models.TestItem;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/27/2016.
 */
public class TestItemListFragment extends Fragment {
    List<TestItem> testList;
    List<String> mList= new ArrayList<String>();
    ArrayAdapter<String>adapter;
    ListView listView;
    TextView memptyset;
    public TestItemListFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateTestList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_list_fragment, container, false);
        listView = (ListView)v.findViewById(R.id.testlist);
        memptyset = (TextView)v.findViewById(R.id.emptyset);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mList);
        listView.setEmptyView(memptyset);
        listView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_test_list, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_total:
                Snackbar.make(getView(), "Total items tested : ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void populateTestList (){
        testList = SugarRecord.listAll(TestItem.class);
        if (!(testList.isEmpty())){
            for(TestItem testItem:testList){
                mList.add(testItem.toString());
            }
        }
        else{
            mList.add("Nothing Found");
        }
    }

}
