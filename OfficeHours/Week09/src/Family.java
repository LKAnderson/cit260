import java.util.ArrayList;

/**
 * The Family model in our program.
 */
public class Family {

    private Person father;
    private Person mother;
    private ArrayList<Person> children;
    
    /**
     * Constructor: start a family
     * @param father
     * @param mother
     */
    public Family(Person father, Person mother) {
        // Notice that we allow a null for father
        // or mother to allow for different family
        // circumstances.
        this.father = father;
        this.mother = mother;
        
        children = new ArrayList<Person>();
    }

    /**
     * Get the father of the family
     * @return the father
     */
    public Person getFather() {
        return father;
    }

    /**
     * Set a new father of the family
     * @param father the father to set
     */
    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * Get the mother of the family
     * @return the mother
     */
    public Person getMother() {
        return mother;
    }

    /**
     * Set a new mother of the family
     * @param mother the mother to set
     */
    public void setMother(Person mother) {
        this.mother = mother;
    }
    
    /**
     * Add a new child to the family.
     * @param child
     */
    public void addChild(Person child) {
        children.add(child);
    }
    
    /**
     * Get the number of children.
     * @return the number of children
     * @return
     */
    public int getChildrenCount() {
        return children.size();
    }
    
    /**
     * Return the specifed child in the list
     * @param index
     * @return null if the index is out of bounds
     */
    public Person getChild(int index) {
        if (index < 0 || index >= children.size()) {
            return null;
        }
        return children.get(index);
    }
    
}