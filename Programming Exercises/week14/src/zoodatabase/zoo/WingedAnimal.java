package zoodatabase.zoo;


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
     * Return a printable description of the Ostrich
     * @return
     */
    @Override
    public String getDescription() {
        return String.format("%s (%s) has wings %s, and says '%s'", 
            getName(),
            getClass().getSimpleName(),
            flying == true ? "and flies" : "but does not fly",
            speak());
    }


    /**
     * toString() override.
     */
    @Override
    public String toString() {
        return String.format(" WingedAnimal { %s, flying: %b }", super.toString(), flying);
    }

}