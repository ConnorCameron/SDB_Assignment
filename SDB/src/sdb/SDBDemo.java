/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdb;

/*
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
*/
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/*
import java.util.Arrays;
import java.util.HashSet;
*/
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try {
            try ( /* Outputing the Summary */ PrintWriter summaryWriter = new PrintWriter("./data/output.txt", "UTF-8")) {
                summaryWriter.println("Portfolio Summary Report");
                summaryWriter.println("===============================================================================================================================");
                summaryWriter.printf("%10s    %25s  %20s  %14s  %15s  %20s  %15s  %15s\n", "Portfolio", "Owner", "Manger", "Fees", "Commisions", "Weighted Risk", "Return", "Total");
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
                    summaryWriter.printf("%10s        %25s    %20s    $%6.2f    $%13.2f    $%18.2f    $%13.2f    $%13.2f\n", portfolio.getPortfolioCode(), fullOwn, fullMan, portfolio.getFees(), portfolio.getCommissions(), portfolio.getWeightedRisk(), portfolio.getAnnualReturn(), portfolio.getTotalValue());
                    total += portfolio.getTotalValue();
                    areturn += portfolio.getAnnualReturn();
                    commissions += portfolio.getCommissions();
                    fees += portfolio.getFees();
                }
                
                summaryWriter.println("                                                              ----------------------------------------------------------------------------------------------------------------------------");
                summaryWriter.printf("                                                               Total: $%7.2f   $%15.2f  $%36.2f  $%16.2f\n\n\n", fees, commissions, areturn, total);
                summaryWriter.println("Portfolio Details");
                summaryWriter.println("============================================================================");
                
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
                    summaryWriter.println("Portfolio: " + portfolio.getPortfolioCode());
                    summaryWriter.println("------------------------------------------");
                    summaryWriter.println("Owner: " + fullOwn);
                    summaryWriter.println("Manager: " + fullMan);
                    summaryWriter.println("Beneficiary: " + fullBen);
                    Iterator<Asset> itrA = portfolio.getAssets().iterator();
                    if (itrA.hasNext()) {
                        summaryWriter.println("Assets");
                        summaryWriter.printf("%10s    %40s  %15s  %5s  %15s  %15s\n", "Code", "Asset", "Return Rate", "Risk", "Annual Return", "Total");

                        while (itrA.hasNext()) {
                            Asset asset = itrA.next();
                            summaryWriter.printf("%10s    %40s  %15.2f %5.2f  $%15.2f  $%15.2f\n", asset.getCode(), asset.getLabel(), asset.getRateOfReturn(), asset.getRisk(), asset.getAnnualReturn(), asset.getTotalValue());
                        }
                        summaryWriter.println("                                                         --------------------------------------");
                        summaryWriter.printf("                                                          Totals:        %.2f  $ %14.2f  $%15.2f", portfolio.getWeightedRisk(), portfolio.getAnnualReturn(), portfolio.getTotalValue());
                    }
                    summaryWriter.printf("\n\n\n");
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SDBDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SDBDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
