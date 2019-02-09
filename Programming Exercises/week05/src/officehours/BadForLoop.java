package officehours;

public class BadForLoop {

    public static void main(String[] argv) {

        for (int i = 1, sum = 0; sum < 10000; i++) {
            sum += i;
            System.out.println(sum);
        }

        int i = 1;
        int sum = 0;
        while (sum < 10000) {
            sum = sum + i;
            i++;
        }

    }

}
