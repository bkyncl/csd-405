/* Program2.java
* Module 5 Assignment 
* Name: Brittany Kyncl
* Date: 1.24.23
* Course: CSD405
* Write a program to create a new file titled data.file, if the file does not exist. 
* Then write to the new file, adding 10 randomly generated numbers, or append 10 randomly 
* generated numbers to a previous file. Each integer is to be separated by a space. 
* Close the file, then reopen the file and read the data from the file and display it.
*/
import java.io.*;
import java.util.*;
public class Program2 {
    public static void main (String[] args) {

        //create new file object with specified path name
        File file = new File("data.file");

        System.out.println("-----------------------------------");
        try {
            if (!file.exists()) {
                file.createNewFile();// create file of specified path name
                System.out.println("New file successfully created");
                getFileInfo(file);// display file information
            } else { // if file exists message
                System.out.println(file +" already exists");
            }
        } catch (IOException e) {// handle errors
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        try { // attempt to write to specified file
            writeToFile(file);
            getFileInfo(file); // display file information
        } catch (IOException e) { // handle errors
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------");
        try { // attempt to read from specified file
            readFile(file);
            getFileInfo(file); // display file information
        } catch (IOException e) { // handle errors
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------");
        
    }
    // method to display file info
    private static void getFileInfo(File file) throws IOException {

        if (file.exists()) {// checks for file then displays name, path, mod date
            String message = "Name: " + file.getName()
                            + "\nPath: " + file.getPath()
                            + "\nModified Date: " + new Date(file.lastModified());
            System.out.println(message);
        } else {// not found exception
            throw new FileNotFoundException("File not Found");
        }
    }
    // method to write/append 10 random numbers to file
    private static void writeToFile(File file) throws IOException{
        //create object of random class
        Random rand = new Random();

        if (file.exists()) {// check for file
            try {
                FileWriter writer = new FileWriter(file, true); // new filewriter marked true for append
                BufferedWriter bw = new BufferedWriter(writer);
                for (int i=0; i<10; i++) {
                    int randomNum = rand.nextInt(100);
                    bw.write(randomNum + " "); //write randomnum to file
                }
                System.out.println("Successfull write to file..");
                //close file
                bw.close();
                writer.close();

            }catch (IOException e){
                throw new IOException("IOException Occured");
            }
        } else {
            throw new FileNotFoundException("File not found");
        }
    }
    // method to read file
    private static void readFile(File file) throws IOException {
        if (file.exists()) {// check for file
            try {
                Scanner reader = new Scanner(file);// new scanner object 
                System.out.println("Contents of file..");
                while (reader.hasNext()) {// read data from file
                    System.out.print(reader.next() + " ");
                }
                System.out.println();
                reader.close();// close file
            } catch (IOException e) {
                throw new IOException("IOException Occured");
            }
            
        }else {
            throw new FileNotFoundException("File not found");
        }
        
    }
}