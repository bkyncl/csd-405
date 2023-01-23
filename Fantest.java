/* Fantest.java
 * Module 1 Assignment 
 * Name: Brittany Kyncl
 * Date: 1.6.23
 * Course: CSD405
 * OOP FAN
 */

public class Fantest {
    public static void main(String[] args){

        System.out.println(BrittInteger.isPrime(3251));

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

        // testing Fan class method functionality
        fanObj2.setOn(false);
        fanObj2.setSpeed(0);
        fanObj2.setColor("blue");
        System.out.println("Fan 2 changed to:\n" + fanObj2);
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
