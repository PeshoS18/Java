/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chovek;

/**
 *
 * @author GOLF
 */
public class Schoolguy extends Person{
    private int numInClass;
    private String schoolName;
    
    @Override
    public void Input2() {
        System.out.printf("Въведете номер в клас: ");
        numInClass = sc.nextInt();
        System.out.printf("Въведете име на училището: ");
        schoolName = sc.nextLine();
    }

    public Schoolguy()
    {
        this.numInClass = 0;
        this.schoolName = " ";
    }
    public Schoolguy(int numInClass,String schoolName)
    {
        numInClass = this.numInClass;
        schoolName = this.schoolName;
    }
    
    @Override
    public void Output2() {
        System.out.printf("Номер в клас: %d ",numInClass); 
        System.out.printf("Име на училището: %s ",schoolName);
    }
    
}
