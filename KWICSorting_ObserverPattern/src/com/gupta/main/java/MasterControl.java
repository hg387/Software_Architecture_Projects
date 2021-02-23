package com.gupta.main.java;

import com.gupta.main.java.input.Input;
import com.gupta.main.java.input.InputConsoleTasker;
import com.gupta.main.java.input.InputFileTasker;
import com.gupta.main.java.output.Output;
import com.gupta.main.java.output.OutputConsoleTasker;
import com.gupta.main.java.output.OutputFileTasker;

public class MasterControl {
    private static MasterControl masterControl = new MasterControl();
    public  Input input;
    public  Output output;
    public  CircularShift circularShift = new CircularShift();
    public  Alphabetizer alphabetizer = new Alphabetizer();
    public  LineStorage lineStorage = new LineStorage(new InputConsoleTasker());

    private MasterControl(){;}

    public static MasterControl getInstance(){
        return masterControl;
    }

    public void startInteractiveMode(){
        OutputConsoleTasker outputConsoleTasker = new OutputConsoleTasker();

        this.lineStorage.addActionListener(this.alphabetizer);
        this.lineStorage.addActionListener(outputConsoleTasker);

        this.lineStorage.addActionListener(this.circularShift);
        this.circularShift.addActionListener(this.lineStorage);
        this.circularShift.addActionListener(this.alphabetizer);
        this.alphabetizer.addActionListener(this.lineStorage);
        outputConsoleTasker.addActionListener(this.lineStorage);

        System.out.println("\n--- Welcome to Interactive mode ---\n");
        this.lineStorage.inputManager();
    }


    public void startKWC(){
        System.out.println("---- Welcome to KWC ----\n");
        int choice = Utilities.choiceSelection2("enter");

        if (choice == 1){
            input = new InputConsoleTasker();
            input.inputManager();
        }
        else if (choice == 2){
            input = new InputFileTasker();
            input.inputManager();
        }

        circularShift.setup();
        alphabetizer.doSort();

        this.startInteractiveMode();

        if (choice == 1 || choice == 2) {

            choice = Utilities.choiceSelection2("get");
            if (choice == 1) {
                output = new OutputConsoleTasker();
                output.outputManager();
            } else if (choice == 2) {
                output = new OutputFileTasker();
                output.outputManager();
            }
        }

    }
}
