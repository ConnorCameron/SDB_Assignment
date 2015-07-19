package sdb;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class PrivateInvestment extends Asset {
    private double quarterlyDivident;
    private double totalValue;
    private Set<Pair<String, Double>> stake = new HashSet<Pair<String, Double>>();

    public PrivateInvestment(double quarterlyDivident, double totalValue, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.totalValue = totalValue;
    }
    
    public void addStake(String portCode, Double s) {
        Pair<String, Double> pair = Pair.make(portCode, s);
        this.stake.add(pair);
    }
    
    public void removeStake(String portCode) {
        Iterator<Pair<String, Double>> itr = this.stake.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                this.stake.remove(pair);
            }
        }
    }
    
    public Double getStake(String portCode) {
        Iterator<Pair<String, Double>> itr = this.stake.iterator();
        while(itr.hasNext()) {
            Pair<String, Double> pair = itr.next();
            String currentCode = pair.getFirst();
            if (currentCode.equals(portCode)) {
                return pair.getSecond();
            }
        }
        return null;
    }
    
    //Returns the quarterly dividend
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }

    //Returns the total value of the investment
    public double getTotalValueOfInvestment() {
        return this.totalValue;
    }
    
	//Returns the type of the asset	
    @Override    
    public String getType() {
        return "P";
    }

    //Returns the total value of a private investment
    @Override
    public double getTotalValue(String portCode){
        return this.totalValue * (this.getStake(portCode) / 100);
    }
    
    //Returns the annual return of a private investment
    @Override
    public double getAnnualReturn(String portCode){
       return (this.rateOfReturn * this.getTotalValue(portCode)) + (4 * this.quarterlyDivident);
    }
    
    //Gets the risk using the omega measure
    @Override
    public double getRisk(){
       double O =  Math.pow(Math.E, (-100000/this.totalValue));
       return this.risk + O;
    }
}