/**
 * 
 */
package officehours;

/**
 * @author kent
 *
 */
public class Stock {
    
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;
    
    
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    
    
    public double getChangePercent() {
        if (previousClosingPrice == 0) {
            return 0;
        }
        
        double percentChange = (currentPrice - previousClosingPrice) / previousClosingPrice;
        return percentChange;
    }


    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }


    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the previousClosingPrice
     */
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }


    /**
     * @param previousClosingPrice the previousClosingPrice to set
     */
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }


    /**
     * @return the currentPrice
     */
    public double getCurrentPrice() {
        return currentPrice;
    }


    /**
     * @param currentPrice the currentPrice to set
     */
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    
    
}
