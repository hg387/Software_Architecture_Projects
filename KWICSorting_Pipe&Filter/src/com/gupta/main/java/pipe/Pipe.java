package com.gupta.main.java.pipe;

public interface Pipe{
    public boolean put(Object obj);
    public Object get() throws InterruptedException;
    public boolean isFull();
    public void setFull(boolean full);
    public Integer getNumsIns();
    public void setNumsIns(Integer numsIns);
}
