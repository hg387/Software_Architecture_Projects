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
    public  LineStorage lineStorage = new LineStorage();

    private MasterControl(){;}

    public static MasterControl getInstance(){
        return masterControl;
    }

    public void startKWC(){
        System.out.println("---- Welcome to KWC ----\n");
        int choice = Utilities.choiceSelection("enter");

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

        choice = Utilities.choiceSelection("get");
        if (choice == 1){
            output = new OutputConsoleTasker();
            output.outputManager();
        }
        else if (choice == 2){
            output = new OutputFileTasker();
            output.outputManager();
        }

    }
}
