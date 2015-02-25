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
        
        Set<Person> persons;
        Set<Asset> assets;
        
        
        //Calls DataConverter
        DataConverter converter = DataConverter.getInstance();
        
        //Calls the dataconverter
        persons = converter.processPersons("Persons.dat");
        assets = converter.processAssets("Assets.dat");
        
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
