package com.gupta.main.java;

import java.util.ArrayList;

public class CircularShift {
    private ArrayList<String> lines = new ArrayList<>();

    public ArrayList<String> getLines(){
        return this.lines;
    }

    public void setup(){
        LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        lines = lineStorage.getLines();
        ArrayList<String> tmpLines = (ArrayList<String>) lines.clone();
        if (tmpLines.size() != 0){
            for (String line: tmpLines){
                String tmpLine = line;
                int NoWords = tmpLine.split(" ").length;

                for (int i= 0;i<(NoWords-1); i++){
                    String firstTo = tmpLine.substring(0,tmpLine.lastIndexOf(" "));
                    String last = tmpLine.substring(tmpLine.lastIndexOf(" ")+1);
                    tmpLine = last + " " + firstTo;
                    lines.add(tmpLine);
                }
            }
        }

    }
}
