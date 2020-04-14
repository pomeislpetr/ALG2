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
public interface ShapeInterface { //nevytvari object typu ShapeInterface, musi byt metody implementovane individualne ve tridach
    //data
    final String NAME = "Geometricky utvar";
    
    //methods
    public double computeArea();
    
    default String getShapeName(){
        return this.getClass().getSimpleName();
    }
    
}