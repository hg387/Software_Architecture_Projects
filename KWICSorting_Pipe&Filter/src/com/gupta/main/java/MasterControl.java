package com.gupta.main.java;

import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.filter.impl.*;
import com.gupta.main.java.pipe.Pipe;
import com.gupta.main.java.pipe.PipeImpl;
public class MasterControl {

    public  void run(){
        System.out.println("\n---- Welcome to KWC ----\n");
        String inputFile = "", outputFile = "";
        Integer location = -1;

        //location value
        location = Utilities.locationSelection();

        outputFile = Utilities.getOutputFile();

        int choice = Utilities.choiceSelection("enter");

        Filter inputFilter = null;
        Filter upperCaseFilter = null;
        Filter circularShifter = null;
        Filter alphabetizer = null;
        Filter outputFilter = null;

        Pipe firstPipe = new PipeImpl();

        if(choice == 1){
            inputFilter = new InputConsoleReader(null, firstPipe);
        }
        else{
            inputFile = Utilities.getInputFile();
            inputFilter = new InputFileReader(null, firstPipe, inputFile);
        }

        //inputFilter.start();
        Pipe secondPipe = new PipeImpl();
        Pipe thirdPipe = new PipeImpl();
        Pipe fourthPipe = new PipeImpl();

        if (location.equals(1)){

            upperCaseFilter = new UpperCaseConverter(firstPipe,secondPipe);
            circularShifter = new CircularShifter(secondPipe, thirdPipe);
            alphabetizer = new Alphabetizer(thirdPipe, fourthPipe);
            outputFilter = new OutputFileWriter(fourthPipe, null, outputFile);

            inputFilter.start();
            upperCaseFilter.start();
            circularShifter.start();
            alphabetizer.start();
            outputFilter.start();
        }
        else if (location.equals(2)){

            circularShifter = new CircularShifter(firstPipe,secondPipe);
            upperCaseFilter = new UpperCaseConverter(secondPipe,thirdPipe);
            alphabetizer = new Alphabetizer(thirdPipe, fourthPipe);
            outputFilter = new OutputFileWriter(fourthPipe, null, outputFile);

            inputFilter.start();
            circularShifter.start();
            upperCaseFilter.start();
            alphabetizer.start();
            outputFilter.start();
        }
        else {

            circularShifter = new CircularShifter(firstPipe,secondPipe);
            alphabetizer = new Alphabetizer(secondPipe,thirdPipe);
            upperCaseFilter = new UpperCaseConverter(thirdPipe,fourthPipe);
            outputFilter = new OutputFileWriter(fourthPipe, null, outputFile);

            inputFilter.start();
            circularShifter.start();
            alphabetizer.start();
            upperCaseFilter.start();
            outputFilter.start();
        }

        inputFilter.stop();
        circularShifter.stop();
        alphabetizer.stop();
        upperCaseFilter.stop();
        outputFilter.stop();
    }
}
