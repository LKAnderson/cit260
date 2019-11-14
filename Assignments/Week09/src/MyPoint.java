/**
 * Point class for Assignment 9.1
 */
public class MyPoint {
    
    private int x;
    private int y;
    
    /**
     * Default constructor (0,0)
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
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinate
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y coordinate
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Calculate the distance between this point and another point.
     * @param p
     * @return
     */
    public double distance(MyPoint p) {
        return distance(p.getX(), p.getY());
    }
    
    
    /**
     * Calculate the distance between this point and another point
     * having the given x, y coordinates.
     * @param xCoord
     * @param yCoord
     * @return
     */
    public double distance(int xCoord, int yCoord) {
        // Pythagorean Theorem: a^2 + b^2 = c^2
        //                      a*a + b*b = c*c
        //                  c = sqrt(a*a + b*b)

        // Find the distance between the x coordinates.
        double a = x - xCoord;

        // Find the distance between the y coordinates.
        double b = y - yCoord;

        // calculate and return the length of the hypotenuse
        return Math.sqrt((a*a) + (b*b));
    }
    
    
    /**
     * Calculate the distance between the two points.
     * @param point1
     * @param point2
     * @return
     * @throws IllegalArgumentException if either point is null
     */
    public static double distance(MyPoint point1, MyPoint point2) {
        if (point1 == null || point2 == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        return point1.distance(point2);
    }

    /**
     * Return a string representation of the point.
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

}
