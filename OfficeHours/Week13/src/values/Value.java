package values;

public class Value {

    private String name;

    protected Value() {
        name = null;
    }

    protected Value(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("name: %s", name);
    }
}
