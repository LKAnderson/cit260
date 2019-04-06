package zoodatabase.zoo;

public class Ostrich extends WingedAnimal {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    protected Ostrich() {
        super(null, false);
    }

    /**
     * Constructor.
     * Flying is automatically set to false.
     * @param name
     */
    public Ostrich( String name) {
        super(name, false);
    }


    /**
     * Return the characteristic sound of a bat.
     */
    @Override
    public String speak() {
        return "Awk!";
    }


    /**
     * toString() override
     */
    @Override
    public String toString() {
        return String.format("Ostrich { %s }", super.toString());
    }

}