/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

/**
 *
 * @author Pomeisl Petr
 */
public class Square extends Rectangle {
    private double a;
    private double b;
    private double area;

    private Square(double a){
        this.a = a;
        this.b = a;
        this.area = computeArea();
    }
    
        public static Square getSquare(double a){
            return new Square(a);
        }

    @Override
    public double getA() {
        return a;
    }

    @Override
    public double getArea() {
        return area;
    }
    
    @Override
    public String toString() {
        return "Square{" + "a=" + a + ", area=" + area + '}';
    }

    
}
