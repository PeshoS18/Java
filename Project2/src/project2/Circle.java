/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author GOLF
 */
public class Circle extends Shape{
    private Point center;
    private float radius;
    private String color;
    
    
    @Override public String Shape(String color) {
        return color;
    }
    @Override public String getColor() {
      return color;  
    }
    @Override public void setColor(String color) {
        this.color=color;
    }
    public Circle(Point center,float radius)
    {
        center = this.center;
        radius = this.radius;
    }
    public float getRadius()
    {
        return radius;
    }
    public void setRadius(float radius)
    {
        this.radius = radius;
    }

    @Override public float getArea()
    {
        return (float) (Math.PI * Math.pow(radius, 2));
    }
    @Override public float getPerimeter()
    {
        return (float) (2*Math.PI * radius);
    }
}
