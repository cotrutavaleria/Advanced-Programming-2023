package compulsory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    public static final int PORT = 8100;
    public boolean running = true;

    public GameServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            Socket socket = null;
            while (running) {
                System.out.println("Waiting for a client...");
                socket = serverSocket.accept();
                StopTheServer stopTheServer = new StopTheServer(running);
                System.out.println("A client has arrived...");
                ExecutorService pool = Executors.newFixedThreadPool(10);
                Thread client1 = new ClientThread(socket, stopTheServer);
                pool.execute(client1);
                pool.shutdown();
                while (!pool.isTerminated()) {
                    if (!stopTheServer.isRunning()) {
                        this.running = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}