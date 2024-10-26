/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nfaktoriel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public class NFaktoriel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var fact = 1;
        boolean ts = false;
        int n = 0;
        
        while(!ts)
        {
        try
        {
        System.out.println("Въведете брой на факториела: ");
        n = sc.nextInt();
        if(n < 0)
        {
        throw new IllegalArgumentException("Невалиден тип на данните: ");
        }
        else if(n > 30)
        {
            throw new IllegalArgumentException("Невалиден размер на данните: ");
        }
        ts = true;
        }catch(IllegalArgumentException e)
        {
            System.out.println( e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println( e.getMessage());
        }
        }
        do
        {
            fact *= n;
            n--;
        }while(n > 1);
        System.out.printf("Result: %d ",fact);
        }
    }
