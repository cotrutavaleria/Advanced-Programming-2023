package homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameServer {
    private static List<ClientThread> clientThreadList = new ArrayList<>();
    private Game game;
    private static AtomicBoolean isRunning = new AtomicBoolean(true); // Shared flag to control server shutdown

    public GameServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            ServerSocket serverSocket = new ServerSocket(8100); // Port number
            System.out.println("Waiting for a client...");
            while (isRunning.get()) {
                Socket socket = serverSocket.accept();
                this.game = new Game(socket);
                System.out.println("Client connected!");
                ClientThread client = new ClientThread(socket, isRunning, this);
                clientThreadList.add(client);
                System.out.println("You are client number " + clientThreadList.size());
                executorService.execute(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public int getClientThreadListSize() {
        return this.clientThreadList.size();
    }

    public List<ClientThread> getClientThreadList() {
        return clientThreadList;
    }

    public Game getGame() {
        return game;
    }
}
