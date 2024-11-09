/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drchatclient;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 *
 * @author GOLF
 */
public class DRChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private JFrame frame;
    private JTextPane messageArea;
    private JTextField messageInput;

    public static void main(String[] args) {
        new DRChatClient().start();
    }

    public void start() {
        setupGUI();
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String username = JOptionPane.showInputDialog("Въведете потребителско име:");
            out.println(username);

            new Thread(new MessageListener()).start();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Не може да се свърже със сървъра.");
            e.printStackTrace();
        }
    }

    private void setupGUI() {
        frame = new JFrame("Chat Client");
        messageArea = new JTextPane();
        messageArea.setEditable(false);
        messageInput = new JTextField(40);

        messageInput.addActionListener(e -> sendMessage());

        JButton sendButton = new JButton("Изпрати");
        sendButton.addActionListener(e -> sendMessage());

        frame.add(new JScrollPane(messageArea), "Center");
        frame.add(messageInput, "South");
        frame.add(sendButton, "East");
        frame.pack();
        frame.setVisible(true);
    }

    private void sendMessage() {
        String message = messageInput.getText();
        out.println(message);
        messageInput.setText("");
    }

    private class MessageListener implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    messageArea.setText(messageArea.getText() + "\n" + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
