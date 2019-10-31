/**
 * Demonstrate loops that count from 1 to 100 by 4's
 */
public class CountingByFour {

    public static void main(String[] args) {

        // While loop
        int count = 0;

        while (count <= 100) {
            System.out.println(count);
            count += 4;
            // count = count + 4;
        }

        // for loop
        System.out.println("===============");

        for (int count2 = 0; count2 <= 100; count2 += 4) {
            System.out.println(count2);
        }

    }

}
