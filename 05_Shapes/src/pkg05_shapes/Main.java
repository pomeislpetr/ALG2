/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = Rectangle.getRectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("1. varianta");
        double allArea1 = c1.computeArea() + r1.getArea() + c2.computeArea();
        System.out.println(allArea1);
        
        System.out.println("2. varianta");
        ArrayList shapes2 = new ArrayList(); //Dynamicke pole objektu typu Object
        //Muze obsahovat cokoli, co je typove kompatibilni s Object (vsechno)
        shapes2.add(c1);
        shapes2.add(r1);
        shapes2.add(Circle.getInstanceR(2.6));
        
        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) { //going though using index
            if (shapes2.get(i) instanceof Circle){
            allArea2 += ((Circle)shapes2.get(i)).computeArea();
            } else if ((shapes2.get(i) instanceof Rectangle)){
            allArea2 += ((Rectangle)shapes2.get(i)).getArea();
            }
        }
        System.out.println(allArea2);
        
        System.out.println("3. varianta");
        ArrayList<Shape> shapes3 = new ArrayList<>(); //Dynamicke pole objektu typu Shape
        //muze obsahovat cokoliv, co je typove kompatibilni s Shape (Shape, Circle, Rectangle)
        //Shape s = new Rectangle(5, 6);
        //Rectangle r = new Shape(); //nelze
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        double allArea3 = 0;
        for (Shape shape : shapes3) { //for each
            allArea3 += shape.computeArea(); //polymorfism
        }
        System.out.println(allArea3);
    }
    
}
