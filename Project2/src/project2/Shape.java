/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.Scanner;

/**
 *
 * @author GOLF
 */
public abstract class Shape {
    Scanner sc = new Scanner(System.in);
    private String color;
    
    
    abstract public String Shape(String color);
    public String getColor()
    {
       return color; 
    }
    public void setColor(String color)
    {
        color=this.color;
    }
    abstract public float getArea();
    abstract public float getPerimeter();
    
}
