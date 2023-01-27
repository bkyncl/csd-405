/* Program1.java
* Module 5 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Write a program that uses an ArrayList filled with a minimum of 10 Strings. 
* Use a ‘for-each’ loop to print the ArrayList collection. Then ask a user which element 
* they would like to see again. Then, attempt printing the element in a try/catch format 
* which will result in the element being display. If the element value received is invalid,
* display a message that an Exception has been thrown displaying “Out of Bounds”. 
* In this program, include the use of Autoboxing/Auto-Unboxing, working with a user String input.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Program1 {
public static void main(String[] args) {

        //create arraylist and populate with 10 strings
        ArrayList<String> inventory = new ArrayList<String>(Arrays.asList("Apple", "Banana", "Cherry", "Durian", 
        "Elderberry", "Fig", "Grape", "Honeydew", "Iguana", "Jackfruit"));
     
        //display contents of list
        System.out.println("----------------------------------");
        System.out.println("Collection contains: ");
        for (String item : inventory) {
            System.out.println(item);
        }
        System.out.println("----------------------------------");

        //create scanner object and store user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of the element you want to see again: ");
        
        boolean valid = false;

        do {//to allow for re-entry upon exception
            try {
                String input = sc.nextLine();
                String item = itemRequest(inventory, input);//send list and input to itemRequest to return item
                System.out.println("\nItem requested: " + item);
                valid = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } 
        } while(!valid);
        sc.close();

        System.out.println();
        System.out.println("End");
    }
    public static String itemRequest(ArrayList<String> myList, String input) throws IndexOutOfBoundsException {
        // check if input is an integer
        try {
            int index = Integer.valueOf(input);//auto unboxing object integer to primitive int
            if(index >= 0 && index < myList.size()){
                return myList.get(index);// return list item by index value
            }
            else {//throw exception
                throw new IndexOutOfBoundsException("Out of Bounds");
            }
        } catch (NumberFormatException e) {
            //format exception caught if input is a string
            int index = myList.indexOf(input);// find index of string element
            if(index != -1){
                return myList.get(index);// print list item by index value
            }
            else {//throw exception
                throw new IndexOutOfBoundsException("Out of Bounds");
            }
        }
    }
}
