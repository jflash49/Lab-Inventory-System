package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class ItemTotal extends SugarRecord {

    private int total_items;

    public ItemTotal(int total_items) {
        this.total_items = total_items;
    }

    public ItemTotal() {
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    @Override
    public String toString() {
        return "Total{" +
                "total_items=" + total_items +
                '}';
    }
}
