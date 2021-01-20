package com.gupta.main.java.filter.impl;

import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.pipe.Pipe;

import java.util.ArrayList;

public class CircularShifter extends Filter {
    public CircularShifter(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() {
        Object o;
        ArrayList<String> lines = new ArrayList<>();

        try {
            Integer count = 0;

            while ((o = this.input_.get()) != null) {
                String line = (String) o;
                count++;
                String tmpLine = line;
                lines.add(tmpLine);
                this.output_.put(tmpLine);
                int NoWords = tmpLine.split(" ").length;

                for (int i= 0;i<(NoWords-1); i++){
                    String firstTo = tmpLine.substring(0,tmpLine.lastIndexOf(" "));
                    String last = tmpLine.substring(tmpLine.lastIndexOf(" ")+1);
                    tmpLine = last + " " + firstTo;
                    lines.add(tmpLine);
                    this.output_.put(tmpLine);
                }
            }

            if (this.input_.isFull() && count.equals(this.input_.getNumsIns())) {
                this.output_.setFull(true);
                this.output_.setNumsIns(lines.size());
                this.output_.put(null);
                System.out.println("\n--- Circular Shift Done ---\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
