package officehours.database;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ZooDatabase {

    private static final String FILEPATH = "Zoo.txt";
    
    private static ArrayList<Animal> zoo = null;
    
    
    /**
     * Return the zoo database array, loading it from a file, if necessary.
     * This method is "synchronized," meaning that it is protected from
     * multiple threads calling it at the same time. Our program is not
     * multi-threaded, so it doesn't really matter here, but I wanted
     * to show you how it should be done in a real-world scenario.
     * @return
     */
    synchronized public static ArrayList<Animal> getZoo() {
        
        if (zoo == null) {
            try {
                loadZoo();
            } catch (IOException exception) {
                // Since we couldn't load the zoo, create an empty one.
                zoo = new ArrayList<>();
            }
        }
        
        return zoo;
    }


    /**
     * Produce a tabular report of all animals in the database.
     * @return A string containing the whole report.
     */
    synchronized public static String getZooReport() {
        StringBuilder report = new StringBuilder();

        // Define our columns
        var formatTemplate = "%-3s %-20s %-10s %-7s  %-10s %s%n";

        // Print the column headings
        report.append(String.format(formatTemplate, "", "NAME", "TYPE", "CAN FLY", "SPEAKS", "NOTES"));

        var zoo = getZoo();

        // Add each animal to the report.
        for (int i = 0; i < zoo.size(); i++) {
            var animal = zoo.get(i);

            var name = animal.getName();
            var type = animal.getClass().getSimpleName();
            var speaks = animal.speak();
            var canFly = "N/A";
            var notes = "";

            if (animal instanceof WingedAnimal) {
                canFly = ((WingedAnimal)animal).isFlying() ? "Yes" : "No";
            } else {
                // it's a dog
                notes = "Favorite Toy: " + ((Dog)animal).getFavoriteToy();
            }

            report.append(String.format(formatTemplate, (i+1), name, type, canFly, speaks, notes));
        }

        return report.toString();
    }
    
    
    
    /**
     * Write the list of animals out to a file.
     * @param zoo
     */
    public static void storeZoo() throws IOException {
        
        File textFile = new File(FILEPATH);
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(textFile))) {
            
            for (Animal animal : zoo) {
                out.printf("Type: %s%n", animal.getClass().getSimpleName());
                
                if (animal instanceof WingedAnimal) {
                    out.printf("Name: %s%n", animal.getName());
                    
                } else if (animal instanceof Dog) {
                    Dog dog = (Dog)animal;
                    out.printf("Name: %s%n", dog.getName());
                    out.printf("FavoriteToy: %s%n", dog.getFavoriteToy());
                }
            }
        } 
    }

    /**
     * Load a zoo.
     * @return
     */
    public static void loadZoo() throws IOException {
        
        File textFile = new File(FILEPATH);
        zoo = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(textFile)) {
            
            scanner.useDelimiter(Pattern.compile("[:\\n]"));
            
            while (scanner.hasNext()) {
                String key = scanner.next();
                String value = scanner.next().trim();
                
                Animal animal = null;
                
                if (key.equals("Type")) {
                    
                    switch(value) {
                        case "Dog":
                            animal = readDog(scanner);
                            break;
                        case "Bat":
                            animal = readBat(scanner);
                            break;
                        case "Canary":
                            animal = readCanary(scanner);
                            break;
                        case "Ostrich":
                            animal = readOstrich(scanner);
                            break;
                        default:
                            break;
                    }
                }
                
                if (animal != null) {
                    zoo.add(animal);
                }
            }
        } 
    }
    
    
    
    
    /**
     * 
     * @param scanner
     * @return
     */
    private static Dog readDog(Scanner scanner) {
        
        String name = null;
        String toy = null;
        
        for (int i=0; i < 2; i++) {
            
            String key = scanner.next();
            
            if (key.equals("Name")) {
                name = scanner.next();
                
            } else if (key.equals("FavoriteToy")) {
                toy = scanner.next();
            }
        }
        
        if (name == null || toy == null) {
            return null;
        }
        
        return new Dog(name.trim(), toy.trim());
        
    }
    
    /**
     * 
     * @param scanner
     * @return
     */
    private static Canary readCanary(Scanner scanner) {
        
        if (scanner.next().equals("Name") == false) {
            return null;
        }
        
        String name = scanner.next().trim();
        return new Canary(name);
        
    }
    
    /**
     * 
     * @param scanner
     * @return
     */
    private static Ostrich readOstrich(Scanner scanner) {
        
        if (scanner.next().equals("Name") == false) {
            return null;
        }
        
        String name = scanner.next().trim();
        return new Ostrich(name);
    }
    
    /**
     * 
     * @param scanner
     * @return
     */
    private static Bat readBat(Scanner scanner) {
        
        if (scanner.next().equals("Name") == false) {
            return null;
        }
        
        String name = scanner.next().trim();
        return new Bat(name);
        
    }
}








