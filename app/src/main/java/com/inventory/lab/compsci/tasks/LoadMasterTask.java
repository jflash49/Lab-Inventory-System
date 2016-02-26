package com.inventory.lab.compsci.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.inventory.lab.compsci.models.ItemType;
import com.inventory.lab.compsci.models.Row;
import com.inventory.lab.compsci.models.Status;
import com.orm.SugarRecord;

import java.io.IOException;
import java.util.List;

/**
 * Created by peoplesoft on 2/24/2016.
 */
public class LoadMasterTask  extends AsyncTask<Boolean, Integer ,Boolean> {
    List<Row> rows;
    List<ItemType> itemTypes;
    List<com.inventory.lab.compsci.models.Status> statuses;

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
                statuses = SugarRecord.listAll(com.inventory.lab.compsci.models.Status.class);
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
        for (int i=0; i<10;i++){
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
        com.inventory.lab.compsci.models.Status status = new com.inventory.lab.compsci.models.Status("Not Tested");
        com.inventory.lab.compsci.models.Status status1 = new com.inventory.lab.compsci.models.Status("Available");
        com.inventory.lab.compsci.models.Status status2 = new com.inventory.lab.compsci.models.Status("Not Working");
        com.inventory.lab.compsci.models.Status status3 = new com.inventory.lab.compsci.models.Status("Working");
        status.save();
        status1.save();
        status2.save();
        status3.save();
    }
}
