package com.gupta.main.java.filter.impl;

import com.gupta.main.java.filter.Filter;
import com.gupta.main.java.pipe.Pipe;

import java.util.ArrayList;


public class Alphabetizer extends Filter {
    public Alphabetizer(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() {
        ArrayList<String> lines = new ArrayList<>();
        Object o;
        Integer count = 0;
        try {
            while ((o = this.input_.get()) != null) {

                count++;
                String line = (String) o;
                lines.add(line);

            }

            if (this.input_.isFull() && count.equals(this.input_.getNumsIns())) {
                lines.sort(String.CASE_INSENSITIVE_ORDER);
                lines.forEach(l -> this.output_.put(l));
                this.output_.setFull(true);
                this.output_.setNumsIns(lines.size());
                this.output_.put(null);
                System.out.println("\n--- Alphabetizer Done ---\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
