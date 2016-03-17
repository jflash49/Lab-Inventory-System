package com.inventory.lab.compsci.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.inventory.lab.compsci.services.TestPeriodService;

/**
 * Created by peoplesoft on 2/27/2016.
 */
public class TestPeriodReceiver  extends BroadcastReceiver {
    public static final int REQUEST_CODE = 6200;
    public static final String ACTION = "com.inventory.lab.compsci";
    public static final String UPDATE_ACTION = "UPDATE LAB TECH";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i  = new Intent(context, TestPeriodService.class);
        i.putExtra(UPDATE_ACTION,"Inventory Check");
        context.startService(i);
    }
}