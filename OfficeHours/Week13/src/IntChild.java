/**
 * Child class that has an integer value
 */
public class IntChild extends Parent {

    private int childField;

    /**
     * Default constructor
     */
    public IntChild() {
        childField = 0;
    }

    /**
     * Constructor
     * @param value The child field value
     * @param parentValue The parent field value
     */
    public IntChild(int value, String parentValue) {
        super(parentValue);
        childField = value;
    }

    /**
     * Getter for childField
     */
    public int getChildField() {
        return childField;
    }

    /**
     * Setter for childField
     */
    public void setChildField(int value) {
        childField = value;
    }

    @Override
    public String toString() {
        return String.format("IntChild { childField: %d, %s }", childField, super.toString());
    }

    @Override
    public String polymorphicMethod() {
        return "IntChild.polymorphicMethod";
    }
}
