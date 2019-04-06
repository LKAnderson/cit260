package officehours;

public class Canary extends WingedAnimal {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    protected Canary() {
        super(null, true);
    }

    /**
     * Constructor.
     * Flying is automatically set to true.
     * @param name
     */
    public Canary( String name ) {
        super(name, true);
    }


    /**
     * Return the characteristic sound of a bat.
     */
    @Override
    public String speak() {
        return "Tweet!";
    }


    /**
     * toString() override
     */
    @Override
    public String toString() {
        return String.format("Canary { %s }", super.toString());
    }

}