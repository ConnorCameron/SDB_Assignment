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

    //this constructs an asset
    public Asset(String code, String label, double rateOfReturn, double risk) {
        this.code = code;
        this.label = label;
        this.rateOfReturn = rateOfReturn;
        this.risk = risk;
    }

    //this returns the assets code
    public String getCode() {
        return this.code;
    }

    //this returns the assets label
    public String getLabel() {
        return this.label;
    }
    
    //this returns the assets type
    public String getType() {
        return "Asset";
    }

    //this returns the assets rate of return
    public double getRateOfReturn() {
        return this.rateOfReturn;
    }
    
    // returns the total value
    public double getTotalValue(){
        return 0;
    }
    
    //returns the annual reuturn
    public double getAnnualReturn(){
        return 0;
    }
    
    //retunrs the risk
    public double getRisk(){
        return this.risk;
    }
}
