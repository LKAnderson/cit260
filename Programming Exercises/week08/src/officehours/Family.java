package officehours;

import java.util.ArrayList;

public class Family {

    // The family surname
    private String surname;
    private String father;
    private String mother;

    // This is a standard Java class that works a lot
    // like an array, but it can grow and shrink. The
    // "String" says the list will hold String values.
    private ArrayList<String> children;

    public Family(String surname, String father, String mother) {
        this.surname = surname;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<String>();
    }

    public String getSurname() {
        return surname;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public int getChildCount() {
        return children.size();
    }

    public String getChild(int whichOne) {
        if (whichOne > children.size()) {
            return null;
        }

        return children.get(whichOne);
    }

    public void addChild(String childname) {
        children.add(childname);
    }

    public void addChildren(String... names) {
        for (String name : names) {
            children.add(name);
        }
    }

    public static Family createFamily(String surname, String father, String mother) {
        return new Family(surname, father, mother);
    }
}
