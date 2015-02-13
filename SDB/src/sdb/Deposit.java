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
    private double apr;

    public Deposit(double apr, String code, String label) {
        super(code, label);
        this.apr = apr;
    }
    
    public double getBalance() {
        return balance;
    }

    public double getApr() {
        return apr;
    }
    
    @Override
    public String getType() {
        return "D";
    }
}
