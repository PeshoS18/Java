/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javawebtest2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 *
 * @author GOLF
 */
public class JavaWebTest2 {

    /**
     * @param args the command line arguments
     */
    static int PORT[] = new int[]{80,25,43};
    static final int TIMEOUT = 2500;
    static final String HOST_NAME = "www.kst.tugab.bg";
    
    public static void main(String[] args){
        InetAddress ip;
        for (int i = 0; i < PORT.length; i++) {
            
        
        try
        {
            ip = InetAddress.getByName(HOST_NAME);
        }catch(UnknownHostException ex)
        {
            System.out.println("Неразпознато име за хост!");
            return;
        }
        Socket socket = new Socket();
        try
        {
            socket.connect(new InetSocketAddress(ip, PORT[i]), TIMEOUT);
            System.out.println("Порт " + PORT[i] + " е отворен.");
        }catch(SocketTimeoutException ste)
        {
        System.out.println("Сървърът не отговаря!");
        }catch(IOException ioe)
        {
        System.out.println("Порт " + PORT[i] + " е затворен.");
        }
    }
        }
}
