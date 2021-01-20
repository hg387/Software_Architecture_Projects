package com.gupta.main.java.filter.impl;

import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.pipe.Pipe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class OutputFileWriter extends Filter {
    private String fileName = "";

    public OutputFileWriter(Pipe input_, Pipe output_, String fileName) {
        super(input_, output_);
        this.fileName = fileName;
    }

    @Override
    protected void transform() {
        Object o;
        Integer count = 0;

        try {
            while ((o = this.input_.get()) != null) {

                String line = (String) o;
                count++;
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.fileName), true));
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            if (count.equals(this.input_.getNumsIns()) && this.input_.isFull()) System.out.println("\n--- Output File Writing Done ---\n");;

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
