package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.setTime(startdt); // add(Calendar.DATE, 1);
        cal2.setTime(enddt);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
       // System.out.println(cal.getTime());
// Output "Wed Sep 26 14:23:28 EST 2012"

        String start_date= format1.format(cal.getTime());
        String end_date= format1.format(cal2.getTime());
       // System.out.println(formatted);
// Output "2012-09-26"
        return start_date+" / "+end_date;
    }
}
