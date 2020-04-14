/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;

/**
 *
 * @author Pomeisl Petr
 */
public class Square extends Rectangle {
    private double a;
    private double area;

    public Square (double a){
        super(a,a);
        this.a = a;
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
        //return "Square{" + "a=" + a + ", area=" + area + '}';
        return super.toString() + String.format(" a = %.2f", a);
    }

    
}
