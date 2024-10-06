/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chovek;

/**
 *
 * @author GOLF
 */
public class Teacher extends Person {
    private String title;
    private int NumOfRoom;
    
    @Override
    public void Input2()
    {
        System.out.printf("Въведете титла: ");
        title = sc.nextLine();
        System.out.printf("Въведете номер на кабинет: ");
        NumOfRoom = sc.nextInt();
    }
    
    public Teacher()
    {
        this.title = " ";
        this.NumOfRoom = 0;
    }
    public Teacher(String title,int NumOfRoom)
    {
        title = this.title;
        NumOfRoom = this.NumOfRoom;
    }
    
    public int SredenUspeh()
    {
        int broiNaOcenki = 0;
        int srednoAritmetichno = 0;
        System.out.printf("Въведете брой на оценките: ");
        broiNaOcenki = sc.nextInt();
        for (int i = 0; i <= broiNaOcenki; i++) {
            srednoAritmetichno += i;
        }
        return srednoAritmetichno / broiNaOcenki;
    }
    
    @Override
    public void Output2()
    {
        System.out.printf("Титла: %s ",title); 
        System.out.printf("Номер на кабинет: %d ",NumOfRoom);
        System.out.println("Средно аритметично: %d "+SredenUspeh());
    }
    
}
