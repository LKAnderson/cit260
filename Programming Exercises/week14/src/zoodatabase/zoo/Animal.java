package zoodatabase.zoo;

import java.io.Serializable;

/**
 * Base class of all Animals in our program.
 */
public abstract class Animal implements Serializable {

    // This is added because Serializable requires it. We won't use it.
    private static final long serialVersionUID = 1L;

    private String name;

    /** 
     * Default Constructor
     * The animal's name will default to null.
     */
    protected Animal() {
    }

    /**
     * Constructor
     * @param name
     */
    protected Animal(String name) {
        this.name = name;
    }

    /**
     * Return the animal's name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the animal's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * What does the animal say?
     * @return A word or phrase that is characteristic
     * of the type of animal.
     */
    public abstract String speak();


    /**
     * Return a printable description of the animal.
     */
    public abstract String getDescription();


    /**
     * Describe the Animal object.
     */
    @Override
    public String toString() {
        return String.format("Animal { name: %s }", name);
    }

}