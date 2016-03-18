package com.inventory.lab.compsci.tasks;

import android.util.Log;


import com.inventory.lab.compsci.models.Item;
import com.inventory.lab.compsci.models.ItemRow;
import com.inventory.lab.compsci.models.ItemType;
import com.inventory.lab.compsci.models.Row;
import com.inventory.lab.compsci.models.ItemTotal;
import com.inventory.lab.compsci.models.TestItem;
import com.orm.SugarRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class UpdateDataTask {
    protected Item item;
    protected ItemType itemType;
    protected ItemRow itemRow;
    protected Row iRow;
    protected ItemTotal mtotal;
    protected int total = 0;


    public UpdateDataTask(JSONObject obj) {
        try {
            JSONArray rows = obj.getJSONArray("rows");
            cleardatabase();
            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

               // int position = columns.getJSONObject(0).getInt("v");
                String SN = columns.getJSONObject(0).getString("v");
                int type = columns.getJSONObject(1).getInt("v");
                String name  = columns.getJSONObject(2).getString("v");
                String tag = columns.getJSONObject(3).getString("v");
                int mrow = columns.getJSONObject(4).getInt("v");

                item = new Item();
                itemRow = new ItemRow();
                item.setSerial(SN);

                itemType = SugarRecord.findById(ItemType.class, (long) type);
                item.setType(itemType);
                item.setName(name);
                item.setUWI_TAG(tag);
                item.save();

                iRow = SugarRecord.findById(Row.class,(long)mrow);
                itemRow.setItem(item);
                itemRow.setRow(iRow);

                itemRow.save();
                Log.d("ITEM", item.toString());
                Log.d("ITEMROW", itemRow.toString());
                if (!(SN.equals("N/A")))
                    total++;
            }
            mtotal = new ItemTotal();
            mtotal.setTotal_items(total);
            mtotal.save();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cleardatabase(){
        SugarRecord.deleteAll(Item.class);
        SugarRecord.deleteAll(ItemRow.class);
        SugarRecord.deleteAll(TestItem.class);
    }
}
