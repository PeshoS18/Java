/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suprobanaip2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public class SUProbaNaIP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Въведете: ");
        String user = sc.nextLine();
        sc.close();
        
        try
        {
            InetAddress address = InetAddress.getByName(user);
            System.out.println("Името на хоста е: " + address.getHostName());
            System.out.println("IP адреса е: " + user);
        }catch(UnknownHostException e)
                {
                    System.out.println("Неуспешно отркиване на хост:"+ e.getMessage());   
                }
    }
    
}
