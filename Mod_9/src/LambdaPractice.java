/* FieldEntry2.java
* Module 9 Assignment 
* Name: Brittany Kyncl
* Date: 2.19.23
* Course: CSD405
* Example application of lambda expressions with comparator
*/

import java.util.*;

public class LambdaPractice {
    
    public static void main (String[] args) {

        //Creating Anonymous inner class to implement comparator interface
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        };

        //Calling method here to do something with results
        int result1 = comparator1.compare(20,30);
        System.out.println("Result 1:" + result1);
        
        //Lambda expression implementing comparator interface
        //We don't need the method name as a Lambda expressions signal the implementation of a functional interface.
        //Functional interfaces contain a single abstract method
        Comparator<Integer> comparator2 = (Integer x, Integer y) -> (x-y);

        //Calling method here to do something with results
        int result2 = comparator2.compare(20,30);
        System.out.println("Result 2:" + result2);

        //Because the JDK/JVM will automatically infer our data type we need not even type Integer type
        //Thus the lambda expressions can be simplified further to
        Comparator<Integer> comparator3 = (x, y) -> (x-y);

        //Calling method here to do something with results
        int result3 = comparator3.compare(20,30);
        System.out.println("Result 3:" + result3);

    }
}
