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
 * @author Connor
 */
public class Portfolio {
    protected Broker broker;
    protected Person beneficiary;
    protected Person owner;
    protected String portfolioCode;
    protected Set<Asset> assets = new HashSet<Asset>();

    public Portfolio(Broker broker, Person beneficiary, Person owner, String portfolioCode) {
        this.broker = broker;
        this.beneficiary = beneficiary;
        this.owner = owner;
        this.portfolioCode = portfolioCode;
    }

    public Broker getBroker() {
        return broker;
    }

    public Person getBeneficiary() {
        return beneficiary;
    }

    public Person getOwner() {
        return owner;
    }

    public String getPortfolioCode() {
        return portfolioCode;
    }

    public Set<Asset> getAssets() {
        return assets;
    }
    
    
    public void addAsset(Asset a){
        assets.add(a);
    }
    
    public double getFees(){
        if(broker.getIsExpert() == false){
            return assets.size() * 50;
        }else{
            return assets.size() * 10;
        }
    }
    
    public double getTotalValue(){
        Iterator<Asset> itr = assets.iterator();
        double result = 0;
        while (itr.hasNext()){
            result = itr.next().getTotalValue() + result;
        }
        return result;
    }
    
    public double getAnnualReturn(){
        Iterator<Asset> itr = assets.iterator();
        double result = 0;
        while (itr.hasNext()){
            result = itr.next().getAnnualReturn() + result;
        }
        return result;
    }
    
    public double getCommissions(){
        if (broker.getIsExpert() == false){
            return this.getAnnualReturn() * .02;
        }else{
            return this.getAnnualReturn() * .05;
        }
    }
    
    public double getWeightedRisk(){
        double V = this.getTotalValue();
        Iterator<Asset> itr = assets.iterator();
        double result = 0;
        while(itr.hasNext()){
            Asset a = itr.next();
            result = result + (a.getRisk() * (a.getTotalValue()/V));
        }
        return result;
    }
 }
