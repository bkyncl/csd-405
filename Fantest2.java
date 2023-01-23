/* Fantest_2.java
 * Module 2 Assignment 
 * Name: Brittany Kyncl
 * Date: 1.6.23
 * Course: CSD405
 * OOP FAN
 */
import java.util.*;
public class Fantest2 {
    public static void main(String[] args){

        //creation 2 Fan instances obj(Fan.SPEED,ON/OFF,RADIUS,COLOR)
        Fan fanObj1 = new Fan();
        Fan fanObj2 = new Fan(Fan.FAST, true, 10, "yellow");

        //object status
        System.out.println("-------------Fan Objects-------------");
        System.out.println("Fan 1\n" + fanObj1);
        System.out.println("Fan 2\n" + fanObj2);

        // testing Fan method functionality
        System.out.println("-------------Fan Objects New Setting-------------");
        fanObj1.setOn(true);
        fanObj1.setSpeed(2);
        fanObj1.setRadius(5);
        System.out.println("Fan 1 changed to:\n" + fanObj1);

        // testing Fan method functionality
        fanObj2.setOn(false);
        fanObj2.setSpeed(0);
        fanObj2.setColor("blue");
        System.out.println("Fan 2 changed to:\n" + fanObj2);

        // creating a collection of fans
        ArrayList<Fan> fansList = new ArrayList<>();
        
        // adding all fan objects into collection
        fansList.add(fanObj1);
        fansList.add(fanObj2);
        fansList.add(new Fan(Fan.SLOW, true, 7, "red"));
        fansList.add(new Fan(Fan.MEDIUM, true, 4, "orange"));
        fansList.add(new Fan(Fan.STOPPED, false, 11, "black"));
        fansList.add(new Fan(Fan.FAST, true, 8, "green"));   

        // passing list of fan instances to UseFans constructor
        UseFans useFans = new UseFans(fansList);

        System.out.println("-------------Fan Objects-------------");
        useFans.displayFans(); // displaying all fan objects in collection using UseFan class method

        // testing functionality of changing objects in collection
        fansList.get(3).setOn(true);
        fansList.get(3).setSpeed(3);
        fansList.get(3).setRadius(8);
        fansList.get(3).setColor("purple");

        fansList.get(4).setOn(true);
        fansList.get(4).setSpeed(2);
        fansList.get(4).setRadius(3);
        fansList.get(4).setColor("tie dye");

        System.out.println("-------------Fan Objects New Setting-------------");
        System.out.println("Fan 4 changed to:");
        useFans.displayFan(fansList.get(3)); //using displayFan method from UseFans class 
        System.out.println("Fan 5 changed to:");
        useFans.displayFan(fansList.get(4)); //using displayFan method from UseFans class 

        // for loop to turn all fans off
        for(int i= 0; i < fansList.size(); i++){
            fansList.get(i).setOn(false);
            fansList.get(i).setSpeed(0);
        }

        System.out.println("-------------Turning All Fans Off-------------");
        useFans.displayFans();

        // for loop to turn all fans on power level 1
        for(int i= 0; i < fansList.size(); i++){
            fansList.get(i).setOn(true);
            fansList.get(i).setSpeed(1);
        }

        System.out.println("-------------Turning All Fans On Power Low-------------");
        useFans.displayFans();
    }
}
class UseFans{ // UseFans class

    // fan collection
    List<Fan> fans;

    // UseFans constructor
    public UseFans(List<Fan> fans){
        this.fans = fans;
    }

    //method to take fans collection and display the details
    public void displayFans(){
        for(Fan f : fans){
            displayFan(f);
        }

    }

    //method which take single instance of fan and display details
    public void displayFan(Fan fan){
        String status = fan.isOn() ? "Fan is on\n": "Fan is off\n";
        System.out.println("Speed: " + fan.getSpeed()+ "\n" + "Color: " + fan.getColor() + "\n" + "Radius: " + fan.getRadius() + "\n" + status);
    }
 
}
class Fan{ // our fan class

    //constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    //private fields
    private int speed = STOPPED;
    private boolean on = false;
    private double radius = 6;
    private String color = "white";

    //default value constructor
    public Fan(){
    }

    //argument constructor
    public Fan(int speed, boolean on, double radius, String color){
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    //getters and setters
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public boolean isOn(){
        return this.on;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    
    @Override
    public String toString(){
        
        String status = "Speed: " + this.speed + "\n";
        status += "Color: " + this.color + "\n";
        status += "Radius: " + this.radius + "\n";
        status += this.on ? "Fan is on\n": "Fan is off\n";
        return status;
    }
}
