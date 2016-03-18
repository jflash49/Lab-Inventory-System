package com.inventory.lab.compsci.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.ItemActivity;
import com.inventory.lab.compsci.activities.UpdateActivity;
import com.inventory.lab.compsci.models.TestItem;
import com.orm.SugarRecord;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/27/2016.
 */
public class TestItemListFragment extends ListFragment {
    List<TestItem> testList;
    List<String> mList= new ArrayList<String>();
    //ArrayAdapter<TestItem>adapter;
    TestItemAdapter adapter;
    ListView listView;
    TextView memptyset;
    public TestItemListFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateTestList();
        adapter = new TestItemAdapter( new ArrayList (testList));
        setListAdapter(adapter);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
        setEmptyText(" No Test Items");
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "Position : " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TestItem c = (TestItem)(getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), ItemActivity.class);
        i.putExtra(ItemFragment.ITEM, c.getItemrow().getItem().getId());
        startActivity(i);
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

    private class TestItemAdapter extends ArrayAdapter<TestItem> {

        public TestItemAdapter (ArrayList<TestItem> testitems){
            super(getActivity(),0,testitems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.test_list_item, null);
            }

            // Configure the view for this Test Item
            TestItem c = getItem(position);
            TextView Name = (TextView)convertView.findViewById(R.id.item_name);
            Name.setText(c.getItemrow().getItem().getName());

            TextView Tag = (TextView)convertView.findViewById(R.id.item_tag);
            Tag.setText(c.getItemrow().getItem().getUWI_TAG());

            return convertView;
        }
    }

}
