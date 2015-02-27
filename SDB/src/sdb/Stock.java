/**
 * This class does stock
 */
package sdb;

/**
 *
 * @author Andrew
 */
public class Stock extends Asset {
    private double quarterlyDivident;
    private String stockSymbol;
    private double sharePrice;
    private double numOfStocks;

    //This is the constructer for the stock class
    public Stock(double quarterlyDivident, String stockSymbol, double sharePrice, double numOfStocks, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.stockSymbol = stockSymbol;
        this.sharePrice = sharePrice;
        this.numOfStocks = numOfStocks;
    }
    
    //this returns the quarterly dividend
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }
    
    //this returns the share price
    public double getSharePrice() {
        return this.sharePrice;
    }
    
    //this returns a character that represents what type of asset it is
    public String getType() {
        return "S";
    }

    //this returns the stocks symbol
    public String getStockSymbol() {
        return this.stockSymbol;
    }

    //this returns the number of stocks owned
    public double getNumOfStocks() {
        return this.numOfStocks;
    }

    //this sets the number of stocks owned 
    public void setNumOfStocks(double numOfStocks) {
        this.numOfStocks = numOfStocks;
    }
    
    //this returns the total value of all stocks owned
    @Override
    public double getTotalValue(){
        return this.sharePrice * this.numOfStocks;
    }
    
    //this returns the expected annual return
    @Override
    public double getAnnualReturn(){
        return (this.rateOfReturn * this.getTotalValue()) + (4 * this.quarterlyDivident);
    }
    
}
