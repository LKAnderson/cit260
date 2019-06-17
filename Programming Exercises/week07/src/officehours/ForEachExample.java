package officehours;

public class ForEachExample {

    
   
    
    
    public static void main(String[] args) {
        
        for (String arg: args) {
            System.out.println(arg);
        }
        
        int[] numbers = Utils.getRandomIntegerArray(100, 50);
        
        for (int number: numbers) {
            System.out.println(number);
        }
        
        
    }

}
