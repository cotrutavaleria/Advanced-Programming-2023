package homework;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class ClientThread implements Runnable {
    private static final String STOP_SERVER_COMMAND = "stop";
    private static final String EXIT_COMMAND = "exit";
    private static final String CREATE_GAME = "create game";
    private static final String JOIN_GAME = "join game";
    private static final String SUBMIT_MOVE = "submit move";
    private final Socket socket;
    private boolean running;
    private GameServer server;
    private AtomicBoolean isRunning;

    public ClientThread(Socket socket, AtomicBoolean isRunning, GameServer server) {
        this.socket = socket;
        this.isRunning = isRunning;
        this.running = true;
        this.server = server;
    }

    public void run() {
        try {
            Player player = new Player();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            setPlayer(outputStream, inputStream, player);

            while (running) {
                String response = (String) inputStream.readObject();
                System.out.println(response);
                if (response.contains(SUBMIT_MOVE)) {
                    if (this.server.getGame().getPlayer1() != null && this.server.getGame().getPlayer2() != null) {
                        String[] splitCommand = response.split(" ");
                        System.out.println(Integer.parseInt(splitCommand[2]));
                        this.server.getGame().setRow(Integer.parseInt(splitCommand[2]));
                        System.out.println(Integer.parseInt(splitCommand[3]));
                        this.server.getGame().setColumn(Integer.parseInt(splitCommand[3]));
                        if(this.server.getGame().rules().equals("")) {
                            System.out.println("hhhh");
                            outputStream.writeObject(this.server.getGame().getMatrixBoard().getMatrixString());
                        }else if(this.server.getGame().rules().contains(player.getName())){
                            System.out.println("ooooo");
                            List<List<Integer>> winner = new ArrayList<>();
                            List<Integer> result = new ArrayList<>();
                            result.add(1);
                            winner.add(result);
                            outputStream.writeObject(winner);
                        }else{
                            List<List<Integer>> winner = new ArrayList<>();
                            List<Integer> result = new ArrayList<>();
                            result.add(2);
                            winner.add(result);
                            outputStream.writeObject(winner);
                        }
                    }
                } else {
                    switch (response) {
                        case STOP_SERVER_COMMAND -> {
                            response = "Server stopped.";
                            outputStream.writeObject(response);
                            isRunning.set(false);
                            running = false;
                            outputStream.close();
                            socket.close();
                        }
                        case EXIT_COMMAND -> {
                            response = "The client has stopped.";
                            outputStream.writeObject(response);
                            this.running = false;
                        }
                        case CREATE_GAME -> {
                            System.out.println(this.server.getGame());
                            this.server.getGame().setPlayer1(player);
                            System.out.println(this.server.getGame());
                            response = "You created a game. Please make a move";
                            outputStream.writeObject(response);
                        }
                        case JOIN_GAME -> {
                            System.out.println(this.server.getGame());
                            this.server.getGame().setPlayer2(player);
                            System.out.println(this.server.getGame());
                            response = "You joined the game. Wait for the first player to make a move.";
                            outputStream.writeObject(response);
                            Thread.sleep(5000);
                        }
                        default -> {
                            outputStream.writeObject("No such command");
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setPlayer(ObjectOutputStream output, ObjectInputStream input, Player player) throws IOException, ClassNotFoundException {
        output.writeObject("Enter your name.");
        player.setName((String) input.readObject());
        System.out.println(player.getName());
        output.writeObject("Enter your playing number.");
        player.setPlayerNumber(Integer.parseInt((String) input.readObject()));
        System.out.println(player.getPlayerNumber());
        RegisterPlayer registerPlayer = new RegisterPlayer(player);
        registerPlayer.register();
    }
}
