/* BrittArrayListTest.java
 * Module 4 Assignment 
 * Name: Brittany Kyncl
 * Date: 1.20.23
 * Course: CSD405
 * Create a class <yourName>ArrayListTest 
    This class is to contain:
    1. A method that receives an ArrayList populated with an Integer data type holding the integers
        received from user input.
    2. The user input is to accept Integers that are then assigned to the ArrayList until a value of
        0 is entered, which is also assigned to the ArrayList.
    3. The ArrayList is then to be sent to the method.
    4. The method is then to return the largest value in the ArrayList.
    5. If the ArrayList is sent in empty, the method will then return 0.
    6. The method signature is to be: public static Integer max (ArrayList<Integer> list). 
    7. Write additional code for testing your method
    8. The method will return the largest value that is displayed to the user.
    */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class BrittArrayListTest {
    public static void main(String[] args) {

        //User input instruction message
        System.out.println("\nPlease enter int values to be added to ArrayList.");
        System.out.println("Enter 0 to exit input.\n");

        //creating arrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num;
    
        //taking user input validating and adding to array
        try(Scanner input = new Scanner(System.in)){//create scanner obj inside try-w-resources
            do{
                num = validate(input);//sending input to validation method
                //adding user input to arraylist and ending after 0 input
                list.add(num);
            }while(num!=0);
        }

        //initialize curmax var with returned int from max method
        int curMax = max(list);
        
        //displaying output
        System.out.println();
        System.out.println("Your ArrayList contains:");
        System.out.println(list);
        System.out.printf("ArrayList max value: %d%n", curMax);
        System.out.println();
        
    }

    //method to find max of parsed collection
    public static Integer max(ArrayList<Integer> list){
        //check if arraylist is empty
        if(list.isEmpty()){
            return 0;
        }
        //loop to find max value of list
        Integer max = list.get(0);
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }
    //method to validate scanner input
    public static int validate(Scanner input) {
        int num=0;
        boolean valid = false;//set flag invalid
        while (!valid) {
            try {
                num = input.nextInt();
                valid = true;//correct int val. flag valid
            } catch (InputMismatchException e) {
                System.out.println("Please enter only an int value.");//invalid input
                input.nextLine();
            }
        }
        return num;
    }
}