package com.gupta.main.java.output;

import com.gupta.main.java.Alphabetizer;
import com.gupta.main.java.LineStorage;
import com.gupta.main.java.MasterControl;

import java.io.*;
import java.util.ArrayList;

public class OutputFileTasker implements Output{

    public void outputManager(){
    	LineStorage lineStorage = MasterControl.getInstance().lineStorage;
        ArrayList<String> lines = lineStorage.getLines();
        System.out.println("\nEnter the file name with the extension:\n");
        String fileName = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            fileName = br.readLine();

            while (fileName == null || fileName.equals("")){
                System.out.println("\nCan't be empty\nPlease re-enter the file name with extension:\n");
                fileName = br.readLine();
            }

        }
        catch (IOException e){
            System.out.println(e);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))){
            lines.forEach(line -> {
                try {
                    bw.write(line);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        catch (IOException e){
            System.out.println(e);
        }

        System.out.println("--- Thanks for using ----");
    }
}
