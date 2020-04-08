/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

/**
 *  Nemenny (imutable) objekt
 * @author Pomeisl Petr
 */
public class Rectangle extends Shape{ //Rectangle je typove kompatibilni s Shape, Rectangle Is A Shape
    //data
    private double a;
    private double b;
    private double area;
  
    private Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }
    
    public static Rectangle getRectangle(double a, double b){
        return new Rectangle(a, b);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    //neni uz potreba
    public double getArea() {
        return area;
    }
    
    protected double area(){
        return a*b;
    }
    
    @Override
    public double computeArea(){
        return area;
    }
    
    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
    }
}
