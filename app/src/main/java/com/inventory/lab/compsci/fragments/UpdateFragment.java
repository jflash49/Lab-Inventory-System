package com.inventory.lab.compsci.fragments;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.SimpleScannerActivity;
import com.inventory.lab.compsci.models.Item;
import com.inventory.lab.compsci.models.ItemRow;
import com.inventory.lab.compsci.models.Status;
import com.inventory.lab.compsci.models.Test;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class UpdateFragment extends Fragment {
    TextView mSN, mName, mType,mTag;
    EditText mComment;
    Button mOK, mCancel;
    public final static String ITEM_ID = "ITEM_ID";
    Item item;
    List<Status> statuses;
    List<String> mstatus = new ArrayList<String>();
    ArrayAdapter<String> spinadapter;
    Spinner spinner;
    Test test;
    long mid;
    int status_choice = 0;
    public UpdateFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = SugarRecord.findById(Item.class,(long)getActivity().getIntent().getSerializableExtra(ITEM_ID));
        populatespinner();
        getActivity().setTitle(R.string.to_update);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.update_fragment, container, false);
        spinner = (Spinner)v.findViewById(R.id.status_list);
        mComment = (EditText)v.findViewById(R.id.item_comment);
        mOK = (Button)v.findViewById(R.id.ok);
        mOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test = new Test();
                test.setStatus(SugarRecord.findById(Status.class, (long)status_choice));
                test.setComments(mComment.getText().toString());
                test.setItemrow(findItemRow(item));
                test.save();
            }
        });
        mCancel = (Button)v.findViewById(R.id.cancel);
        mSN = (TextView)v.findViewById(R.id.item_sn);
        mSN.setText(item.getSerial());
        mName = (TextView)v.findViewById(R.id.item_name);
        mName.setText(item.getName());
        mType = (TextView)v.findViewById(R.id.item_type);
        mType.setText((item.getType()).getType());
        mTag = (TextView)v.findViewById(R.id.item_tag);
        mTag.setText(item.getUWI_TAG());

        spinadapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,mstatus);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                status_choice = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner.setAdapter(spinadapter);
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

    public void populatespinner(){
        statuses = SugarRecord.listAll(Status.class);
        if (!(statuses.isEmpty())) {
           for (Status stat : statuses) {
                mstatus.add(stat.getName());
            }
            //mstatus.add("Data Found");
        }
        else{
            mstatus.add("No Data Found");
        }
    }

    public ItemRow findItemRow(Item item){
        List <ItemRow> itemRows = SugarRecord.find(ItemRow.class, "item = ?", String.valueOf(item.getId()));
        Toast.makeText(getActivity()," "+itemRows.get(0).getItem().toString(),Toast.LENGTH_SHORT).show();
        return itemRows.get(0);
    }
}