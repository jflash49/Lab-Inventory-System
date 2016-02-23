package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class TestPeriods extends SugarRecord{
    private Date startdt, enddt;

    public TestPeriods() {
    }

    public TestPeriods(Date startdt, Date enddt) {
        this.startdt = startdt;
        this.enddt = enddt;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }
}
