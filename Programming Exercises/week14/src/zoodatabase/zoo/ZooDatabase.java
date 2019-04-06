package zoodatabase.zoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ZooDatabase {

    private static final String FILEPATH = "Zoo.txt";
    
    private static ArrayList<Animal> zoo = null;
    
    
    /**
     * Return the zoo database array, loading it from a file, if necessary.
     * @return
     */
    synchronized public static ArrayList<Animal> getZoo() {
        
        if (zoo == null) {
            loadZoo();
        }
        
        return zoo;
    }
    
    
    
    /**
     * Write the list of animals out to a file.
     * @param zoo
     */
    public static void storeZoo() {
        
        File textFile = new File(FILEPATH);
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(textFile))) {
            
            
            for (Animal animal : zoo) {
                out.printf("Type: %s%n", animal.getClass().getSimpleName());
                
                if (animal instanceof WingedAnimal) {
                    out.printf("Name: %s%n", animal.getName());
               
                    
                } else if (animal instanceof Dog) {
                    Dog dog = (Dog)animal;
                    out.printf("Name: %s%n", animal.getName());
                    out.printf("FavoriteToy: %s%n", dog.getFavoriteToy());
                    
                }
            }
           
        
        } catch (FileNotFoundException exception) {
            System.err.println("Could not find file path");
            
        } 
        
    }

    /**
     * Load a zoo.
     * @return
     */
    public static void loadZoo() {
        
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
        } catch (FileNotFoundException exception) {
            System.err.println("Could not find file path");
            
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
                name = scanner.next().trim();
                
            } else if (key.equals("FavoriteToy")) {
                toy = scanner.next().trim();
            }
        }
        
        if (name == null || toy == null) {
            return null;
        }
        
        return new Dog(name, toy);
        
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








