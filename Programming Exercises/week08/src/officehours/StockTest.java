package officehours;

public class StockTest {
    

    public static void main(String[] args) {
        
        long value = 100_000_000L;
        
        Stock orcl = new Stock("ORCL", "Oracle Corporation");
        
        orcl.setPreviousClosingPrice(34.50);
        orcl.setCurrentPrice(34.35);
        
        System.out.printf("The percent change for %s (%s) is %.2f%%%n",
                orcl.getName(),
                orcl.getSymbol(),
                100*orcl.getChangePercent());

        Stock msft = new Stock("MSFT", "Microsoft Corporation");
    }

}

