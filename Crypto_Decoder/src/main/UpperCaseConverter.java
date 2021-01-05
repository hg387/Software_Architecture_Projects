package main;

import java.io.*;

public class UpperCaseConverter extends Filter {
    private String fileName;

    public UpperCaseConverter(Pipe input_, Pipe output_, String fileName) {
        super(input_, output_);
        this.fileName = fileName;
    }

    @Override
    protected void transform(){
        try {
            Object o;
            while ((o = input_.get()) != null) {
                String convertedLine = ((String) o).toUpperCase();
                System.out.println(convertedLine);


                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), true))) {
                    bw.write(convertedLine);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
