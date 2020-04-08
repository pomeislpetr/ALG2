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
public abstract class Shape { //nevytvari object typu Shape, musi byt metody implementovane individualne ve tridach
    //data
    protected String name = "Geometricky utvar";
    
    //methods
    public abstract double computeArea();
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
    public String toString(){
        return name + " " + getShapeName();
    }
    
}