package com.gupta.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
    public static int choiceSelection(String action){
        System.out.println("How would you like to " + action +" the sentences:\n");
        System.out.println("1) By Console\n2) By File\n");
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

    public static String punctuationRemover(String line){
        return line.replaceAll("\\p{Punct}","");
    }
}
