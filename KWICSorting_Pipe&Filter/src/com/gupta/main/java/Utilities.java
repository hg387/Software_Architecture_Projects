package com.gupta.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utilities {

    public static String getInputFile(){
        System.out.println("\nEnter the input file name with the extension:\n");
        String fileName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName = br.readLine();
            while (!Files.exists(Paths.get(fileName)) || fileName.equals("")){
                if (fileName.equals("")) System.out.println("\nCan't be Empty\nPlease re-enter the input file name with extension\n");
                else System.out.println("\nFile Not Found\nPlease re-enter the input file name with extension\n");
                fileName = br.readLine();
            };

        }
        catch (IOException e){
            System.out.println(e);
        }

        return fileName;
    }

    public static String getOutputFile(){
        System.out.println("\nEnter the output file name with the extension:\n");
        String fileName = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            fileName = br.readLine();

            while (fileName == null || fileName.equals("")){
                System.out.println("\nCan't be empty\nPlease re-enter the output file name with extension:\n");
                fileName = br.readLine();
            }

        }
        catch (IOException e){
            System.out.println(e);
        }
        return fileName;
    }

    public static int choiceSelection(String action){
        System.out.println("\nHow would you like to " + action +" the sentences:\n");
        System.out.println("\n1) By Console\n2) By File\n");
        String choice = "";
        int choiceInt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            choice = br.readLine();
            while (true) {
                try {
                    choiceInt = Integer.parseInt(choice);

                    while (choiceInt != 1 && choiceInt != 2) {
                        System.out.println("Invalid Integer\nPlease re-enter the selection 1 or 2:\n1) By Console\n2) By File\n");
                        choice = br.readLine();
                        choiceInt = Integer.parseInt(choice);
                    }

                    break;
                } catch (Exception e) {
                    System.out.println("Not an Integer\nPlease re-enter the selection 1 or 2:\n1) By Console\n2) By File\n");
                    choice = br.readLine();
                }
            }

        }
        catch (IOException e){
            System.out.println(e);
        }

        return choiceInt;
    }

    public static int locationSelection(){
        System.out.println("Please Enter the location <1,2,3>:\n");
        String choice = "";
        int choiceInt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            choice = br.readLine();
            while (true) {
                try {
                    choiceInt = Integer.parseInt(choice);

                    while (choiceInt != 1 && choiceInt != 2 && choiceInt != 3) {
                        System.out.println("Invalid Integer\nPlease re-enter the location 1, 2 or 3:\n");
                        choice = br.readLine();
                        choiceInt = Integer.parseInt(choice);
                    }

                    break;
                } catch (Exception e) {
                    System.out.println("Not an Integer\nPlease re-enter the location 1, 2 or 3\n");
                    choice = br.readLine();
                }
            }

        }
        catch (IOException e){
            System.out.println(e);
        }

        return choiceInt;
    }

    public static String punctuationRemover(String line){
        return line.replaceAll("\\p{Punct}","");
    }
}

