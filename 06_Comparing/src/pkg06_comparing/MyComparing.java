/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg06_comparing;

/**
 *
 * @author Pomeisl Petr
 */
public class MyComparing {
    
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        print(students);
        System.out.println("");
        System.out.println("Sort By Number");
        sortByNumber(students);
        print(students);
        System.out.println("");
        System.out.println("Sort By Age");
        sortByAge(students);
        print(students);
        
        System.out.println("");
        System.out.println("Sort By Number (Interface)");
        sort(students);
        print(students);
    }
    
    private static void sort(CompareInterface[] array){
         for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j-1].isSmaler(array[j]));
                    CompareInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
            }
        }
    }
    
    private static void sortByNumber(Student[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 1; j < array.length-i; j++){
                if(array[j-1].startLater(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    private static void sortByAge(Student[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j-1].isOlder(array[j]));
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
            }
        }
    }
    
    public static void print(Student[] array){
        for (Student student : array) {
            System.out.println(student);
        }
    }
}