package com.inventory.lab.compsci.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.ItemActivity;
import com.inventory.lab.compsci.models.Item;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class InventoryListFragment extends Fragment {
    public final static String TITLE ="Inventory Item";
    public final static String ITEMTYPE = "Item Type";
    public final static int TYPE = 0;
    private String mtitle;
    private int type;
    List<Item> items;
    List<String> itemValues = new ArrayList<>();
    ListView minventorylist;
    TextView mNotify;
    ArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mtitle = (String) getActivity().getIntent().getSerializableExtra(TITLE);
        type = getActivity().getIntent().getIntExtra(ITEMTYPE, TYPE);
        getActivity().setTitle(mtitle);
        populate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.inventory_list_fragment, container, false);
        mNotify = (TextView) v.findViewById(R.id.emptyset);
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                itemValues);
        minventorylist = (ListView)v.findViewById(R.id.itemlist);
        minventorylist.setEmptyView(mNotify);
        minventorylist.setAdapter(adapter);
        minventorylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(getActivity(), ""+getItemId(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ItemActivity.class);
                intent.putExtra(ItemFragment.ITEM, getItemId(i));
                startActivity(intent);
            }
        });
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


    public void populate(){
        items = SugarRecord.listAll(Item.class);
        if (!(items.isEmpty())) {
            for (Item item : items) {
                itemValues.add(item.toString());
            }
        }
        else
        {
            Toast.makeText(getActivity(),"Database Empty",Toast.LENGTH_SHORT).show();
        }
    }

    public long getItemId(int pos){
        List<Item>items = SugarRecord.listAll(Item.class);
        return (items.get(pos)).getId();
    }
}
