/* InternationalDivision.java
* Module 6 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Program with abstract Divsion object and two extended child Division classes, International and Domestic.
* Creating instances of concrete division classes and displaying.
*/
package divisionpackage;

//concrete int. div. class
public class InternationalDivision extends Division {
    private String country;
    private String language;
    
    //international div. constructor
    public InternationalDivision(String divisionName, String accountNumber, String country, String language) {
        super(divisionName, accountNumber);//invoke superclass constructor
        this.country = country;
        this.language = language;
    }
    //getters
    public String getCountry(){
        return this.country;
    }
    public String getLanguage(){
        return this.language;
    }
    //setters
    public void setCountry(String country){
        this.country = country;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    @Override
    public void display() {
        System.out.println("Int. Division: " + getDivision());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Country: " + country);
        System.out.println("Language: " + language);
        System.out.println("Date Created: " + getDate());
    }
}