package sdb;

/**
 *
 * @author Andrew
 */
public class PrivateInvestment extends Asset {
    private double quarterlyDivident;
    private double totalValue;
    private double stake;

    public PrivateInvestment(double quarterlyDivident, double totalValue, double stake, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.totalValue = totalValue;
        this.stake = stake;
    }
    
    //Returns the quarterly dividend
    public double getQuarterlyDivident() {
        return this.quarterlyDivident;
    }

    //Returns the total value of the investment
    public double getTotalValueOfInvestment() {
        return this.totalValue;
    }
    
	//Returns the type of the asset	@Override    public String getType() {
        return "P";
    }

    //Returns the stake owned
    public double getStake() {
        return this.stake;
    }

    //Sets the stake owned
    public void setStake(double stake) {
        this.stake = stake;
    }
    
    //Returns the total value of a private investment
    @Override
    public double getTotalValue(){
        return this.totalValue * this.stake;
    }
    
    //Returns the annual return of a private investment
    @Override
    public double getAnnualReturn(){
       return (this.rateOfReturn * this.getTotalValue()) + (4 * this.quarterlyDivident);
    }
    
}   
    
