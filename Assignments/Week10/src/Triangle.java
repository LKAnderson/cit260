/**
 * Implementation of the Triangle class
 */
public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Default constructor
     */
    public Triangle() {
        super();
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    /**
     * Full Constructor
     * @param side1
     * @param side2
     * @param side3
     * @param color
     * @param filled
     */
    public Triangle(double side1, double side2, double side3,
                    String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Get side1
     * @return
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Updated side1
     * @param side1
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * Get side2
     * @return
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Updated side2
     * @param side2
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * Get side3
     * @return
     */
    public double getSide3() {
        return side3;
    }

    /**
     * Updated side3
     * @param side3
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /**
     * Calculate the area of the triangle. Since we only know the
     * three sides, we must use Heron's formula. You can see
     * an example of it at https://www.mathopenref.com/heronsformula.html.
     */
    @Override
    public double getArea() {
        double p = (side1 + side2 + side3) / 2.0;
        double area = Math.sqrt(p * (p-side1) * (p-side2) * (p-side3));
        return area;
    }

    /**
     * return a string representation of our rectangle
     */
    @Override
    public String toString() {
        return String.format("Side1: %.2f, Side2: %.2f, Side3: %.2f\n%s",
                side1, side2, side3, super.toString());
    }
}
