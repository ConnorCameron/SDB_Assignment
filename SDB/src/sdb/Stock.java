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
    private double betaMeasure;
    private String stockSymbol;
    private double sharePrice;

    public Stock(double quarterlyDivident, double baseRateOfReturn, double betaMeasure, String stockSymbol, double sharePrice, String code, String label) {
        super(code, label);
        this.quarterlyDivident = quarterlyDivident;
        this.baseRateOfReturn = baseRateOfReturn;
        this.betaMeasure = betaMeasure;
        this.stockSymbol = stockSymbol;
        this.sharePrice = sharePrice;
    }
    
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }

    public double getBaseRateOfReturn() {
        return this.baseRateOfReturn;
    }

    public double getBetaMeasure() {
        return this.betaMeasure;
    }

    public String getSockSymbol() {
        return stockSymbol;
    }

    public double getSharePrice() {
        return this.sharePrice;
    }
    
    public String getType() {
        return "S";
    }
}
