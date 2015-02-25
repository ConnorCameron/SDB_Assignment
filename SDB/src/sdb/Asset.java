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

    public Asset(String code, String label, double rateOfReturn) {
        this.code = code;
        this.label = label;
        this.rateOfReturn = rateOfReturn;
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
    
    
    
    
    
}
