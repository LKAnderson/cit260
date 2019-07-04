package officehours.database;


public class Dog extends Animal {

    private String favoriteToy;

    /**
     * Default constructor. FavoriteToy is defaulted to null.
     */
    public Dog() {
        super();
    }

    /**
     * Constructor
     * 
     * @param name
     * @param favoriteToy
     */
    public Dog(String name, String favoriteToy) {
        super(name);
        this.favoriteToy = favoriteToy;
    }

    /**
     * @return the favoriteToy
     */
    public String getFavoriteToy() {
        return favoriteToy;
    }

    /**
     * @param favoriteToy the favoriteToy to set
     */
    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    /**
     * Return the dog's characteristic sound.
     */
    @Override
    public String speak() {
        return "Woof!";
    }

    /**
     * toString() override.
     */
    @Override
    public String toString() {
        return String.format("Dog { %s, favoriteToy: %s }", super.toString(), favoriteToy);
    }

}