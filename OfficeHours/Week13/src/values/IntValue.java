package values;

public class IntValue extends Value {

    private int value;

    public IntValue() {
        value = 0;
    }

    public IntValue(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s, value: %d (int)", super.toString(), value);
    }
}
