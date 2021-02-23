package com.gupta.main.java.input;

import com.gupta.main.java.LineStorage;
import com.gupta.main.java.MasterControl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputFileTasker implements Input {

    private ArrayList<String> linesReader(String fileName){
        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName));){

            String line = "";
            while ((line = br.readLine()) != null) {
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
        System.out.println("\nEnter the file name with the extension:\n");
        String fileName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName = br.readLine();
            while (!Files.exists(Paths.get(fileName)) || fileName.equals("")){
                if (fileName.equals("")) System.out.println("\nCan't be Empty\nPlease re-enter the file name with extension\n");
                else System.out.println("\nFile Not Found\nPlease re-enter the file name with extension\n");
                fileName = br.readLine();
            };

        }
        catch (IOException e){
            System.out.println(e);
        }

        lineStorage.addLines(linesReader(fileName));
    }
}
