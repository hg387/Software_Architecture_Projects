package com.gupta.main.java.filter.impl;

import com.gupta.main.java.Utilities;
import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.pipe.Pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputConsoleReader extends Filter {
    public InputConsoleReader(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() {
        ArrayList<String> userLines = this.linesReader();

        while (userLines.size() == 0){
            System.out.println("Error: can't be empty\n");
            userLines = linesReader();
        }
    }

    private ArrayList<String> linesReader(){
        System.out.println("\nEnter the sentences:\n");
        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            while (((line = br.readLine()) != null) && line.length() != 0){
                lines.add(line);
                this.output_.put(Utilities.punctuationRemover(line));
            }

            this.output_.setFull(true);
            this.output_.setNumsIns(lines.size());
            this.output_.put(null);
            System.out.println("\n--- Input Console Reading Done ---\n");
        }
        catch (IOException e){
            System.out.println(e);
        }

        return lines;
    }
}
