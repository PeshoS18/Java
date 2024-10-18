/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chovek;

import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public class Chovek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Изберете длъжност:\n");
        System.out.printf("1.Учител\n");
        System.out.printf("2.Студент\n");
        System.out.printf("3.Ученик\n");
        System.out.printf("4.Изход\n");
        
        System.out.printf("Избери число: ");
        int choice = sc.nextInt();
        Person person = null;
        
        switch (choice)
                {
                    case 1 -> person = new Teacher();
                    case 2 -> person = new Student();
                    case 3 -> person = new Schoolguy();
                    case 4 -> System.exit(0);
                    default -> {
                            System.out.printf("Невалиден избор. Моля, изберете отново.");
                        }
                }
                person.Input1();
                person.Input2();
                person.Output1();
                person.Output2();
    }
}

