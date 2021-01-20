package com.gupta.main.java.filter.impl;

import com.gupta.main.java.Utilities;
import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.pipe.Pipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileReader extends Filter {
    private String fileName = "";

    public InputFileReader(Pipe input_, Pipe output_, String fileName) {
        super(input_, output_);
        this.fileName = fileName;
    }

    @Override
    protected void transform() {
        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(this.fileName));){

            String line = "";
            while ((line = br.readLine()) != null) {
                lines.add(line);
                this.output_.put(Utilities.punctuationRemover(line));
            }

            this.output_.setFull(true);
            this.output_.setNumsIns(lines.size());
            this.output_.put(null);
            System.out.println("\n--- Input File Reading Done ---\n");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
