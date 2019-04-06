package assignments;

/**
 * Represents a GeometricObject with two dimensions, which 
 * enables an area and perimiter to be calculated for them.
 * 
 * Note that this is just "adding" to the contract that our
 * shapes will have. This will become the super class for 
 * our other objects, like Triangle, Rectangle and Circle.
 * 
 * It is abstract because it does not provide an implementation
 * of getPerimeter() or getArea(). It is only requiring that
 * anything that inherits from it must provide them.
 */
public abstract class GeometricObject2D extends GeometricObject {

    /**
     * Default constructor.
     */
    protected GeometricObject2D() {
        super();
    }

    /**
     * Constructor.
     * @param color
     * @param isFilled
     */
    protected GeometricObject2D(String color, boolean isFilled) {
        super(color, isFilled);
    }

    /**
     * Calculate the perimeter of a 2D object.
     */
    public abstract double getPerimeter();

    /**
     * Calculate the area of a 2D object.
     * @return
     */
    public abstract double getArea();


    @Override
    public String toString() {
        return String.format("GeometricObject2D {%s}", super.toString());
    }

}