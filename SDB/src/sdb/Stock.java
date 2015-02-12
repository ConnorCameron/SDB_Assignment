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
    private String sockSymbol;
    private double sharePrice;

    public Stock(double quarterlyDivident, double baseRateOfReturn, double betaMeasure, String sockSymbol, double sharePrice, String code, String label) {
        super(code, label);
        this.quarterlyDivident = quarterlyDivident;
        this.baseRateOfReturn = baseRateOfReturn;
        this.betaMeasure = betaMeasure;
        this.sockSymbol = sockSymbol;
        this.sharePrice = sharePrice;
    }
    
    public double getQuarterlyDivident() {
        return quarterlyDivident;
    }

    public double getBaseRateOfReturn() {
        return baseRateOfReturn;
    }

    public double getBetaMeasure() {
        return betaMeasure;
    }

    public String getSockSymbol() {
        return sockSymbol;
    }

    public double getSharePrice() {
        return sharePrice;
    }
    
    public String getType() {
        return "S";
    }
}
