/* UseDivision.java
* Module 6 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Program with abstract Divsion object and two extended child Division classes, International and Domestic.
* Creating instances of concrete division classes and displaying.
*/
import java.util.*;
public class UseDivision {
    public static void main(String[] args) {
        InternationalDivision intDiv1 = new InternationalDivision("Global Trade Consult.", 12345, "France", "French");
        InternationalDivision intDiv2 = new InternationalDivision("Cross Cultural Relations", 789101, "Germany", "German");
        DomesticDivision domDiv1 = new DomesticDivision("Systems Administration", 111213, "California");
        DomesticDivision domDiv2 = new DomesticDivision("Financial Consulting", 141516, "New York");
        System.out.println("---------------------------------");
        intDiv1.display();
        System.out.println("---------------------------------");
        intDiv2.display();
        System.out.println("---------------------------------");
        domDiv1.display();
        System.out.println("---------------------------------");
        domDiv2.display();
        System.out.println("---------------------------------");

        intDiv1.setDivision("TEST");
        intDiv2.setAccountNumber(00000);
        intDiv2.setLanguage("Test Lang");
        domDiv1.setState("TEST");
        domDiv2.setAccountNumber(0000);

        System.out.println("---------------------------------");
        intDiv1.display();
        System.out.println("---------------------------------");
        intDiv2.display();
        System.out.println("---------------------------------");
        domDiv1.display();
        System.out.println("---------------------------------");
        domDiv2.display();
        System.out.println("---------------------------------");
    }
}
//abstract class for division
abstract class Division {
    private String divisionName;
    private int accountNumber;
    private final Date dateCreated;
    
    //abstract division constructor
    Division(String divisionName, int accountNumber) {
        this.dateCreated = new Date();
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }
    // getters
    protected String getDivision(){
        return this.divisionName;
    }
    protected int getAccountNumber() {
        return this.accountNumber;

    }
    protected Date getDate() {
        return this.dateCreated;

    }
    //setters
    protected void setDivision(String divisionName){
        this.divisionName = divisionName;
    }
    protected void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    //abstract division display method
    public abstract void display();
}
//concrete int. div. class
class InternationalDivision extends Division {
    private String country;
    private String language;
    
    //international div. constructor
    InternationalDivision(String divisionName, int accountNumber, String country, String language) {
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
//concrete dom. div. class
class DomesticDivision extends Division {
    private String state;
    
    //dom div. contstructor 
    DomesticDivision(String divisionName, int accountNumber, String state) {
        super(divisionName, accountNumber);//invoke superclass constructor
        this.state = state;
    }
    //getter
    public String getState() {
        return this.state;
    }
    //setter
    public void setState(String state){
        this.state = state;
    }
    @Override
    public void display() {
        System.out.println("Dom. Division: " + getDivision());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("State: " + state);
        System.out.println("Date Created: " + getDate());
    }
}