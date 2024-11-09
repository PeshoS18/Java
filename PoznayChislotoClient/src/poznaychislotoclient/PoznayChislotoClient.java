/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poznaychislotoclient;
import java.io.*;
import java.net.*;
/**
 *
 * @author GOLF
 */
public class PoznayChislotoClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 1240;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Сървърът: " + serverResponse);

                if (serverResponse.contains("Ваш ред е")) {
                    System.out.print("Вашето предположение: ");
                    String guess = userInput.readLine();
                    out.println(guess);
                } else if (serverResponse.contains("Познахте!") || serverResponse.contains("Играта приключи")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
