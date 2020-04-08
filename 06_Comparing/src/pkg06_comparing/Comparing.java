/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pomeisl Petr
 */
public class Comparing {
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        print(students);
        
        System.out.println("");
        System.out.println("Sort by number");
        Arrays.sort(students); //Student musí být typově kompatibilní s Comparable<Student>
        print(students);
        
        
        List<Student> students1 = Datasource.loadDataAsList();
        print(students1);
        
        System.out.println("Sort by number");
        Collections.sort(students1);
        print(students1);
    }
    
    public static void print(Student[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
        
    public static void print(List array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
