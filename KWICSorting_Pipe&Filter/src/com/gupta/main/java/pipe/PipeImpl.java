package com.gupta.main.java.pipe;

//PipeImpl.java
import java.util.*;

public class PipeImpl implements Pipe{

    private List buffer = new ArrayList();
    private boolean full = false;
    private Integer numsLines = -1;

    public synchronized boolean put(Object obj){
        boolean bAdded = buffer.add(obj);
        notify();
        return bAdded;
    }

    public synchronized Object get() throws InterruptedException{
        while(buffer.isEmpty()) wait(); //pipe empty - wait
        Object obj = buffer.remove(0);
        return obj;
    }

    @Override
    public synchronized boolean isFull() {
        return this.full;
    }

    @Override
    public synchronized void setFull(boolean full) {
        this.full = full;
    }

    @Override
    public Integer getNumsIns() {
        return this.numsLines;
    }

    @Override
    public void setNumsIns(Integer numsIns) {
        this.numsLines = numsIns;
    }
}

