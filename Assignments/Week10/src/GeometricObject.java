import java.util.Date;

/**
 * Base class for our 2D geometric objects
 */
public class GeometricObject {
    protected String color = "white";
    protected boolean filled;
    protected Date dateCreated;

    /**
     * Construct a default geometric object.
     */
    public GeometricObject() {
        dateCreated = new Date();
    }

    /**
     * Construct a geometric object with the specified color and filled value.
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled value
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get date created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Calculate the area
     */
    public double getArea() {
        return 0;
    }

    /**
     * Return string representation of this object.
     */
    @Override
    public String toString() {
        return String.format("Created on %s\ncolor: %s and filled: %b",
                dateCreated.toString(), color, filled);
    }
}
