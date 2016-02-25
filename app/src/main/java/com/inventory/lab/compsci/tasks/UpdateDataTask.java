package com.inventory.lab.compsci.tasks;

import android.util.Log;


import com.inventory.lab.compsci.R;
import com.inventory.lab.compsci.models.Item;
import com.inventory.lab.compsci.models.ItemType;
import com.orm.SugarRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class UpdateDataTask {
    Item item;
    List<Item> items;
    ItemType itemType;


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

                item = new Item();
                item.setSerial(SN);
                itemType = SugarRecord.findById(ItemType.class,(long)type);
                item.setType(itemType);
                item.setName(name);
                item.setUWI_TAG(tag);
                item.save();
                Log.d("ITEM",item.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cleardatabase(){
        SugarRecord.deleteAll(Item.class);
    }
}
