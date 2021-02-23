package com.gupta.main.java;

import com.gupta.main.java.Event.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CircularShift extends ActionHandler implements ActionListener {
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
                    //lines.add(tmpLine);
                    lineStorage.addLine(tmpLine);
                }
            }
        }

    }

    private void transformLastLine(){
        LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        String line = lineStorage.getLastLine();
        String tmpLine = line;
        int NoWords = tmpLine.split(" ").length;

        for (int i= 0;i<(NoWords-1); i++){
            String firstTo = tmpLine.substring(0,tmpLine.lastIndexOf(" "));
            String last = tmpLine.substring(tmpLine.lastIndexOf(" ")+1);
            tmpLine = last + " " + firstTo;
            //lines.add(tmpLine);
            lineStorage.addLine(tmpLine);
        }
    }

    public void removeShiftedLines(String line){
        LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        String tmpLine = line;
        int NoWords = tmpLine.split(" ").length;

        for (int i= 0;i<(NoWords-1); i++){
            String firstTo = tmpLine.substring(0,tmpLine.lastIndexOf(" "));
            String last = tmpLine.substring(tmpLine.lastIndexOf(" ")+1);
            tmpLine = last + " " + firstTo;
            lineStorage.removeLine(tmpLine);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Circular Shifter Add")){
            this.transformLastLine();
            processEvent(new Event().CircularShifterAddedLine());
            processEvent(new Event().InteractiveTasker());
        }

    }
}
