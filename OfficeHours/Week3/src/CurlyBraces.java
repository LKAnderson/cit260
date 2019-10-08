public class CurlyBraces {

    // Rule: All blocks of code that contain more than one
    // statement must be contained within a block delimited
    // by curly braces.

    // Except: Classes and methods. They have to have curly braces.

    // Infer: blocks that contain only one statement, do not need
    // to be in curly braces.


    public static void main(String[] args) {

        int a = 2;

        if (a == 2) {
            System.out.println("A is 2");
        }

        System.out.println("This is line 2");
    }


}