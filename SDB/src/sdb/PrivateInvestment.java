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
    private double totalValue;
    private double stake;

    public PrivateInvestment(double quarterlyDivident, double totalValue, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.totalValue = totalValue;
    }

    

    public double getQuarterlyDivident() {
        return quarterlyDivident;
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
