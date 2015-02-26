/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private double baseRate;

    public Stock(double quarterlyDivident, String stockSymbol, double sharePrice, double numOfStocks, double baseRate, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.stockSymbol = stockSymbol;
        this.sharePrice = sharePrice;
        this.numOfStocks = numOfStocks;
        this.baseRate = baseRate;
    }

    public double getBaseRate() {
        return baseRate;
    }
    
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }

    public double getSharePrice() {
        return this.sharePrice;
    }
    
    public String getType() {
        return "S";
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getNumOfStocks() {
        return numOfStocks;
    }

    public void setNumOfStocks(double numOfStocks) {
        this.numOfStocks = numOfStocks;
    }
    
    @Override
    public double getTotalValue(){
        return sharePrice * numOfStocks;
    }
    
    @Override
    public double getAnnualReturn(){
        return (baseRate * this.getTotalValue()) + (4 * quarterlyDivident);
    }
    
}
