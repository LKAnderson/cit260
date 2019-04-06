package assignments;

/**
 * A Rectangle class to model a rectangle in code.
 * @author kent
 */
public class Rectangle {
    
    private double width;
    private double height;
    
    /**
     * Default constructor. This is not too useful since we're
     * not providing a way to update the properties once the 
     * object is created.
     */
    public Rectangle() {
        width = 1;
        height = 1;
    }
    
    /**
     * Constructor. Create a new Rectangle object with the given
     * width and height.
     * @param width
     * @param height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Accessor method for the width property.
     * @return
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Accessor method for the height property;
     * @return
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Calculate the area of the rectangle.
     * @return
     */
    public double getArea() {
        return width * height;
    }
    
    /**
     * Calculate the perimeter of the rectangle.
     * @return
     */
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

}
