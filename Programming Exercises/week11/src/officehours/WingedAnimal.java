package officehours;


public abstract class WingedAnimal extends Animal {

    private static final long serialVersionUID = 1L;

    /**
     * Indicate whether the winged animal can fly.
     */
    private boolean flying;

    /**
     * Default Constructor.
     * flying will be defaulted to false.
     */
    protected WingedAnimal() {
        super();
        flying = false;
    }

    /**
     * Constructor.
     * @param name The animal name.
     * @param flying Indicate whether the animal flies.
     */
    public WingedAnimal(String name, boolean flying) {
        super(name);
        this.flying = flying;
    }

    /**
     * Return the flying property.
     * @return
     */
    public boolean isFlying() {
        return flying;
    }


    /**
     * toString() override.
     */
    @Override
    public String toString() {
        return String.format(" WingedAnimal { %s, flying: %b }", super.toString(), flying);
    }

}