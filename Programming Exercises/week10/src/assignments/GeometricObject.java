package assignments;

import java.util.Date;

/**
 * Represents an abstract geometric object.
 */
public class GeometricObject {

    private static int objectCounter = 0;

    private String color;
    private boolean filled;
    private Date dateCreated;
    private int creationOrder;

    /**
     * Default Constructor. This is private because it is intended that
     * this object cannot be created directly. So the constructor can 
     * only be called by a child class's constructor.
     */
    protected GeometricObject() {
        color = "white";
        filled = false;
        initializeObject();
    }
    
    /**
     * General constructor. Also protected to ensure that only the child
     * classes can be directly created.
     * @param color
     * @param filled
     */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        initializeObject();
    }

    /**
     * Set the creation date and order. This is in its own method so 
     * we don't have to write this logic more than once.
     */
    private void initializeObject(){
        dateCreated = new Date();
        creationOrder = getObjectCounter();
    }

    /**
     * Return the next object counter value. This is private because it
     * is an internal operation that no other code in the program should
     * care about.
     * @return
     */
    synchronized private static int getObjectCounter() {
        objectCounter += 1;
        return objectCounter;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * @param filled the filled to set
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @return the creationOrder 
     */
    public int getCreationOrder() {
        return creationOrder;
    }

    /**
     * Return a string representation of the values in this object.
     * Note that we generally use toString() for debugging purposes,
     * so it can be formatted in any way that helps us.
     */
    @Override
    public String toString() {
        return String.format("GeometricObject { order: %d, color: %s, filled: %b, created: %s }", 
            creationOrder, color, filled, dateCreated.toString());
    }

}