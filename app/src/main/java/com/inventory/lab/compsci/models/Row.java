package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class Row extends SugarRecord {
    private int Row;
    private String Loc;

    public Row() {
    }

    public Row(int row, String loc) {
        Row = row;
        Loc = loc;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    @Override
    public String toString() {
        return "Row{" +
                "Row=" + Row +
                ", Loc='" + Loc + '\'' +
                '}';
    }


}
