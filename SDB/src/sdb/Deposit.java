/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdb;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class Deposit extends Asset {
    
    
    
    private Set<Pair<String, Double>> balance = new HashSet<Pair<String, Double>>();

    //this constrcuts the deposit account
    public Deposit(String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
    }
    
    //Adds a balance pairing with a portfolio
    public void addBalance(String portCode, Double b) {
        Pair<String, Double> pair = Pair.make(portCode, b);
        this.balance.add(pair);
    }
    
    //Removes a balance pairing with a portfolio
    public void removeBalance(String portCode) {
        Iterator<Pair<String, Double>> itr = this.balance.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                this.balance.remove(pair);
            }
        }
    }
    
    //this returns the balence
    public Double getBalance(String portCode) {
        Iterator<Pair<String, Double>> itr = this.balance.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                return pair.getSecond();
            }
        }
        return null;
    }
    
    //this returns the type of asset it is
    @Override
    public String getType() {
        return "D";
    }
    
    //this returns the balence, which is the total value
    @Override
     public double getTotalValue(String portCode){
         return this.getBalance(portCode);
     }
     
     //this returns the percentage rate used for annual return
     @Override
     public double getRateOfReturn() {
         return Math.pow(Math.E, this.rateOfReturn) - 1;
     }
     //this returns the annual return
    @Override
     public double getAnnualReturn(String portCode){
        return this.getBalance(portCode) * (Math.pow(Math.E,this.rateOfReturn) - 1);
     }
     
     //this returns the risk, which is always 0
     @Override
     public double getRisk(){
         return 0;
     }
}
