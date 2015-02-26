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
    private double baseRateOfReturn;
    private String stockSymbol;
    private double sharePrice;
    private double numOfStocks;

    public Stock(double quarterlyDivident, double baseRateOfReturn, String stockSymbol, double sharePrice, String code, String label, double rateOfReturn) {
        super(code, label, rateOfReturn);
        this.quarterlyDivident = quarterlyDivident;
        this.baseRateOfReturn = baseRateOfReturn;
        this.stockSymbol = stockSymbol;
        this.sharePrice = sharePrice;
    }

    

    
    
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }

    public double getBaseRateOfReturn() {
        return this.baseRateOfReturn;
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
    
    public double getTotalValue (){
        return this.numOfStocks * this.sharePrice;
    }

    public void setNumOfStocks(double numOfStocks) {
        this.numOfStocks = numOfStocks;
    }
    
    
}
