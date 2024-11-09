/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poznaychislotoserver;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.*;

/**
 *
 * @author GOLF
 */
public class PoznayChislotoServer {
    private static final int PORT = 1240;
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int TIMEOUT = 15000;

    private static ExecutorService clientPool = Executors.newFixedThreadPool(10);
    private static List<ClientHandler> clients = new ArrayList<>();
    private static volatile boolean gameWon = false;
    private static int secretNumber;
    private static int currentPlayer = 0;

    public static void main(String[] args) {
        System.out.println("Сървърът стартира...");
        secretNumber = new Random().nextInt(MAX - MIN + 1) + MIN;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients.size());
                clients.add(clientHandler);
                clientPool.execute(clientHandler);
                System.out.println("Нов клиент се свърза.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private int clientId;

        public ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                out.println("Добре дошли в играта! Вашият номер е: " + clientId);

                while (!gameWon) {
                    if (clientId == currentPlayer) {
                        out.println("Ваш ред е! Въведете число: ");

                        socket.setSoTimeout(TIMEOUT);
                        try {
                            String guessStr = in.readLine();
                            int guess = Integer.parseInt(guessStr);

                            if (guess == secretNumber) {
                                out.println("Познахте! Победител сте!");
                                broadcast("Играч " + clientId + " спечели!");
                                gameWon = true;
                                break;
                            } else if (guess < secretNumber) {
                                out.println("Числото е по-голямо!");
                            } else {
                                out.println("Числото е по-малко!");
                            }

                            // Преминаване към следващия играч
                            currentPlayer = (currentPlayer + 1) % clients.size();
                        } catch (SocketTimeoutException e) {
                            out.println("Времето ви изтече! Пропускате ред.");
                            currentPlayer = (currentPlayer + 1) % clients.size();
                        } catch (NumberFormatException e) {
                            out.println("Невалидно число. Опитайте отново.");
                        }
                    } else {
                        out.println("Изчакайте своя ред...");
                        Thread.sleep(1000);
                    }
                }

                if (gameWon) {
                    out.println("Играта приключи! Числото беше: " + secretNumber);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void broadcast(String message) {
            for (ClientHandler client : clients) {
                try {
                    PrintWriter out = new PrintWriter(client.socket.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
