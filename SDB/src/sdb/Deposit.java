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
public class Deposit extends Asset {
    private double balance;
    private double APR;

    public Deposit(double balance, double APR, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.balance = balance;
        this.APR = APR;
    }

    public double getAPR() {
        return APR;
    }
    
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String getType() {
        return "D";
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
     public double getTotalValue(){
         return balance;
     }
     
     @Override
     public double getAnnualReturn(){
        return balance * Math.pow(Math.E, APR) - 1;
     }
     
     @Override
     public double getRisk(){
         return 0;
     }
}
