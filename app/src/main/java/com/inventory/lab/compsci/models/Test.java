package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class Test extends SugarRecord {
    private ItemRow itemrow;
    private TestPeriods testPeriods;
    private String comments;
    private Status status;
    private User user;

    public Test() {
    }

    public Test(ItemRow itemrow, TestPeriods testPeriods, Status status, User user, String comments) {
        this.itemrow = itemrow;
        this.testPeriods = testPeriods;
        this.status = status;
        this.user = user;
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
