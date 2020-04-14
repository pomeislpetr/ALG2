/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacevariant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class ShapesApp {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ShapeInterface> shapes = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        
        do{
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    printObjects();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                case 9:
                    sortObjects();
                    break;
                default:
                    System.out.println("Chybna volba");
            }
        }while (choice != 0);
        
    }
    
    private static void displayMenu(){
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke objekty");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis objekt s nejvetsi plochou");
        System.out.println("8. Vypis plochu objektu");
        System.out.println("0. Konce programu");
    }

    private static int readChoice() {
        return sc.nextInt();
    }

    //umozni zadat novou sadu objectu
    private static void clearObjects() {
        ArrayList<ShapeInterface> shapes = new ArrayList<>();
    }

    //sqare Is A Rectangle
    private static void addSquare() {
        System.out.println("");
        System.out.println("Zadej stranu a ctverce:");
        shapes.add(new Square(sc.nextDouble()));
    }
    
    private static void addRectangle() {
        System.out.println("");
        System.out.print("Zadej strany a, b obdelnika:");
        shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble()));
    }

    private static void addCircle() {
        System.out.println("");
        System.out.print("Zadej polomer r kruhu:");
        shapes.add(Circle.getInstanceR(sc.nextDouble()));
    }

    //typ, rozmery, obsah o vsech
    private static void printObjects() {
        for (ShapeInterface shape : shapes) {
            System.out.println("");
            System.out.println(shape.toString());
        }
    }

    //vsech
    private static void computeArea() {
        double area = 0;
        for (ShapeInterface shape : shapes) {
            area += shape.computeArea();
        }
        System.out.println("Celkovy obsah: " + area);
    }

    //info o objekte s max area
    private static void findWithMaxArea() {
        double maxArea = 0;
        for (ShapeInterface shape : shapes) {
            if (shape.computeArea() > maxArea){
                maxArea = shape.computeArea();
            }
        }
        System.out.println("Nejvetsi obsah je:" + maxArea);
    }

    //nechat zobrazit vsechny, nechat vybrat a o vybranem zobrazit info
    private static void getObjectInfo() {
        for (ShapeInterface shape : shapes) {
            System.out.println(shape);
            System.out.println(shape.computeArea());
            System.out.println("");
        }
    }

    //TODO - třídit podle plochy
//    private static void sortObjects() {
//        boolean condition = true;
//        int index = 0;
//        while (condition){
//            condition = false;
//            index = 0;
//            for (ShapeInterface shape : shapes) {
//                if (shape.computeArea() < )
//            }
//        }
    
     private static void sortObjects() {
        boolean condition = true;
        int index = 0;
        while (condition){
            condition = false;
            index = 0;
            for (int i = 0; i < (shapes.size() - 1); i++) {
                if (shapes.get(i).computeArea() < shapes.get(i + 1).computeArea()){
                    ShapeInterface temp = shapes.get(i);
                    shapes.get(i) =shapes.get(i + 1);
                    shapes.get(i + 1) = temp;
                    condition = true;
                }
            }
        }
    }
}
