/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdb;

import java.util.HashSet;
import java.util.Iterator;
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
    
    //this constructs the person
    public Person(String id, String firstName, String lastName, Address address, Set<String> emails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emails = emails;
    }

    //this returns the persons ID
    public String getId() {
        return this.id;
    }

    //this returns the persons first name
    public String getFirstName() {
        return this.firstName;
    }
    
    //thhis returns the persons last name
    public String getLastName() {
        return this.lastName;
    }

    //this returns the persons address
    public Address getAddress() {
        return this.address;
    }  
    
    //Finds a person based on alphanumeric code
    public static Person findPerson(String code, Set<Person> persons) {
        Iterator<Person> itr = persons.iterator();
        while (itr.hasNext()) {
            Person person = itr.next();
            if (person.getId().equals(code)) {
                return person;
            }
        }
        return null;
    }
}


