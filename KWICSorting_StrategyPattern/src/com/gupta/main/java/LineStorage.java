package com.gupta.main.java;

import java.util.ArrayList;

public class LineStorage {
    private ArrayList<String> lines = new ArrayList<>();

    public ArrayList<String> getLines(){
        return lines;
    }

    public void addLines(ArrayList<String> lines){
        ArrayList<String> newLines = new ArrayList<>();
        if (lines.size() != 0) {
            lines.forEach(line -> newLines.add(Utilities.punctuationRemover(line)));
        }

        this.lines = newLines;
    }
}
