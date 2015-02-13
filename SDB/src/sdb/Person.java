/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdb;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tevan
 */
public class Person {
    
    protected String id;
    protected String firstName;
    protected String lastName;
    protected Address address;
    protected Set<String> emails = new HashSet<String>();
    
    public Person(String id, String firstName, String lastName, Address address, Set<String> emails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emails = emails;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Address getAddress() {
        return this.address;
    }  
}


