package com.gupta.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {

    public static int choiceSelection2(String action){
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
                        System.out.println("Invalid Integer\nPlease re-enter the selection 1 or 2 or 3:\n1) By Console\n2) By File\n");
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

    public static String getInteractiveChoice(){
        String choice = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            choice = br.readLine();

            while (true) {
                try {
                    choice = choice.toLowerCase();
                    while (!choice.equals("a") && !choice.equals("p") && !choice.equals("d") && !choice.equals("q")) {
                        System.out.println("Invalid Option\nPlease re-enter the selection either  a, p, d, or q :\n");
                        choice = br.readLine();
                    }

                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Option\nPlease re-enter the selection either  a, p, d, or q :\n");
                    choice = br.readLine();
                }
            }

        }
        catch (IOException e){
            System.out.println(e);
        }
        return  choice;
    }

    public static String punctuationRemover(String line){
        return line.replaceAll("\\p{Punct}","");
    }
}
