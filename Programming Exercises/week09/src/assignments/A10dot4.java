package assignments;

public class A10dot4 {

    public static void main(String[] args) {
        
        MyPoint point1 = new MyPoint();
        MyPoint point2 = new MyPoint(10, 30.5);
        
        double distance = MyPoint.distance(point1, point2);
        System.out.println("The distance is " + distance);
    }

}
