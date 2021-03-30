package src.main.java;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class State extends ActionHandler{

    public Status status = Status.C;
    public Number first = null;
    public Number second = null;
    public Number value = null;
    public String operator = null;
    public String equation = "";
    public String intermediate = "";

    private final int PORT = 8081;
    private final String SERVER = "127.0.0.1";
    private Socket socket;

    public State(){
        try {
            this.socket = new Socket(SERVER, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToServer(){
        try{
            System.out.println("Writing Equation to the Sever");
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(equation);
            ps.flush();
            System.out.println("Finished Writing Equation to the Server");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "state change"));
    }

    public void setEquation(String equation){
        this.equation = equation;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "display"));
    }

    public void setIntermediate(String intermediate){
        this.intermediate = intermediate;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "display intermediate"));
    }

    public void reset(){
        first = null;
        second = null;
        operator = null;
    }

    public void showDialog(){
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "error dialog"));
    }
}
