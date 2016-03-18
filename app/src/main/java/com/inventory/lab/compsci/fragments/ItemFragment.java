package com.inventory.lab.compsci.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.activities.ItemActivity;
import com.inventory.lab.compsci.models.Item;
import com.inventory.lab.compsci.models.ItemRow;
import com.inventory.lab.compsci.models.TestItem;
import com.inventory.lab.compsci.models.TestPeriods;
import com.orm.SugarRecord;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peoplesoft on 2/24/2016.
 */
public class ItemFragment extends Fragment {
    public final static String ITEM = "Item ID";
    Item item;
    TextView mSN, mName, mType, mTag, mItemRow, mTestP, mComment, mStatus, mUser;
    Button mOK;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = SugarRecord.findById(Item.class, (long) getActivity().getIntent().getSerializableExtra(ITEM));
        getActivity().setTitle(R.string.to_item);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_fragment, container, false);
        mComment = (TextView) v.findViewById(R.id.item_comment);
        mOK = (Button) v.findViewById(R.id.ok);
        mOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().finish();
            }
        });
        mSN = (TextView) v.findViewById(R.id.item_sn);
        mSN.setText(item.getSerial());
        mName = (TextView) v.findViewById(R.id.item_name);
        mName.setText(item.getName());
        mType = (TextView) v.findViewById(R.id.item_type);
        mType.setText((item.getType()).getType());
        mTag = (TextView) v.findViewById(R.id.item_tag);
        mTag.setText(item.getUWI_TAG());
        mItemRow = (TextView) v.findViewById(R.id.item_row);
        mItemRow.setText((findItemRow(item).getRow()).getLoc());
        mTestP = (TextView) v.findViewById(R.id.item_test_period);
        mStatus = (TextView) v.findViewById(R.id.item_status);
        mUser = (TextView) v.findViewById(R.id.user_name);

        if (!((findTestItem(findItemRow(item))) == 0)) {
            TestItem testItem = SugarRecord.findById(TestItem.class, findTestItem(findItemRow(item)));
            Toast.makeText(getActivity(), testItem.toString(), Toast.LENGTH_SHORT).show();
            mStatus.setText(testItem.getItemStatus().getName());
            mComment.setText(testItem.getComments());
            if (!(testItem.getTestPeriods() == null))
                mTestP.setText(testItem.getTestPeriods().toString());
            else
                mTestP.setText("No Recorded Test Period");
        } else {
            Toast.makeText(getActivity(), "Test is empty", Toast.LENGTH_SHORT).show();
        }
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.to_item);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public ItemRow findItemRow(Item item) {
        List<ItemRow> itemRows = SugarRecord.find(ItemRow.class, "item = ?", String.valueOf(item.getId()));
        return itemRows.get(0);
    }

    protected long findTestItem(ItemRow itemRow) {
        List<TestItem> testItems = SugarRecord.listAll(TestItem.class);
        if (!(testItems.isEmpty())) {
            for (TestItem testItem : testItems) {
                if ((testItem.getItemrow()) != null) {
                    if ((testItem.getItemrow()).getItem().getSerial().equals(itemRow.getItem().getSerial())) {
                        return testItem.getId();
                    }
                }
            }
        }
        return 0;
    }

}
