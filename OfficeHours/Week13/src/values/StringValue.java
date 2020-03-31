package values;

public class StringValue extends Value {

    private String value;

    public StringValue() {
        value = null;
    }

    public StringValue(String name, String value) {
        super(name);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s, value: %s (string)", super.toString(), value);
    }
}
