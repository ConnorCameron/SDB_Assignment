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

    public Broker(Boolean isExpert, String secID, String id, String firstName, String lastName, Address address, Set<String> emails) {
        super(id, firstName, lastName, address, emails);
        this.isExpert = isExpert;
        this.secID = secID;
        this.emails = emails;
    }

    public Boolean getIsExpert() {
        return isExpert;
    }

    public void setIsExpert(Boolean isExpert) {
        this.isExpert = isExpert;
    }

    public String getSecID() {
        return secID;
    }

    public void setSecID(String secID) {
        this.secID = secID;
    }
    
}
