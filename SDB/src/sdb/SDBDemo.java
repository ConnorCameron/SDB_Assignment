/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdb;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class SDBDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Set<Person> persons;
        Set<Asset> assets;
        Set<Portfolio> portfolios;
        
        
        //Calls DataConverter
        DataConverter converter = DataConverter.getInstance();
        
        //Calls the dataconverter
        persons = converter.processPersons("Persons.dat");
        assets = converter.processAssets("Assets.dat");
        portfolios = converter.processPortfolios("Portfolios.dat", assets, persons);
        
        
                System.out.println("Portfolio Summary Report");
                System.out.println("===============================================================================================================================");
                System.out.printf("%10s    %25s  %20s  %14s  %15s  %20s  %15s  %15s\n", "Portfolio", "Owner", "Manger", "Fees", "Commisions", "Weighted Risk", "Return", "Total");
                /* Goes through portfolios and keeps track of totals */
                Iterator<Portfolio> itr = portfolios.iterator();
                double total = 0;
                double areturn = 0;
                double commissions = 0;
                double fees = 0;
                while (itr.hasNext()) {
                    Portfolio portfolio = itr.next();
                    String fullOwn = portfolio.getOwner().getLastName() + ", " + portfolio.getOwner().getFirstName();
                    String fullMan = portfolio.getBroker().getLastName() + ", " + portfolio.getOwner().getFirstName();
                    System.out.printf("%10s        %25s    %20s    $%6.2f    $%13.2f    $%18.2f    $%13.2f    $%13.2f\n", portfolio.getPortfolioCode(), fullOwn, fullMan, portfolio.getFees(), portfolio.getCommissions(), portfolio.getWeightedRisk(), portfolio.getAnnualReturn(), portfolio.getTotalValue());
                    total += portfolio.getTotalValue();
                    areturn += portfolio.getAnnualReturn();
                    commissions += portfolio.getCommissions();
                    fees += portfolio.getFees();
                }
                
                System.out.println("                                                              ----------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("                                                               Total: $%7.2f   $%15.2f  $%36.2f  $%16.2f\n\n\n", fees, commissions, areturn, total);
                System.out.println("Portfolio Details");
                System.out.println("============================================================================");
                
                Iterator<Portfolio> itr2 = portfolios.iterator();
                /* Gets the details of each portfolio with their assets */
                while (itr2.hasNext()) {
                    Portfolio portfolio = itr2.next();
                    String fullOwn = portfolio.getOwner().getLastName() + ", " + portfolio.getOwner().getFirstName();
                    String fullMan = portfolio.getBroker().getLastName() + ", " + portfolio.getOwner().getFirstName();
                    String fullBen;
                    if (portfolio.getBeneficiary() != null) {
                        fullBen = portfolio.getBeneficiary().getLastName() + ", " + portfolio.getOwner().getFirstName();
                    } else {
                        fullBen = "none";
                    }
                    System.out.println("Portfolio: " + portfolio.getPortfolioCode());
                    System.out.println("------------------------------------------");
                    System.out.println("Owner: " + fullOwn);
                    System.out.println("Manager: " + fullMan);
                    System.out.println("Beneficiary: " + fullBen);
                    Iterator<Asset> itrA = portfolio.getAssets().iterator();
                    if (itrA.hasNext()) {
                        System.out.println("Assets");
                        System.out.printf("%10s    %40s  %15s  %5s  %15s  %15s\n", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Total");

                        while (itrA.hasNext()) {
                            Asset asset = itrA.next();
                            System.out.printf("%10s    %40s  %15.2f %5.2f  $%15.2f  $%15.2f\n", asset.getCode(), asset.getLabel(), asset.getRateOfReturn(), asset.getRisk(), asset.getAnnualReturn(), asset.getTotalValue());
                        }
                        System.out.println("                                                         --------------------------------------");
                        System.out.printf("                                                          Totals:        %.2f  $ %14.2f  $%15.2f", portfolio.getWeightedRisk(), portfolio.getAnnualReturn(), portfolio.getTotalValue());
                    }
                    System.out.printf("\n\n\n");
                }
    }
}
