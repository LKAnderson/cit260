/**
 * A placeholder parent class
 */
public class Parent {
    private String parentField;

    /**
     * Default Constructor
     */
    public Parent() {
        parentField = null;
    }

    /**
     * Constructor with value
     * @param value The value to initialize in the parentField
     */
    public Parent(String value) {
        parentField = value;
    }

    /**
     * Getter for parentField
     */
    public String getParentField() {
        return parentField;
    }

    /**
     * Setter for parentField
     */
    public void setParentField(String value) {
        parentField = value;
    }

    @Override
    public String toString() {
        return String.format("Parent { parentField: %s }", parentField);
    }

    /**
     * Simple method to implement polymorphism.
     */
    public String polymorphicMethod() {
        return "Parent.polymorphicMethod";
    }
}
