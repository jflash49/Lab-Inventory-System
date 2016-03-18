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
import com.inventory.lab.compsci.models.TestItem;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class InventoryListFragment extends ListFragment {
    public final static String TITLE ="Inventory Item";
    public final static String ITEMTYPE = "Item Type";
    public final static int TYPE = 0;
    private String mtitle;
    private int type;
    List<Item> items;
    List<String> itemValues = new ArrayList<>();
    ListView minventorylist;
    TextView mNotify;
    //ArrayAdapter adapter;
    InventoryItemAdapter adapter;

    public InventoryListFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mtitle = (String) getActivity().getIntent().getSerializableExtra(TITLE);
        type = getActivity().getIntent().getIntExtra(ITEMTYPE, TYPE);
        getActivity().setTitle(mtitle);
        populate();
        adapter = new InventoryItemAdapter(new ArrayList(items));
        setListAdapter(adapter);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);
        setEmptyText(" No Items");
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
        Item c = (Item)(getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(), ItemActivity.class);
        i.putExtra(ItemFragment.ITEM, c.getId());
        startActivity(i);
    }


    private class InventoryItemAdapter extends ArrayAdapter<Item> {

        public InventoryItemAdapter(ArrayList<Item> testitems) {
            super(getActivity(), 0, testitems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.inventory_list_item, null);
            }

            // Configure the view for this Test Item
            Item c = getItem(position);
            TextView SN = (TextView) convertView.findViewById(R.id.SN);
            SN.setText(c.getSerial());

            TextView Name = (TextView) convertView.findViewById(R.id.Name);
            Name.setText(c.getName());

            return convertView;
        }
    }
}
