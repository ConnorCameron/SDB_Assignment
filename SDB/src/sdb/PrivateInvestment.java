package sdb;

/**
 *
 * @author Andrew
 */
public class PrivateInvestment extends Asset {
    private double quarterlyDivident;
    private double totalValue;
    private double stake;

    public PrivateInvestment(double quarterlyDivident, double totalValue, String code, String label, double rateOfReturn, double risk) {
        super(code, label, rateOfReturn, risk);
        this.quarterlyDivident = quarterlyDivident;
        this.totalValue = totalValue;
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

    //Returns the stake owned
    public double getStake() {
        return this.stake;
    }

    //Sets the stake owned
    public void setStake(double stake) {
        this.stake = stake / 100;
    }
    
    //Returns the total value of a private investment
    @Override
    public double getTotalValue(String portCode){
        return this.totalValue * this.stake;
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