/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdb;

/**
 *
 * @author Tevan
 */
public class broker extends person {
    Boolean isExpert;
    String secID;

    public broker(Boolean isExpert, String secID, String id, String firstName, String lastName, String address) {
        super(id, firstName, lastName, address);
        this.isExpert = isExpert;
        this.secID = secID;
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
