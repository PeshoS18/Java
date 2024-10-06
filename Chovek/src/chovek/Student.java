/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chovek;

/**
 *
 * @author GOLF
 */
public class Student extends Person {

    private String specialty;
    private int fakNum;
    
    
    @Override
    public void Input2() {
        System.out.printf("Въведете специалност: ");
        specialty = sc.nextLine();
        System.out.printf("Въведете факултетен номер: ");
        fakNum = sc.nextInt();
    }
    
    public Student()
    {
        this.specialty = " ";
        this.fakNum = 0;
    }
    public Student(String specialty,int fakNum)
    {
        specialty = this.specialty;
        fakNum = this.fakNum;
    }

    public String Programa()
    {
        String dnevnaPrograma = "\n8:00 - 10:00 Физическо възпитание и спорт\n"
                                + "10:00 - 12:00 Операционни системи\n"
                                + "12:00 - 14:00 Програмиране в интернет среда";
        return dnevnaPrograma;
    }
    
    @Override
    public void Output2() {
        System.out.printf("Специалност: %s ",specialty); 
        System.out.printf("Факултетен номер: %d ",fakNum);
        System.out.println("Дневна програма: %s "+Programa());
    }
    
}
