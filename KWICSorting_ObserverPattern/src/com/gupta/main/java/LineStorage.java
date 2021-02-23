package com.gupta.main.java;

import com.gupta.main.java.Event.Event;
import com.gupta.main.java.input.InputConsoleTasker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LineStorage extends ActionHandler implements ActionListener {
    private ArrayList<String> lines = new ArrayList<>();
    private InputConsoleTasker inputConsoleTasker;

    public LineStorage(){
        ;
    }

    public LineStorage(InputConsoleTasker inputConsoleTasker){
        this.inputConsoleTasker = inputConsoleTasker;
    }

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

    public void addLine(String line){
        this.lines.add(Utilities.punctuationRemover(line));
    }

    public String getLastLine(){
        return this.lines.get(this.lines.size() - 1);
    }

    public boolean removeLine(String line){
        return this.lines.remove(Utilities.punctuationRemover(line));
    }

    public void replaceLines(ArrayList<String> lines){
        this.lines = lines;

    }

    public void inputManager() {
        System.out.println("\nAdd, Delete, Print, Quit:");

        String choice = Utilities.getInteractiveChoice();

        if (choice.equals("p")){
            this.processEvent(new Event().Print());
        }
        else if (choice.equals("a")){
            String line = this.inputConsoleTasker.readALine();
            this.addLine(line);
            this.processEvent(new Event().CircularShifterAdd());
        }
        else if (choice.equals("d")){
            String line = this.inputConsoleTasker.readALine();
            boolean isRemovable = this.removeLine(line);

            while(!isRemovable){
                System.out.println("\n--- Error Line Not Found ---\nPlease enter again:\n");
                line = this.inputConsoleTasker.readALine();
                isRemovable = this.removeLine(line);
            }

            MasterControl.getInstance().circularShift.removeShiftedLines(line);
            processEvent(new Event().CircularShifterAddedLine());
            this.inputManager();
        }
        else if (choice.equals("q")){
            System.out.println("\n--- Exiting Interactive mode ---\n");
            //System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Interactive Tasker"))
            this.inputManager();
        else if (e.getActionCommand().equals("Call Output"))
            processEvent(new Event().OutputNow());
    }
}
