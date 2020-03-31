package values;

public class BooleanValue extends Value {

    private boolean value;

    public BooleanValue() {
        value = false;
    }

    public BooleanValue(String name, Boolean value) {
        super(name);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s, value: %b (boolean)", super.toString(), value);
    }
}
