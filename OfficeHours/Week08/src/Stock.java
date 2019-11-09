/**
 * The stock class
 */
public class Stock {

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    /**
     * Constructor
     * @param symbol
     * @param name
     */
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        previousClosingPrice = 0;
        currentPrice = 0;
    }

    /**
     * Empty constructor
     */
    public Stock() {
        symbol = null;
        name = null;
        previousClosingPrice = 0;
        currentPrice = 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Returns the change percentage between the previous closing price and the
     * current price.
     * @return description...
     */
    public double getChangePercent() {
        double difference = currentPrice - previousClosingPrice;
        return difference / previousClosingPrice;
    }
}
