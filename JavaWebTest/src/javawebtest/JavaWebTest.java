/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javawebtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public class JavaWebTest {

    /**
     * @param args the command line arguments
     */
    //http://www.kst.tugab.bg
    static String REQUEST = " ";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Въведете сървър: ");
        
        String[] baiIvan = new String[2];
        for (int i = 0; i < baiIvan.length; i++) {
            try
        {
            REQUEST = sc.nextLine();
            URL server = new URL(REQUEST);
            URLConnection conn = server.openConnection();
            String serverInfo = conn.getHeaderField("Server");
            if(serverInfo != null){
                System.out.println(serverInfo);
            } else {
                if(conn.getContentLength() == -1)
                {
                    System.out.println("Липства мрежова свързаност, "
                            + "протоколът не се поддържа или няма такъв хост!");
                } else{
                        System.out.println("Не е зададено име на Web сървъра!");
                        }
            }
        }
        catch(MalformedURLException ex)
                {
                    System.out.println("Невалиден синтаксис на заявката!");
                }
        catch(IOException ex)
        {
            System.out.println("Грешка при комуникация с връзката!");
        }
            baiIvan[i] = REQUEST;
        }
        for (int i = 0; i < baiIvan.length; i++) {
            System.out.println(baiIvan[i]);
        }
    }
}
