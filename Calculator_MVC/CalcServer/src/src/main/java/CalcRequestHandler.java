package src.main.java;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class CalcRequestHandler extends Thread {
    private ArrayList<String> Equations = new ArrayList<>();
    private Socket socket;
    public CalcRequestHandler(Socket socket) throws IOException {this.socket = socket;}
    private BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Output.txt"), true));

    @Override
    public void run(){
        try {
            BufferedReader bs = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Connected to " + socket.getInetAddress().getHostName() + "\n");

            String equation;
            while ((equation = bs.readLine()) != null){
                Equations.add(equation);
                System.out.println("\nAdded Equation: "+ equation);
                String prettyPrintedEquation = Main.prettyPrintEquation(equation);
                System.out.println(prettyPrintedEquation);
                System.out.println("Total Number of Equations :" + Equations.size() + "\n");

                bw.write("\nAdded Equation: "+ equation + "\n");
                bw.newLine();
                bw.write(prettyPrintedEquation);
                bw.newLine();
                bw.write("Total Number of Equations :" + Equations.size() + "\n");
                bw.newLine();
                bw.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
