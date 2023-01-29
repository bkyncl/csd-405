/* UseDivision.java
* Module 6 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Program with abstract Divsion object and two extended child Division classes, International and Domestic.
* Creating instances of concrete division classes and displaying.
*/

import divisionpackage.*;
public class UseDivision {
    public static void main(String[] args) {
        
        InternationalDivision intDiv1 = new InternationalDivision("Global Trade Consult.", "12345", "France", "French");
        InternationalDivision intDiv2 = new InternationalDivision("Cross Cultural Relations", "789101", "Germany", "German");
        DomesticDivision domDiv1 = new DomesticDivision("Systems Administration", "0256", "California");
        DomesticDivision domDiv2 = new DomesticDivision("Financial Consulting", "141516", "New York");
        System.out.println("---------------------------------");
        intDiv1.display();
        System.out.println("---------------------------------");
        intDiv2.display();
        System.out.println("---------------------------------");
        domDiv1.display();
        System.out.println("---------------------------------");
        domDiv2.display();
        System.out.println("---------------------------------");

        intDiv1.setAccountNumber("123456");
        intDiv2.setAccountNumber("000");
        domDiv1.setAccountNumber("000256");
        domDiv2.setAccountNumber("000");

        intDiv1.setDivision("Int. Div.");
        intDiv2.setDivision("Int. Div.");
        domDiv1.setDivision("Dom. Div.");
        domDiv2.setDivision("Dom. Div.");

        intDiv1.setLanguage("null");
        intDiv2.setCountry("null");
        domDiv1.setState("Texas");
        domDiv2.setState("California");


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