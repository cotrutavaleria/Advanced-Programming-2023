package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private static final String STOP_SERVER_COMMAND = "stop";
    private static final String EXIT_COMMAND = "exit";
    private final Socket socket;
    private StopTheServer stopTheServer;
    private boolean running;

    public ClientThread(Socket socket, StopTheServer stopTheServer) {
        this.socket = socket;
        this.stopTheServer = stopTheServer;
        this.running = stopTheServer.isRunning();
    }

    public void run() {
        PrintWriter output = null;
        BufferedReader input = null;
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (running) {
                String response = input.readLine();
                System.out.println(response);
                switch (response) {
                    case STOP_SERVER_COMMAND:
                        response = "Server stopped.";
                        output.println(response);
                        output.flush();
                        stopTheServer.setRunning(false);
                        this.running = false;
                        break;
                    case EXIT_COMMAND:
                        response = "The client has stopped.";
                        output.println(response);
                        output.flush();
                        this.running = false;
                        break;
                    default:
                        response = "Server received the request...";
                        output.println(response);
                        output.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
