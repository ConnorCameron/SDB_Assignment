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
    private double omegaMeasure;
    private double totalValue;

    public PrivateInvestment(double quarterlyDivident, double baseRateOfReturn, double omegaMeasure, double totalValue, String code, String label) {
        super(code, label);
        this.quarterlyDivident = quarterlyDivident;
        this.baseRateOfReturn = baseRateOfReturn;
        this.omegaMeasure = omegaMeasure;
        this.totalValue = totalValue;
    }

    public double getQuarterlyDivident() {
        return quarterlyDivident;
    }

    public double getBaseRateOfReturn() {
        return baseRateOfReturn;
    }

    public double getOmegaMeasure() {
        return omegaMeasure;
    }

    public double getTotalValue() {
        return totalValue;
    }
    
    public String getType() {
        return "P";
    }
}
