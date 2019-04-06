package officehours;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import officehours.menu.Menu;

public class ZooTest {

    public static void main(String[] argv) {

        // create the list of animals
        ArrayList<Animal> zoo = ZooDatabase.getZoo();

//        zoo.add(new Bat("Bruce"));
//        zoo.add(new Canary("BigBird"));
//        zoo.add(new Ostrich("Frank"));
//        zoo.add(new Dog("Fido", "Rubber Bone"));
        
        
        // Menu Handler to add a new animal
        Dog dog = new Dog();
        String name = Menu.prompt("Enter the dog's name: ");
        dog.setName(name);
        
        String toy = Menu.prompt("Enter its favorite toy: ");
        dog.setFavoriteToy(toy);
        
        zoo.add(dog);
        ZooDatabase.storeZoo();
        
        
        // Menu Handler to remove an animal
        // print out animals in the list
        for (int i=0; i < zoo.size(); i++) {
            System.out.printf("%d - %s", i+1, zoo.get(i).toString());
        }
        
        // Prompt the user for the number of the animal to delete
        String choice = Menu.prompt("Enter the id to delete? ");
        
        int deleteChoice = -1;
        try {
            deleteChoice = Integer.parseInt(choice);
        } catch (NumberFormatException exception) {
            // do something useful like print out an error message and then
            // return.
        }
        
        
        
        zoo.remove(deleteChoice);
        ZooDatabase.storeZoo();
        
        // End of the delete method.
        
        
        
        
        // Write the serialized version.
//        try {
//            writeZooUsingSerializable("Zoo.serialized.dat", zoo);
//            System.out.println("Successfully wrote the zoo to the file.");
//        } catch (IOException exception) {
//            System.err.println("Could not write the zoo to the file");
//            exception.printStackTrace(System.err);
//        }
//
//        // Read the serialized version.
//        try {
//            zoo = loadZooUsingSerializable("Zoo.serialized.dat");
//            System.out.println("Successfully loaded the zoo from the file.");
//        } catch (IOException exception) {
//            System.err.println("Could not load the zoo from the file");
//            exception.printStackTrace(System.err);
//        }
        
        
       
        printZoo(zoo);

        
    }

    /**
     * 
     * @param zoo
     */
    private static void printZoo(ArrayList<Animal> zoo) {
        // Print out what each animal says.
        System.out.println("The zoo can get noisy...");
        System.out.println();

        for (Animal animal: zoo) {
            String animalType = animal.getClass().getSimpleName();
            System.out.printf("The %s says '%s'.%n", animalType, animal.speak());
        }

        // Print out the toString() of each animal.
        System.out.println();
        System.out.println("Here some debug info...");
        System.out.println();

        for (Animal animal: zoo) {
            System.out.println(animal.toString());
        }
    }

    /**
     * Write the zoo to the specified file location.
     * @param filepath
     * @param zoo
     * @throws IOException
     */
    private static void writeZooUsingSerializable(
        String filepath, 
        ArrayList<Animal> zoo) throws IOException {

        File serializedFile = new File(filepath);
        
        try (ObjectOutputStream out = 
            new ObjectOutputStream(
                new FileOutputStream(serializedFile))) {
            
            out.writeObject(zoo);
        }
    }

    /**
     * Load the zoo from the file.
     * @param filepath
     * @return
     * @throws IOException
     */
    
    private static ArrayList<Animal> loadZooUsingSerializable(String filepath)
        throws IOException {
        
        File serializedFile = new File(filepath);
        try (ObjectInputStream in = 
                new ObjectInputStream(
                new FileInputStream(serializedFile))) {
            
            Object data = in.readObject();
            
            return (ArrayList<Animal>) data;
            
            
        } catch (ClassNotFoundException exception) {
            throw new IOException("Class not found", exception);
        }
    }
    
    
}