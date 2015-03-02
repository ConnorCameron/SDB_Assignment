/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Andrew
 */
public class DataConverter {
    
    private static DataConverter instance;
    private final String path = "./data/";
    
    //constructor
    private DataConverter() {
    }
    
    //Lazy loading the dataconverter
    public static DataConverter getInstance() {
        if (instance == null) {
            instance = new DataConverter();
        }
        return instance;
    }
    
    //Opening the ifle
    public Scanner openFile(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path + fileName));
        s.nextLine();
        return s;
    }
    
    //Setting up and returning the set of persons
    public Set<Person> processPersons(String fileName) {
        Set<Person> persons = new HashSet<Person>();
        Scanner s;
        try {
            s = openFile(fileName);
            while (s.hasNext()) {
                Person person = processPerson(s.nextLine());
                persons.add(person);
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found...");
        }
        
        return persons;
    }
    
    //Setting up an dreturning the set of assets
    public Set<Asset> processAssets(String fileName) {
        Set<Asset> assets = new HashSet<Asset>();
        Scanner s;
        try {
            s = openFile(fileName);
            while (s.hasNext()) {
                Asset asset = processAsset(s.nextLine());
                assets.add(asset);
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found...");
        }
        return assets;
    }
    
    //setting up and returning a set of portfolios
    public Set<Portfolio> processPortfolios(String fileName, Set<Asset> assets, Set<Person> persons) {
        Set<Portfolio> portfolios = new HashSet<Portfolio>();
        Scanner s;
        try {
            s = openFile(fileName);
            while (s.hasNext()) {
                Portfolio portfolio = processPortfolio(s.nextLine(), assets, persons);
                portfolios.add(portfolio);
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found...");
        }
        return portfolios;
    }
    
    //Going through a line of text input and tokenizing it and constructing a Person, and returning it for the processPersons method
    private Person processPerson(String line) {
        String[] token = line.split(";");
                if (token[1].isEmpty()) {
                    String [] name = token[2].split(",");
                    String fName = name[1].trim();
                    String lName = name[0].trim();

                    String [] Address = token[3].split(",");
                    Address ad = new Address(Address[0].trim(), Address[4].trim(), Address[1].trim(), Address[2].trim(), Address[3].trim());
                    
                    Set<String> setmails = new HashSet<String>();
                    
                    if(token.length >= 5) {
                        String [] Emails = token[4].split(",");

                        for(String element : Emails) {
                            setmails.add(element);
                        }
                    }

                    Person client = new Person(token[0], fName, lName, ad, setmails);

                    return client;
                } else {
                    String [] broker = token[1].split(",");
                    Boolean isExpert = false;
                    if ("E".equals(broker[0])) {
                        isExpert = true;
                    }
                    String ident = broker[1];

                    String [] name = token[2].split(",");
                    String fName = name[1].trim();
                    String lName = name[0].trim();

                    String [] Address = token[3].split(",");
                    Address ad = new Address(Address[0].trim(), Address[4].trim(), Address[1].trim(), Address[2].trim(), Address[3].trim());
                    Set<String> setmails = new HashSet<String>();
                    if(token.length >= 5) {
                        String [] Emails = token[4].split(",");
                        setmails.addAll(Arrays.asList(Emails));
                    }

                    Broker bro = new Broker(isExpert, ident, token[0], fName, lName, ad, setmails);
                    return bro;
                }
    }
    
        //Going through a line of text input and tokenizing it and constructing a Asset, and returning it for the processAssets method
    private Asset processAsset(String line) {
        String[] token = line.split(";");
                if ("D".equals(token[1])) {
                    Deposit deposit = new Deposit(token[0], token[2], Double.parseDouble(token[3]), 0.0);
                    return deposit;
                } else if ("S".equals(token[1])) {
                    Stock stock = new Stock(Double.parseDouble(token[3]), token[6], Double.parseDouble(token[7]), token[0], token[2], Double.parseDouble(token[4]) , Double.parseDouble(token[5]));
                    return stock;
                } else if ("P".equals(token[1])) {
                    PrivateInvestment pi = new PrivateInvestment(Double.parseDouble(token[3]), Double.parseDouble(token[6]), token[0], token[2], Double.parseDouble(token[4]), Double.parseDouble(token[5]));
                    return pi;
                }
        return null;
    }
    
    //Going through a lien of text input and tokenizing it to construct a portfolio
    private Portfolio processPortfolio(String line, Set<Asset> assets, Set<Person> persons) {
        String [] token = line.split(";");
        String portCode = token[0];
        Person owner = Person.findPerson(token[1], persons);
        Person broker = Person.findPerson(token[2], persons);
        Person benefit;
        if (token.length > 3) {
            if (token[3].isEmpty()) {
                benefit = null;
            } else {
                benefit = Person.findPerson(token[3], persons);
            }
            Portfolio portfolio = new Portfolio((Broker) broker, benefit, owner, portCode);
            if (token.length > 4) {
                String [] tokenAssets = token[4].split(",");

                for(int i = 0; i < tokenAssets.length; i++) {
                    String [] tokenAsset = tokenAssets[i].split(":");
                    Asset asset = Asset.findAsset(tokenAsset[0], assets);
                    String type = asset.getType();
                    if (type.equals("D")) {
                        Deposit deposit = (Deposit) asset;
                        deposit.addBalance(portCode, Double.parseDouble(tokenAsset[1]));
                        portfolio.addAsset(deposit);
                    } else if (type.equals("S")) {
                        Stock stock = (Stock) asset;
                        stock.addNumOfStocks(portCode, Double.parseDouble(tokenAsset[1]));
                        portfolio.addAsset(stock);
                    } else if (type.equals("P")) {
                        PrivateInvestment pi = (PrivateInvestment) asset;
                        pi.setStake(Double.parseDouble(tokenAsset[1]));
                        portfolio.addAsset(pi);
                    }
                }
            }
            return portfolio;
        } else {
            Portfolio portfolio = new Portfolio((Broker) broker, null, owner, portCode);
            return portfolio;
        }
        
    }
    
    
}
