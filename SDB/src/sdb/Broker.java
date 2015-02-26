/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdb;

import java.util.Set;

/**
 *
 * @author Tevan
 */
public class Broker extends Person {
    
    private Boolean isExpert;
    private String secID;

    //this constructs the broker
    public Broker(Boolean isExpert, String secID, String id, String firstName, String lastName, Address address, Set<String> emails) {
        super(id, firstName, lastName, address, emails);
        this.isExpert = isExpert;
        this.secID = secID;
        this.emails = emails;
    }

    //this tells if the broker is an expert or nah
    public Boolean getIsExpert() {
        return this.isExpert;
    }

    //this lets you set the broker to expert or junior
    public void setIsExpert(Boolean isExpert) {
        this.isExpert = isExpert;
    }

    //this returns the brokers SEC ID
    public String getSecID() {
        return this.secID;
    }

    //this lets you set their SEC ID
    public void setSecID(String secID) {
        this.secID = secID;
    }
    
}
