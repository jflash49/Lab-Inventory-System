package com.inventory.lab.compsci.models;

import com.orm.SugarRecord;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class TestItem extends SugarRecord {
    private ItemRow itemrow;
    private TestPeriods testPeriods;
    private String comments;
    private ItemStatus itemStatus;
    private User user;

    public TestItem() {
    }

    public TestItem(ItemRow itemrow, TestPeriods testPeriods, ItemStatus itemStatus, User user, String comments) {
        this.itemrow = itemrow;
        this.testPeriods = testPeriods;
        this.itemStatus = itemStatus;
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

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
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

    @Override
    public String toString() {
        return "Test{" +
                "itemrow=" + itemrow +
                ", testPeriods=" + testPeriods +
                ", comments='" + comments + '\'' +
                ", itemStatus=" + itemStatus +
                ", user=" + user +
                '}';
    }
}
