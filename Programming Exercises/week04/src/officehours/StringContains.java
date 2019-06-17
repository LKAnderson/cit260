/**
 * 
 */
package officehours;

import java.util.Scanner;

/**
 * @author kent
 *
 */
public class StringContains {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        var scanner = new Scanner(System.in);
        
        System.out.print("Enter the full string: ");
        var fullString = scanner.nextLine();
        
        if (fullString.length() < 1) {
            System.err.println("Invalid string");
            System.exit(1);
        }
        
        System.out.print("Enter some other string: ");
        var partialString = scanner.nextLine();
        
        if (partialString.length() < 1) {
            System.err.println("Invalid string");
            System.exit(1);
        }

        
        boolean isContained = fullString.contains(partialString);
        boolean isIndexOf = (fullString.indexOf(partialString) >= 0);
        
        System.out.printf("The second string %s contained in the first (contains)%n", 
                isContained == true ? "is" : "is not");
        
        System.out.printf("The second string %s contained in the first (indexOf)%n", 
                isIndexOf == true ? "is" : "is not");
        
        boolean isContainedHardWay = false;
        
        // for each character in fullString, see if it is the first character of partialString.
        // If so, then walk partialString and see if the characters match the same positions
        // in fullString.
        for (int fullIndex = 0; fullIndex < fullString.length(); fullIndex++) {
            
            if (fullString.charAt(fullIndex) == partialString.charAt(0)) {
                boolean isMatched = true;
                for (int partialIndex = 1; partialIndex < partialString.length(); partialIndex++) {
                    if (partialString.charAt(partialIndex) != fullString.charAt(fullIndex + partialIndex)) {
                        isMatched = false;
                        break;
                    }
                }
                
                if (isMatched == true) {
                    isContainedHardWay = true;
                    break;
                }
            }
        }
        
        
        System.out.printf("The second string %s contained in the first (hard way)%n", 
                isContainedHardWay == true ? "is" : "is not");
    }

}
