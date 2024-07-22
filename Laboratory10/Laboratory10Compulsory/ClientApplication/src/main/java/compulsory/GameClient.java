package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8100;
    private static final String EXIT_COMMAND = "exit";
    private String request, response;

    public GameClient() {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            String request = null;
            do{
                System.out.print("Enter a command:");
                request = scanner.nextLine();
                System.out.println(request);
                output.println(request);
                output.flush();
            }while (!request.equals(EXIT_COMMAND));
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
