package officehours;

/**
 * Rectangle class in our program
 */
public class Rectangle extends GeometricObject {

    private double width;
    private double height;

    /**
     * Default constructor
     */
    protected Rectangle() {
        super();
        width = 1;
        height = 1;
    }

    /**
     * Constructor
     */
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    /** Getter */
    public double getWidth() {
        return width;
    }

    /** Setter */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Getter */
    public double getHeight() {
        return height;
    }

    /** Setter */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Calculate the perimeter of the rect */
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    /** Calculate the area of the rect */
    public double getArea() {
        return width * height;
    }

    /** Return a string dump of the data in this object */
    @Override
    public String toString() {
        return String.format("{ %s width: %f, height: %f }", super.toString(), width, height);
    }

}
