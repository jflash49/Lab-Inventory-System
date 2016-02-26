package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/26/2016.
 */
public class Total extends SugarRecord {

    private int total_items;

    public Total(int total_items) {
        this.total_items = total_items;
    }

    public Total() {
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
