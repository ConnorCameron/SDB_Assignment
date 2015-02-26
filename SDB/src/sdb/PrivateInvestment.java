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
    private double baseRate;
    private double baseRisk;

    public PrivateInvestment(double quarterlyDivident, double totalValue, double stake, double baseRate, double baseRisk, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.totalValue = totalValue;
        this.stake = stake;
        this.baseRate = baseRate;
        this.baseRisk = baseRisk;
    }

    public double getBaseRisk() {
        return baseRisk;
    }

    

    public double getBaseRate() {
        return baseRate;
    }
    
    public double getQuarterlyDivident() {
        return quarterlyDivident;
    }

    public double getTotalValueOfInvestment() {
        return totalValue;
    }
    
    @Override
    public String getType() {
        return "P";
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }
    
    @Override
    public double getTotalValue(){
        return totalValue * stake;
    }
    
    @Override
    public double getAnnualReturn(){
       return (baseRate * this.getTotalValue()) + (4 * quarterlyDivident);
    }
    
    @Override
    public double getRisk(){
        double O;
        O = Math.pow(Math.E, -100000/this.getTotalValue());
        return this.baseRisk + O;
    }
}   
    
