package assignments;

/**
 * Point class for Assignment 10.4
 * @author kent
 */
public class MyPoint {
    
    private double x;
    private double y;
    
    /**
     * Default construtor (0,0)
     */
    public MyPoint() {
        x = 0;
        y = 0;
    }
    
    /**
     * Constructor
     * @param x
     * @param y
     */
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @return the x
     */
    public double getX() {
        return x;
    }


    /**
     * @return the y
     */
    public double getY() {
        return y;
    }
    
    /**
     * Calculate the distance between this point and another point.
     * @param otherPoint
     * @return
     */
    public double distance(MyPoint otherPoint) {
        // Pythagorean Theorem: a^2 + b^2 = c^2
        //                      a*a + b*b = c*c
        //                  c = sqrt(a*a + b*b)
        
        // Find the distance between the x coordinates.
        double a = x - otherPoint.getX();
        
        // Find the distance between the y coordinates.
        double b = y - otherPoint.getY();
        
        // calculate and return the length of the hypotenuse
        return Math.sqrt((a*a) + (b*b));
    }
    
    
    /**
     * Calculate the distance between this point and another point
     * having the given x, y coordinates.
     * @param x
     * @param y
     * @return
     */
    public double distance(double x, double y) {
        return distance(new MyPoint(x, y));
    }
    
    
    /**
     * Calculate the distance between the two points.
     * @param point1
     * @param point2
     * @return
     */
    public static double distance(MyPoint point1, MyPoint point2) {
        return point1.distance(point2);
    }

}
