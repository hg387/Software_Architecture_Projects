package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Generator extends Filter {
    public Generator(Pipe input_, Pipe output_) {
        super(input_, output_);
    }

    @Override
    protected void transform() {
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

        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br1 = new BufferedReader(new FileReader(fileName));){

            String line = "";
            while ((line = br1.readLine()) != null) {
                lines.add(line);
                output_.put(line);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
