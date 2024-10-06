/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chovek;

import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public abstract class Person {
    Scanner sc = new Scanner(System.in);
    
    private String name;
    private int age;
    private int phoneNum;
    
    public abstract void Input2();
    public abstract void Output2();
    
    public void Input1()
    {
        System.out.printf("Въведете име: ");
        name = sc.nextLine();
        System.out.printf("Въведете години: ");
        age = sc.nextInt();
        System.out.printf("Въведете телефонен новер: ");
        phoneNum = sc.nextInt();
    }
    
    public Person()
    {
        this.name = " ";
        this.age = 0;
        this.phoneNum = 0;
    }
    public Person(String name,int age, int phoneNum)
    {
        name = this.name;
        age = this.age;
        phoneNum = this.phoneNum;
    }
    
    public void Output1()
    {
        System.out.printf("Име: %s ",name); 
        System.out.printf("Години: %d ",age); 
        System.out.printf("Телефонен номер: %d ",phoneNum); 
    }

}
