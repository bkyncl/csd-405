/*Division.java
* Module 6 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Program with abstract Divsion object and two extended child Division classes, International and Domestic.
* Creating instances of concrete division classes and displaying.
*/
package divisionpackage;
import java.util.*;
//abstract class for division
abstract class Division {
    private String divisionName;
    private String accountNumber;
    private final Date dateCreated;
    
    //abstract division constructor
    Division(String divisionName, String accountNumber) {
        this.dateCreated = new Date();
        this.divisionName = divisionName;
        this.accountNumber = accountNumber;
    }
    // getters
    public String getDivision(){
        return this.divisionName;
    }
    public String getAccountNumber() {
        return this.accountNumber;

    }
    public Date getDate() {
        return this.dateCreated;
    }
    //setters
    public void setDivision(String divisionName){
        this.divisionName = divisionName;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    //abstract division display method
    public abstract void display();
}