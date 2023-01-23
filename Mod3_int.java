/* Mod3_int.java
 * Module 3 Assignment 
 * Name: Brittany Kyncl
 * Date: 1.14.23
 * Course: CSD405
 * Create a class titled Integer.  Examples:
    AnnaInteger
    LarryInteger
    SueInteger
    Etc.

    This class is to contain:
    1. An int data field titled with your first name.
    2. A constructor that takes and sets the initial value.
    3. Getter and setter methods.
    4. Non-Static methods titled isEven(), isOdd(), and isPrime() returning true or false based on the variable’s value.
    5. Static methods with signatures isEven(int), isOdd(int), and isPrime(int) with the same basic logic as the previous methods with results based on the parameter.
    6. Static methods with signatures isEven( Integer), isOdd( Integer), and isPrime( Integer) with the same basic logic as the previous methods with results based on the parameter.
    7. The methods equals(int) and equals( Integer) which returns true if int values are equal and false if they are not.
    8. Write test code that creates three instances, two with the same value, and one with a different value.
    8. Write test code that ensures all methods function correctly.
    */
public class Mod3_int {
    public static void main(String[] args) {
        //create 3 intstances of BrittInteger, two with same value, one with diff value
        BrittInteger myInteger1 = new BrittInteger(5);
        BrittInteger myInteger2 = new BrittInteger(5);
        BrittInteger myInteger3 = new BrittInteger(6);

        //test instance methods
        System.out.println("\nmyInteger1:"); 
        System.out.println("isEven: " + myInteger1.isEven());
        System.out.println("isOdd: " + myInteger1.isOdd());
        System.out.println("isPrime: " + myInteger1.isPrime());
        System.out.println("\nmyInteger2:");
        System.out.println("isEven: " + myInteger2.isEven());
        System.out.println("isOdd: " + myInteger2.isOdd());
        System.out.println("isPrime: " + myInteger2.isPrime());
        System.out.println("\nmyInteger3:");
        System.out.println("isEven: " + myInteger3.isEven());
        System.out.println("isOdd: " + myInteger3.isOdd());
        System.out.println("isPrime: " + myInteger3.isPrime());

        //test static int paremeter methods
        System.out.println();
        System.out.println("4 is even: " + BrittInteger.isEven(4));
        System.out.println("15 is odd: " + BrittInteger.isOdd(15));
        System.out.println("352 is prime: " + BrittInteger.isPrime(352));

        //test static object parameter methods
        System.out.println();
        System.out.println("New BrittInteger object (15) is even: " + BrittInteger.isEven(new BrittInteger(15)));
        System.out.println("New BrittInteger object (23) is odd: " +BrittInteger.isOdd(new BrittInteger(23)));
        System.out.println("New BrittInteger object (127) is prime: " +BrittInteger.isPrime(new BrittInteger(127)));

        //test equals(int) and equals(BrittInteger)
        System.out.println();
        System.out.println("myInteger3 = 6: " + myInteger3.equals(6));
        System.out.println("myInteger2 = 6: " + myInteger2.equals(6));
        System.out.println("myInteger1 = myInteger2: " + myInteger1.equals(myInteger2));
        System.out.println("myInteger2 = myInteger3: " + myInteger2.equals(myInteger3));

    }
}
//BrittInteger class
class BrittInteger {
    //attribute
    private int brittany;

    //constructor accepts an int to initialize the value
    public BrittInteger(int brittany) {
        this.brittany = brittany;
    }

    //getter and setter for value
    public int getValue() {
        return brittany;
    }
    public void setValue(int brittany) {
        this.brittany = brittany;
    }

    //intance method that returns true if the passed int is even
    public boolean isEven() {
        return brittany % 2 == 0;
    }

    //instance method that returns true if the passed int is odd
    public boolean isOdd() {
        return brittany % 2 != 0;
    }

    //instance method that returns true if the passed int is prime
    public boolean isPrime() {
        //check if below 2
        if (brittany <= 1) {
            return false;
        }
        //loop from 2 to value to check if value is divisible by any number
        for (int i=2; i<brittany; i++) {
            //if value is divisible by i, it is not prime
            if (brittany % i == 0) {
                return false;
            }
        }
        //if value is not divisible by any number, it is prime
        return true;
    }

    //static method that returns true if the value stored is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    //static method that returns true if the value stored is odd
    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    //static method that returns true if the value stored is prime
    public static boolean isPrime(int num) {
        //check if below 2
        if (num <= 1) {
            return false;
        }
        //loop from 2 to value to check if value is divisible by any number
        for (int i=2; i<num; i++) {
            //if value is divisible by i, it is not prime
            if (num % i == 0) {
                return false;
            }
        }
        //if value is not divisible by any number, it is prime
        return true;
    }

    //static method that returns true if the passed object is even
    public static boolean isEven(BrittInteger brittany) {
        return brittany.brittany % 2 == 0;
    }

    //static method that returns true if the passed obejct is odd
    public static boolean isOdd(BrittInteger brittany) {
        return brittany.brittany % 2 != 0;
    }

    //static method that returns true if the passed object is prime
    public static boolean isPrime(BrittInteger brittany) {
        int num = brittany.brittany;
        //check if below 2
        if (num <= 1) {
            return false;
        }
        //loop from 2 to value to check if value is divisible by any number
        for (int i=2; i<num; i++) {
            //if value is divisible by i, it is not prime
            if (num % i == 0) {
                return false;
            }
        }
        //if value is not divisible by any number, it is prime
        return true;
    }

    //instance method that returns true if the passed int is equal to the value stored
    public boolean equals(int num) {
        return this.brittany == num;
    }

    //instance method that returns true if the passed object is equal to the value stored
    public boolean equals(BrittInteger brittany) {
        return this.brittany == brittany.brittany;
    }
}