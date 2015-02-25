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
public class PrivateInvestment extends Asset {
    private double quarterlyDivident;
    private double baseRateOfReturn;
    private double totalValue;
    private double stake;

    public PrivateInvestment(double quarterlyDivident, double baseRateOfReturn, double totalValue, String code, String label, double rateOfReturn) {
        super(code, label, rateOfReturn);
        this.quarterlyDivident = quarterlyDivident;
        this.baseRateOfReturn = baseRateOfReturn;
        this.totalValue = totalValue;
    }

    

    public double getQuarterlyDivident() {
        return quarterlyDivident;
    }

    public double getBaseRateOfReturn() {
        return baseRateOfReturn;
    }

    public double getTotalValue() {
        return totalValue;
    }
    
    public String getType() {
        return "P";
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }
    
    
}
