package com.inventory.lab.compsci.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.inventory.lab.compsci.models.ItemStatus;
import com.inventory.lab.compsci.models.ItemType;
import com.inventory.lab.compsci.models.Row;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by peoplesoft on 2/24/2016.
 */
public class LoadMasterTask  extends AsyncTask<Boolean, Integer ,Boolean> {
    List<Row> rows;
    List<ItemType> itemTypes;
    List<ItemStatus> statuses;

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
                Log.d("POPULATING MASTERS","populating master tables");
                rows = SugarRecord.listAll(Row.class);
                itemTypes = SugarRecord.listAll(ItemType.class);
                statuses = SugarRecord.listAll(ItemStatus.class);
                if (rows.isEmpty()) {
                    populateRows();
                    if (itemTypes.isEmpty()) {
                        populateItemTypes();
                    }
                    if (statuses.isEmpty()){
                        populateStatus();
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
        for (int i=1; i<10;i++){
            rowitem = new Row(i," Row #"+i);
            rowitem.save();
            Log.d("ROW",rowitem.toString());
        }
    }

    protected  void populateItemTypes(){
        ItemType type = new ItemType("Monitor");
        ItemType type1 = new ItemType("CPU");
        ItemType type2 = new ItemType("KeyBoard");
        ItemType type3 = new ItemType("Mouse");
        type.save();
        Log.d("TYPE", type.toString());
        type1.save();
        Log.d("TYPE", type1.toString());
        type2.save();
        Log.d("TYPE", type2.toString());
        type3.save();
        Log.d("TYPE", type3.toString());
    }
    protected void populateStatus(){
        ItemStatus itemStatus = new ItemStatus("Not Tested");
        ItemStatus itemStatus1 = new ItemStatus("Available");
        ItemStatus itemStatus2 = new ItemStatus("Not Working");
        ItemStatus itemStatus3 = new ItemStatus("Working");
        itemStatus.save();
        itemStatus1.save();
        itemStatus2.save();
        itemStatus3.save();
    }
}
