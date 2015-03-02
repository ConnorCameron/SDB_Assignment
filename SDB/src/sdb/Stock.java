/**
 * This class does stock
 */
package sdb;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class Stock extends Asset {
    private double quarterlyDivident;
    private String stockSymbol;
    private double sharePrice;
    private Set<Pair<String, Double>> numOfStocks = new HashSet<Pair<String, Double>>();

    //This is the constructer for the stock class
    public Stock(double quarterlyDivident, String stockSymbol, double sharePrice, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.stockSymbol = stockSymbol;
        this.sharePrice = sharePrice;
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
    @Override    
    public String getType() {
        return "S";
    }

    //this returns the stocks symbol
    public String getStockSymbol() {
        return this.stockSymbol;
    }
    
    public void addNumOfStocks(String portCode, Double number) {
        Pair<String, Double> pair = Pair.make(portCode, number);
        this.numOfStocks.add(pair);
    }
    
    public void removeNumOfStocks(String portCode) {
        Iterator<Pair<String, Double>> itr = this.numOfStocks.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                this.numOfStocks.remove(pair);
            }
        }
    }
    
    //this returns the number of stocks owned
    public Double getNumOfStocks(String portCode) {
        Iterator<Pair<String, Double>> itr = this.numOfStocks.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                return pair.getSecond();
            }
        }
        return null;
    }
    
    //this returns the total value of all stocks owned
    @Override
    public double getTotalValue(String portCode){
        double total = this.sharePrice * this.getNumOfStocks(portCode);
        return total;
    }
    
    //this returns the expected annual return
    @Override
    public double getAnnualReturn(String portCode){
        return (this.rateOfReturn * this.getTotalValue(portCode)) + (4 * this.quarterlyDivident);
    }
    
}
