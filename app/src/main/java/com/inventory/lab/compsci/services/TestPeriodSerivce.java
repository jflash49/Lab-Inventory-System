package com.inventory.lab.compsci.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class TestPeriodSerivce extends IntentService{

    public TestPeriodSerivce(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
