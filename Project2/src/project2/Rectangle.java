/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author GOLF
 */
public class Rectangle extends Shape{
    private Point topLeft;
    private float width;
    private float height;
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
    public Rectangle(Point topLeft,float width, float height)
    {
        topLeft = this.topLeft;
        width = this.width;
        height = this.height;
    }
    public float getWidth()
    {
        return width;
    }
    public void setX(float width)
    {
        this.width = width;
    }
    public float getHeight()
    {
        return height;
    }
    public void setHeight(float height)
    {
        this.height = height;
    }
    @Override public float getArea()
    {
        return width * height;
    }
    @Override public float getPerimeter()
    {
        return 2*(width + height);
    }
}
