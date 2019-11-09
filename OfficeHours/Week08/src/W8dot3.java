/**
 * Exercise the Stock class we just wrote.
 */
public class W8dot3 {

    public static void main(String[] args) {

        Stock oracle = new Stock("ORCL", "Oracle Corporation");
        oracle.setPreviousClosingPrice(34.5);
        oracle.setCurrentPrice(34.35);

        System.out.format("The percent change is %.2f%%", 100 * oracle.getChangePercent());
    }
}
