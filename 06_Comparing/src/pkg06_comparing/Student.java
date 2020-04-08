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
public class Student implements CompareInterface, Comparable<Student>{
    private String firstName;
    private String lastName;
    private int age;
    private int number;
    private int[] grades; //TODO
    private double average; //TODO

    public Student(String firstName, String lastName, int number, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + '}';
    }

    boolean startLater(Student student){
        return this.number > student.number;
    }

    boolean isOlder(Student student) {
        return this.age > student.age;
    }

    @Override
    public boolean isSmaler(CompareInterface o) {
        return this.number > ((Student)o).number;
    }

//    @Override
//    public int compareTo(Object o) { //vrací záporné. nulu nebo kladne int
//        return this.number - ((Student)o).number;
//    }

    @Override
    public int compareTo(Student o) {
        return this.number - o.number;
    }
    
    //TODO
    //umožnit přidávat studentovi známky
    //vypočítat průměr
    //změnit compareTo, aby se třídilo podle průměru (porovnání reálných čísel - pres if, pomoci eps) - vraci -1, 0, 1
    
}
