package com.example.mac.tasktimer;

import java.io.Serializable;

/**
 * Created by mac on 2/24/17.
 */

class Task implements Serializable {
    public static final long serialVersionUID = 20170224L;

    private long m_id;
    private final String mName;
    private final String mDescription;
    private final int mSortOrder;

    public Task(long id, String name, String description, int sortOrder) {
        this.m_id = id;
        mDescription = description;
        mName = name;
        mSortOrder = sortOrder;
    }

    public int getSortOrder() {
        return mSortOrder;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public long getId() {
        return m_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "m_id=" + m_id +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mSortOrder=" + mSortOrder +
                '}';
    }
}
