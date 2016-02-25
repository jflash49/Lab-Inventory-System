package com.inventory.lab.compsci.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.inventory.lab.compsci.models.ItemType;
import com.inventory.lab.compsci.models.Row;
import com.orm.SugarRecord;

import java.io.IOException;
import java.util.List;

/**
 * Created by peoplesoft on 2/24/2016.
 */
public class LoadMasterTask  extends AsyncTask<Boolean, Integer ,Boolean> {
    List<Row> rows;
    List<ItemType> itemTypes;

    public LoadMasterTask() {
       try {

        }
       catch(Exception e)
       {
           Log.d("Load Master","Unable to find data");
       }

    }

    @Override
    protected Boolean doInBackground(Boolean... load) {
        try {
            if (load[0] == true) {
                rows = SugarRecord.listAll(Row.class);
                itemTypes = SugarRecord.listAll(ItemType.class);
                if (rows.isEmpty()) {
                    populateRows();
                    if (itemTypes.isEmpty()) {
                        populateItemTypes();
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void populateRows (){
        Row rowitem;
        for (int i=0; i<10;i++){
            rowitem = new Row(i," Row #"+i);
            rowitem.save();
        }
    }

    protected  void populateItemTypes(){
        ItemType type = new ItemType("Monitor");
        ItemType type1 = new ItemType("CPU");
        ItemType type2 = new ItemType("KeyBoard");
        ItemType type3 = new ItemType("Mouse");
    }
}
