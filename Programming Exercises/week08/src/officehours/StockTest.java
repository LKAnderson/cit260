package officehours;

/**
 * Test our Stock class and it's percent changed method.
 */
public class StockTest {

    public static void main(String[] argv) {

        var stock = new Stock("ORCL", "Oracle Corporation");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);

        double percentChange = stock.getChangePercent();

        System.out.printf("Percent Change is %.2f%%%n", percentChange * 100);
    }

}