package com.gupta.main.java;

import com.gupta.main.java.Event.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Alphabetizer extends ActionHandler implements ActionListener {
    private ArrayList<String> lines = new ArrayList<>();

    public ArrayList<String> getLines(){
        return lines;
    }

    public void doSort(){
        LineStorage lineStorage  = MasterControl.getInstance().lineStorage;
        lines = lineStorage.getLines();
        lines.sort(String.CASE_INSENSITIVE_ORDER);
        lineStorage.replaceLines(lines);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Print")){
            this.doSort();
            this.processEvent(new Event().CallOutput());
        }
        else if (e.getActionCommand().equals("CircularShifter Added Line")){
            this.doSort();
        }
    }
}
