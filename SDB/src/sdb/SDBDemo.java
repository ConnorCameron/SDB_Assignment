/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
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
        
        Set<Person> persons = new HashSet<Person>();
        Set<Asset> assets = new HashSet<Asset>();
        
        /* TODO: Update the XML/JSON converter to be its own method if 
        needed/time allows us to*/
        try {
            Scanner s = new Scanner(new File("data/Persons.dat"));
            s.nextLine();
            /* Goes through file and tokens, splits things when needed (Address)
               Makes minor adjustments if necessary then makes the object
            */
            while(s.hasNext()) {
                String line = s.nextLine();
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

                    persons.add(client);
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
                    persons.add(bro);
                }
            }
            
            s = new Scanner(new File("Data/Assets.dat"));
            s.nextLine();
            /* Checks type and constructs necessary object */
            while(s.hasNext()) {
                String line = s.nextLine();
                String[] token = line.split(";");
                if ("D".equals(token[1])) {
                    Deposit deposit = new Deposit(Double.parseDouble(token[3]), token[0], token[1]);
                    assets.add(deposit);
                } else if ("S".equals(token[1])) {
                    Stock stock = new Stock(Double.parseDouble(token[3]), Double.parseDouble(token[4]), Double.parseDouble(token[5]), token[6], Double.parseDouble(token[7]), token[0], token[1]);
                    assets.add(stock);
                } else if ("P".equals(token[1])) {
                    PrivateInvestment pi = new PrivateInvestment(Double.parseDouble(token[3]), Double.parseDouble(token[4]), Double.parseDouble(token[5]), Double.parseDouble(token[6]), token[0], token[1]);
                    assets.add(pi);
                }
            }
            
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found...");
            Logger.getLogger(SDBDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /* Xstream and Gson setup for person and assets, then prints them out */
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        XStream xstream = new XStream(new DomDriver());
        
        xstream.alias("person", Person.class);
        xstream.alias("person", Broker.class);
        xstream.alias("persons", Set.class);
        
        String json = gson.toJson(persons);
        String xml = xstream.toXML(persons);
        
        try {
            PrintWriter personWriterJSON = new PrintWriter("data/Person.json", "UTF-8");
            PrintWriter personWriterXML = new PrintWriter("data/Person.xml", "UTF-8");
            PrintWriter assetWriterJSON = new PrintWriter("data/Asset.json", "UTF-8");
            PrintWriter assetWriterXML = new PrintWriter("data/Asset.xml", "UTF-8");
            
            personWriterJSON.println(json);
            personWriterXML.println(xml);
        
            xstream.alias("assets", Set.class);
            xstream.alias("asset", Asset.class);
            xstream.alias("asset", Deposit.class);
            xstream.alias("asset", Stock.class);
            xstream.alias("asset", PrivateInvestment.class);

            json = gson.toJson(assets);
            xml = xstream.toXML(assets);
            assetWriterJSON.println(json);
            assetWriterXML.println(xml);
            
            personWriterJSON.close();
            personWriterXML.close();
            assetWriterJSON.close();
            assetWriterXML.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found...");
            Logger.getLogger(SDBDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding not supported...");
            Logger.getLogger(SDBDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
