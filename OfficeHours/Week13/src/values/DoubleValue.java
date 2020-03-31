package values;

public class DoubleValue extends Value {

    private double value;

    public DoubleValue() {
        value = 0.0;
    }

    public DoubleValue(String name, double value) {
        super(name);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s, value: %f (double)", super.toString(), value);
    }
}
