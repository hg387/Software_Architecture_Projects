package com.gupta.main.java.output;

import com.gupta.main.java.Alphabetizer;
import com.gupta.main.java.MasterControl;

import java.util.ArrayList;

public class OutputConsoleTasker implements Output{

    public void outputManager(){
        Alphabetizer alphabetizer = MasterControl.getInstance().alphabetizer;
        ArrayList<String> lines = alphabetizer.getLines();
        System.out.println("Here is the Output:\n");
        lines.forEach(System.out::println);
        System.out.println("--- Thanks for using ----");
    }
}
