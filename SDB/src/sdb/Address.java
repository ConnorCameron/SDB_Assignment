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

    //Returns the street
    public String getStreet() {
        return this.street;
    }

    //Returns the country
    public String getCountry() {
        return this.country;
    }

    //Returns the state
    public String getState() {
        return this.state;
    }

    //Returns the city
    public String getCity() {
        return this.city;
    }

    //Returns the zipCode
    public String getZipCode() {
        return this.zipCode;
    }
    
    
}
