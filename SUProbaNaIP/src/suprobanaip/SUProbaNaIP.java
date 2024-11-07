/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suprobanaip;

/**
 *
 * @author GOLF
 */

import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class SUProbaNaIP {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Въведете домейн име: ");
        String domain = sc.nextLine();
        sc.close();
        
        try
        {
            InetAddress address = InetAddress.getByName(domain);
            System.out.println("IP адреса на "+domain+" е: " + address.getHostAddress());
        }catch(UnknownHostException e)
                {
                    System.out.println("Неуспешно отркиване на хост:"+ e.getMessage());   
                }
    }
    
}
