/**
 * Test the MyInteger class.
 */
public class W9dotExample {

    public static void main(String[] args) {

        int[] testValues = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

        for (int testVal: testValues) {
            MyInteger myI = new MyInteger(testVal);

            System.out.println("Value: " + myI.getValue());

            System.out.format("MyInteger.isEven(%d) = %b%n",
                    testVal, MyInteger.isEven(testVal));
            System.out.format("MyInteger.isEven(MyInteger(%d) = %b%n",
                    testVal, MyInteger.isEven(myI));
            System.out.format("isEven(MyInteger(%d) = %b%n",
                    testVal, myI.isEven());

            System.out.format("MyInteger.isOdd(%d) = %b%n",
                    testVal, MyInteger.isOdd(testVal));
            System.out.format("MyInteger.isOdd(MyInteger(%d) = %b%n",
                    testVal, MyInteger.isOdd(myI));
            System.out.format("isOdd(MyInteger(%d) = %b%n",
                    testVal, myI.isOdd());

            System.out.format("MyInteger.isPrime(%d) = %b%n",
                    testVal, MyInteger.isPrime(testVal));
            System.out.format("MyInteger.isPrime(MyInteger(%d) = %b%n",
                    testVal, MyInteger.isPrime(myI));
            System.out.format("isPrime(MyInteger(%d) = %b%n",
                    testVal, myI.isPrime());

            System.out.println();
        }

        MyInteger myI = new MyInteger(3);
        MyInteger myI2 = new MyInteger(7);

        System.out.println("Is 3 == 3: " + myI.equals(3));
        System.out.println("Is 7 == 3: " + myI.equals(myI2));

        char[] data = new char[] { '1', '2', '3', '4' };
        System.out.println("1,2,3,4 = " + MyInteger.parseInt(data));

        String strData = "5678";
        System.out.println("5678 = " + MyInteger.parseInt(strData));
    }
}
