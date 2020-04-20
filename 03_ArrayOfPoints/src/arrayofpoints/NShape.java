package arrayofpoints;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Petr Pomeisl
 */
public class NShape {
    //data
    private ArrayList<Point> points = new ArrayList<>();

    //constructors
    //default prazdny konstruktor
    public NShape(){

    }

    //TODO
    public NShape (Point[] points){    //netuším, proč to má být takhle
        this.points.addAll(Arrays.asList(points));
    }

    //TODO
    public NShape (ArrayList<Point> points){    //netuším, proč to má být takhle
        ArrayList<Point> newPoints = (ArrayList<Point>)points.clone();
        this.points.addAll(newPoints);
    }

    public void add(Point p){
        points.add(p);
    }

    public void add(double x, double y){
        points.add(new Point(x, y));
    }

    //TODO vyuzit prochazeni ArrayListu po indexech
    public double perim(){
        double perim = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            perim = perim + (points.get(i)).distanceTo(points.get(i + 1));
        }
        perim = perim + (points.get(points.size() - 1)).distanceTo(points.get(0));
        return perim;
    }

    public Point getPointAt(int index){
        return points.get(index);
    }

    public Point getNearest(){
        double min = Double.MAX_VALUE;
        Point nearest = null; //inicializace objektu
        double distance;
        for (Point point : points) { //prechadzanie ArrayListu pomocou foreach
            distance = point.getDistance();
            if(distance < min){
                min = distance;
                nearest = point;
            }
        }
        return nearest;
    }

    public Point getFurthest(){
        double max = Double.MIN_VALUE;
        Point furthest = null;
        double distance;
        for (Point point : points) {
            distance = point.getDistance();
            if(distance > max){
                max = distance;
                furthest = point;
            }
        }
        return furthest;
    }

    //TODO vrati maxDistance vzdalenost mezi body
    public double minDistanceBetween(){
        double minDistance = Double.MAX_VALUE;
        double distance;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size() - 1; j++) {
                distance = Point.distanceBetween(points.get(i), points.get(j));
                if(distance < minDistance){
                    minDistance = distance;
                }
            }
        }
        if(minDistance == Double.MAX_VALUE){
            minDistance = -1;
        }
        return minDistance;
    }

    //TODO vrati max vzdalenost mezi body
    public double maxDistanceBetween(){
        double maxDistance = Double.MIN_VALUE;
        double distance;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size() - 1; j++) {
                distance = Point.distanceBetween(points.get(i), points.get(j));
                if(distance > maxDistance){
                    maxDistance = distance;
                }
            }
        }
        if(maxDistance == Double.MIN_VALUE){
            maxDistance = -1;
        }
        return maxDistance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) { //testing
        NShape myShape = new NShape();
        myShape.add(new Point(2, 3));
        myShape.add(2, 4);
        System.out.println(myShape.getNearest());
    }
}
