package com.gupta.main.java;

import java.util.ArrayList;

public class Alphabetizer {
    private ArrayList<String> lines = new ArrayList<>();

    public ArrayList<String> getLines(){
        return lines;
    }

    public void doSort(){
        CircularShift circularShift  = MasterControl.getInstance().circularShift;
        lines = circularShift.getLines();
        lines.sort(String.CASE_INSENSITIVE_ORDER);
    }
}
