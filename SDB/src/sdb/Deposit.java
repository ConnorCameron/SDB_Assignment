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

    public Deposit(double balance, String code, String label, double rateOfReturn) {
        super(code, label, rateOfReturn);
        this.balance = balance;
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
