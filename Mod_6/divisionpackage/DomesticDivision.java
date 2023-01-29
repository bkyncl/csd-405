/* DomesticDivision.java
* Module 6 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Program with abstract Divsion object and two extended child Division classes, International and Domestic.
* Creating instances of concrete division classes and displaying.
*/
package divisionpackage;

//concrete dom. div. class
public class DomesticDivision extends Division {
    private String state;
    
    //dom div. contstructor 
    public DomesticDivision(String divisionName, String accountNumber, String state) {
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
