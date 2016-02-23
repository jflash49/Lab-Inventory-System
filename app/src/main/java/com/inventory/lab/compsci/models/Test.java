package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class Test extends SugarRecord {
    private ItemRow itemrow;
    private TestPeriods testPeriods;
    private Status status;
    private User user;

    public Test() {
    }

    public Test(ItemRow itemrow, TestPeriods testPeriods, Status status, User user) {
        this.itemrow = itemrow;
        this.testPeriods = testPeriods;
        this.status = status;
        this.user = user;
    }

    public ItemRow getItemrow() {
        return itemrow;
    }

    public void setItemrow(ItemRow itemrow) {
        this.itemrow = itemrow;
    }

    public TestPeriods getTestPeriods() {
        return testPeriods;
    }

    public void setTestPeriods(TestPeriods testPeriods) {
        this.testPeriods = testPeriods;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
