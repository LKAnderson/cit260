package officehours;

import java.util.Date;

/**
 * The parent class of all geometric shapes.
 */
public class GeometricObject {

    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /**
     * Default Constructor
     */
    protected GeometricObject() {
        dateCreated = new Date();
    }

    /**
     * Constructor
     * @param color
     * @param filled
     */
    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Getter for the color
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for the color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Setter for filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Getter for the date created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Represent this object as a string.
     */
    @Override
    public String toString() {
        return String.format("{ color: %s, filled: %b, created: %s }", 
            color, filled, dateCreated.toString());
    }
}