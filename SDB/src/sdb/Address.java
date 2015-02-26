/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdb;

/**
 *
 * @author Connor
 */
public class Address {
    private String street;
    private String country;
    private String state;
    private String city;
    private String zipCode;

    public Address(String street, String country, String state, String city, String zipCode) {
        this.street = street;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCountry() {
        return this.country;
    }

    public String getState() {
        return this.state;
    }

    public String getCity() {
        return this.city;
    }

    public String getZipCode() {
        return this.zipCode;
    }
    
    
}
