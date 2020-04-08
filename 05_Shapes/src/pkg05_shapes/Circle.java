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
public class Circle extends Shape{ //Circle je typove kompatibilni s Shape, Circle Is A Shape
    //data
        private double r;
    
    //constructors
        //public Circle(double r) {
        private Circle(double r) {
            this.r = r;
        }
    
//    public Circle(double d) { //toto nelze
//        this.r = d/2.0;
//    }
    
    //methods
        //tovarni metoda (factory method)
            public static Circle getInstanceD(double d){
                return new Circle(d/2);
            }
            
            public static Circle getInstanceR(double r){
                return new Circle(r);
            }
    
    /**
     *
     * @return
     */
    @Override
            public double computeArea(){
                return Math.PI*r*r;
            }
            
            
    //getters

        public double getR() {
            return r;
        }

    //setters

        public void setR(double r) {
            this.r = r;
        }
    
    
        @Override
        public String toString() {
            return "Circle{" + "r=" + r + '}';
        }
        
        public static void main(String[] args){
            Circle c1 = Circle.getInstanceR(4);
            System.out.println(c1);
            System.out.println(c1.computeArea());
        }
    
}
