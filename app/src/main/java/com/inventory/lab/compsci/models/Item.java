package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class Item  extends SugarRecord{
    private String Serial, Name, UWI_TAG;
    private ItemType type;

    public Item() {
    }

    public Item(String serial, String name, String UWI_TAG, ItemType type) {
        Serial = serial;
        Name = name;
        this.UWI_TAG = UWI_TAG;
        this.type = type;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUWI_TAG() {
        return UWI_TAG;
    }

    public void setUWI_TAG(String UWI_TAG) {
        this.UWI_TAG = UWI_TAG;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
