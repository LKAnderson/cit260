package zoodatabase.zoo;


public class Bat extends WingedAnimal {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    protected Bat() {
        super(null, true);
    }

    /**
     * Constructor. Flying is automatically set to true.
     * 
     * @param name
     */
    public Bat(String name) {
        super(name, true);
    }

    /**
     * Return the characteristic sound of a bat.
     */
    @Override
    public String speak() {
        return "Squeak!";
    }

    /**
     * toString() override
     */
    @Override
    public String toString() {
        return String.format("Bat { %s }", super.toString());
    }

    

}