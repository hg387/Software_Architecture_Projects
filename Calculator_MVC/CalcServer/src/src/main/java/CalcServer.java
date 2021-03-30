package src.main.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer extends Thread{
    private ServerSocket serverSocket;
    private int port;
    private Boolean isRunning = false;

    public CalcServer(int port){
        this.port = port;
    }

    public void stopServer(){
        this.isRunning = false;
        this.interrupt();
    }

    public void startServer(){
        try {
            serverSocket = new ServerSocket(port);
            this.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        this.isRunning = true;
        System.out.println("--- Connection open on port: " + this.port + " ---\n");
        while (isRunning){

            try {
                Socket socket = serverSocket.accept();
                CalcRequestHandler requestHandler = new CalcRequestHandler(socket);
                requestHandler.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
