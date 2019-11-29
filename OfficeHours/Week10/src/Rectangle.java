/**
 * Simple Model of a Rectangle
 */
public class Rectangle extends GeometricObject {
    // class Rectangle extends GeometricObject {
    //    - length: double { get set }
    //    - width: double { get set }
    //
    //    + Rectangle()
    //    + Rectangle(length: double, width: double)
    //
    //    + getArea(): double
    //
    //    + toString(): String
    //}

    private double length;
    private double width;

    /**
     * Default Constructor
     */
    public Rectangle() {
        length = 1;
        width = 1;
    }

    /**
     * Constructor
     */
    public Rectangle(double length, double width, String color, boolean filled) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    /**
     * Return length
     * @return
     */
    public double getLength() {
        return length;
    }

    /**
     * Set length
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Return width
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set Width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Return the area of the rectangle
     */
    public double getArea() {
        return length * width;
    }

    /**
     * return a string representation of our rectangle
     */
    @Override
    public String toString() {
        return String.format("Length: %.2f and Width: %.2f\n%s", length, width, super.toString());
    }
}
