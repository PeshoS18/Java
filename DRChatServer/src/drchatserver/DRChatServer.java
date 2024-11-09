/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drchatserver;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author GOLF
 */
public class DRChatServer {
    private static final int PORT = 8080; // Портът, на който сървърът ще слуша за връзки
    private static Map<String, ClientHandler> clients = new HashMap<>(); // Списък с активни клиенти и техните потоци за изпращане на съобщения
    private static Map<String, Color> clientColors = new HashMap<>();
    private static JFrame serverFrame;
    private static JTextArea serverLog;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                setupGUI();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            serverLog.append("Сървърът е стартиран на порт " + PORT + "\n");
            // Основен цикъл за приемане на нови връзки
            while (true) {
                Socket socket = serverSocket.accept(); // Приема връзка от нов клиент
                ClientHandler clientHandler = new ClientHandler(socket); // Създава и стартира нова нишка за този клиент
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            serverLog.append("Грешка при стартиране на сървъра.\n");
        }
    }
    private static void setupGUI() {
        serverFrame = new JFrame("Chat Server");
        serverLog = new JTextArea(20, 50);
        serverLog.setEditable(false);
        serverFrame.add(new JScrollPane(serverLog));
        serverFrame.pack();
        serverFrame.setVisible(true);
    }

    public static synchronized void broadcast(String message) {
        for (ClientHandler client : clients.values()) {
            client.sendMessage(message);
        }
        serverLog.append(message + "\n");
    }

    public static synchronized void addClient(String username, ClientHandler client, Color color) {
        clients.put(username, client);
        clientColors.put(username, color);
        broadcast(username + " се присъедини.");
    }

    public static synchronized void removeClient(String username) {
        clients.remove(username);
        clientColors.remove(username);
        broadcast(username + " напусна.");
    }

    public static String getUsers() {
        return String.join(", ", clients.keySet());
    }

    public static Color assignColor() {
        return new Color((int)(Math.random() * 0x1000000));
    }
    
    // Нишка за обслужване на всеки клиент
    public static class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;
    private Color color;

    public ClientHandler(Socket socket) {
        this.socket = socket; // Запазва клиентския сокет
    }

    @Override
    public void run() {
        try {
            // Създаване на потоци за вход и изход към клиента
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            username = in.readLine();
            color = DRChatServer.assignColor();
            DRChatServer.addClient(username, this, color);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/")) {
                    handleCommand(message);
                } else {
                    DRChatServer.broadcast(formatMessage(username, message));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DRChatServer.removeClient(username);
        }
    }

    private void handleCommand(String command) {
        if (command.startsWith("/users")) {
            sendMessage("Активни потребители: " + DRChatServer.getUsers());
        } else if (command.startsWith("/message ")) {
            String[] parts = command.split(" ", 3);
            String recipient = parts[1];
            String message = parts[2];
            if (DRChatServer.clients.containsKey(recipient)) {
                DRChatServer.clients.get(recipient).sendMessage("[Лично от " + username + "] " + message);
            } else {
                sendMessage("Потребителят не е активен.");
            }
        } else if (command.startsWith("/help")) {
            sendMessage("Поддържани команди: /users, /message <потребител> <съобщение>, /help");
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    private String formatMessage(String user, String message) {
        return "<span style='color:" + colorToHex(color) + "'>" + user + ":</span> " + message;
    }

    private String colorToHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
}
