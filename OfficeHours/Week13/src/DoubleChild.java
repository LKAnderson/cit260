/**
 * Child class that has an integer value
 */
public class DoubleChild extends Parent {

    private double childField;

    /**
     * Default constructor
     */
    public DoubleChild() {
        childField = 0.0;
    }

    /**
     * Constructor
     * @param value The child field value
     * @param parentValue The parent field value
     */
    public DoubleChild(double value, String parentValue) {
        super(parentValue);
        childField = value;
    }

    /**
     * Getter for childField
     */
    public double getChildField() {
        return childField;
    }

    /**
     * Setter for childField
     */
    public void setChildField(double value) {
        childField = value;
    }

    @Override
    public String toString() {
        return String.format("DoubleChild { childField: %f, %s }", childField, super.toString());
    }

    @Override
    public String polymorphicMethod( ) {
        return "DoubleChild.polymorphicMethod";
    }
}
