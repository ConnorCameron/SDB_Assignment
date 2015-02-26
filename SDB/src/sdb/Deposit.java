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

    public Deposit(String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
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
    
    
}
