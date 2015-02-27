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

    //this constrcuts the deposit account
    public Deposit(String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
    }
    
    //this returns the balence
    public double getBalance() {
        return this.balance;
    }
    
    //this returns the type of asset it is
    @Override
    public String getType() {
        return "D";
    }

    //this sets the balence
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    //this returns the balence, which is the total value
    @Override
     public double getTotalValue(){
         return this.balance;
     }
     
     //this returns the percentage rate used for annual return
     @Override
     public double getRateOfReturn() {
         return Math.pow(Math.E, this.rateOfReturn) - 1;
     }
     //this returns the annual return
     @Override
     public double getAnnualReturn(){
        return this.balance * (Math.pow(Math.E,this.rateOfReturn) - 1);
     }
     
     //this returns the risk, which is always 0
     @Override
     public double getRisk(){
         return 0;
     }
}
