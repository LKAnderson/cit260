package officehours;

/** 
 * A class to model a stock ticker object from the stock market. 
 */
public class Stock {

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    /**
     * Constructor/Initializer
     * @param symbol The ticker symbol
     * @param name The company name
     */
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

        previousClosingPrice = 0;
        currentPrice = 0;
    }

    /**
     * Returns the change percent as as fraction (50% = 0.50)
     */
    public double getChangePercent() {
        // Check for divide by zero condition, and don't let it happen.
        if (previousClosingPrice == 0) {
            return -1;
        }

        return (currentPrice - previousClosingPrice) / previousClosingPrice;
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

    public void setPreviousClosingPrice(double value) {
        previousClosingPrice = value;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double value) {
        currentPrice = value;
    }

    
}