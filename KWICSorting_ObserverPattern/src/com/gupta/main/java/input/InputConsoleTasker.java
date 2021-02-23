package com.gupta.main.java.input;

import com.gupta.main.java.ActionHandler;
import com.gupta.main.java.LineStorage;
import com.gupta.main.java.MasterControl;

import javax.sound.sampled.Line;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputConsoleTasker implements Input {

    public String readALine(){
        String line = "";
        System.out.println("> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            while (((line = br.readLine()).equals(""))){
                System.out.println("\nEntered empty sentence\nPlease enter again:\n> ");
            }
        }
        catch (IOException e){
            System.out.println(e);
        }

        return line;
    }
    private ArrayList<String> linesReader(){
        System.out.println("\nEnter the sentences:\n");
        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            while (((line = br.readLine()) != null) && line.length() != 0){
                lines.add(line);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }

        return lines;
    }

    public void inputManager(){
        LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        ArrayList<String> userLines = this.linesReader();
        
        while (userLines.size() == 0){
            System.out.println("Error: can't be empty\n");
            userLines = linesReader();
        }

        lineStorage.addLines(userLines);
    }

}
