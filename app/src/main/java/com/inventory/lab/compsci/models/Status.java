package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class Status extends SugarRecord {
    private String Name;

    public Status() {
    }

    public Status(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
