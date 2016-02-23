package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class ItemRow extends SugarRecord {
    Item item;
    Row row;

    public ItemRow() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }
}
