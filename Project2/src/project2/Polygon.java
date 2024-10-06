/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author GOLF
 */
public class Polygon extends Shape {
   private Point[] points;
    
    public Polygon(Point[] points,String color)
    {
        points = this.points;
    }
    public void addPoint(Point point)
    {
        System.out.println("Въведете брой на Точките в полигона:");
        int broi = sc.nextInt();
        for (int i = 0; i < broi; i++) {
        System.out.println("Въведете точка"+i+1+"(x y):");
        String[] broiInput = sc.nextLine().split(" ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        //Да питам гпт-то
        }
    }

    public Point[] getPoints()
    {
        return points;
    }
    @Override public String Shape(String color) {
        return color;
    }

    @Override public float getArea() {
        throw new UnsupportedOperationException("(Изчислението на площта не е изпълнено)"); 
    }

    @Override public float getPerimeter() {
        
    }  
    }
    
}
