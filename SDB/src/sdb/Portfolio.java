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

    //this constructs the portfolio
    public Portfolio(Broker broker, Person beneficiary, Person owner, String portfolioCode) {
        this.broker = broker;
        this.beneficiary = beneficiary;
        this.owner = owner;
        this.portfolioCode = portfolioCode;
    }

    //returns the broker associated with this portfolio
    public Broker getBroker() {
        return this.broker;
    }
    
    //returns the beneficiary associated with this portfolio
    public Person getBeneficiary() {
        return this.beneficiary;
    }

    //returns the Owner associated with this portfolio
    public Person getOwner() {
        return this.owner;
    }

    //returns the Portfolio code associated with this portfolio
    public String getPortfolioCode() {
        return this.portfolioCode;
    }

    //returns the set of assets that are in this portfolio
    public Set<Asset> getAssets() {
        return this.assets;
    }
    
    //this adds an asset to the set of assets
    public void addAsset(Asset a){
        this.assets.add(a);
    }
    
    //this returns the fees a broker charges
    public double getFees(){
        if(this.broker.getIsExpert() == false){
            return this.assets.size() * 50;
        }else{
            return this.assets.size() * 10;
        }
    }
    
    //this returns the total value of the assets in the portfolio
    public double getTotalValue(){
        Iterator<Asset> itr = this.assets.iterator();
        double result = 0;
        while (itr.hasNext()){
            result = itr.next().getTotalValue() + result;
        }
        return result;
    }
    
    //this returns the annual return of all the assets
    public double getAnnualReturn(){
        Iterator<Asset> itr = this.assets.iterator();
        double result = 0;
        while (itr.hasNext()){
            result = itr.next().getAnnualReturn() + result;
        }
        return result;
    }
    
    //this returns the ammount of commissions that a broker makes
    public double getCommissions(){
        if (this.broker.getIsExpert() == false){
            return this.getAnnualReturn() * .02;
        }else{
            return this.getAnnualReturn() * .05;
        }
    }
    
    //this returns the weighted risk of all assets
    public double getWeightedRisk(){
        double V = this.getTotalValue();
        Iterator<Asset> itr = this.assets.iterator();
        double result = 0;
        while(itr.hasNext()){
            Asset a = itr.next();
            result = result + (a.getRisk() * (a.getTotalValue()/V));
        }
        return result;
    }
 }
