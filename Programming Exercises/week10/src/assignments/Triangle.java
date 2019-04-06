package assignments;

public class Triangle extends GeometricObject2D {

    private double side1;
    private double side2;
    private double side3;

    /**
     * Default (useless) constructor.
     */
    public Triangle() {
        super();
        side1 = side2 = side3 = 1.0;
    }

    /**
     * Constructor.
     * @param side1
     * @param side2
     * @param side3
     * @param color
     * @param isFilled
     */
    public Triangle(
            double side1, double side2, double side3, 
            String color, boolean isFilled) {

        super(color, isFilled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Calculate the perimiter of the triangle.
     */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
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
     * @return the side1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @param side1 the side1 to set
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * @return the side2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @param side2 the side2 to set
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * @return the side3
     */
    public double getSide3() {
        return side3;
    }

    /**
     * @param side3 the side3 to set
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /**
     * Return a string representation of the triangle object.
     */
    @Override
    public String toString() {
        return String.format("Triangle { %s, side1: %f, side2: %f, side3: %f }",
            super.toString(), side1, side2, side3);
    }

    
}