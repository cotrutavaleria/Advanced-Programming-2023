package homework;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class GameClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8100;
    private static final String EXIT_COMMAND = "exit";

    public GameClient() {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            Scanner scanner = new Scanner(System.in);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String request = null;
            System.out.println((String) inputStream.readObject());
            request = scanner.nextLine();
            outputStream.writeObject(request);
            System.out.println((String) inputStream.readObject());
            request = scanner.nextLine();
            outputStream.writeObject(request);
            do {
                System.out.print("Enter a command:");
                request = scanner.nextLine();
                outputStream.writeObject(request);
                List<Integer> result1 = new ArrayList<>(), result2 = new ArrayList<>();
                result1.add(1);
                result2.add(2);
                if (request.contains("submit move")) {
                    List<List<Integer>> list = (List<List<Integer>>) inputStream.readObject();
                    for (List<Integer> line : list) {
//                        if (line == result1) {
//                            System.out.println("You won!");
//                        } else if (line == result2) {
//                            System.out.println("You lost!");
//                        }
                        System.out.println(line);
                    }
                } else {
                    String response = (String) inputStream.readObject();
                    System.out.println(response);
                }
            }
            while (!request.equals(EXIT_COMMAND));
            scanner.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
