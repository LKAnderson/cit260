package officehours;



public class LinearSearch {
    
    public static void main(String[] args) {
        
        int[] numbers = Utils.getSortedIntegerArray(200000000, 0);
        
        int searchFor = Utils.getRandomInt(40000000);
        System.out.println("Searching for " + searchFor);
        int foundAt = -1;
        
        for (int i=0; i < numbers.length; i++) {
            if (numbers[i] == searchFor) {
                foundAt = i;
                break;
            }
        }
        
        System.out.println("Found at " + foundAt);
    }

}

