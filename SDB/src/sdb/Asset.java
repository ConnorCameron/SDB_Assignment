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
public abstract class Asset {
    
    protected String code;
    protected String label;
    protected double rateOfReturn;
    protected double risk;

    public Asset(String code, String label, double rateOfReturn, double risk) {
        this.code = code;
        this.label = label;
        this.rateOfReturn = rateOfReturn;
        this.risk = risk;
    }

    
    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
    
    public String getType() {
        return "Asset";
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
    
    public double getTotalValue(){
        return 0;
    }
    
    public double getAnnualReturn(){
        return 0;
    }
    
    public double getRisk(){
        return this.risk;
    }
}
