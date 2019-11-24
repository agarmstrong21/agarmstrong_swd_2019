/*
Name: Addison Armstrong
Name of Project: S4_ChangeComputation_Medium
Name of Class: MediumTest
Class Description: These are the test in medium regarding Change Computation
 */

// Importing needed classes
import  java.util.Scanner;
import java.util.Random;

//Creating MediumTest
/**These are the test in medium regarding Change Computation*/
public class MediumTest {
    public static void main(String[] args) {
        //Try Catch to make sure the inputted strings are valid
        try{
            Scanner readIn = new Scanner(System.in);
            String totalString;
            ChangeComputation given = new ChangeComputation(0,0);
            String exitTransaction = "y"; //Exit key
            Random rdmInt = new Random();

            //Setting up random drawer

            ChangeComputation drawer = new ChangeComputation(0,0, rdmInt.nextInt(16),
                    rdmInt.nextInt(16), rdmInt.nextInt(16), rdmInt.nextInt(16),
                    rdmInt.nextInt(16), rdmInt.nextInt(16), rdmInt.nextInt(16),
                    rdmInt.nextInt(16) );

            //Starting Outputting program
            System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong");

            while(exitTransaction.equals("y") || exitTransaction.equals("Y")) {
                //Printing out Drawer
                System.out.print("Drawer: ");
                drawer.print();
                System.out.println();
                drawer.change();
                System.out.println();

                //Asking user for price
                System.out.println("What is the total price of all items?");
                totalString = drawer.stringChecker(readIn.nextLine());
                drawer.totalChecker(totalString);

                //Asking user for bills inputted
                System.out.println("Please enter the number of bills (20,10,5,1) and coins (.25, .10, .05, .01) " +
                        "that will be given to the cashier.");
                given.getMoney(drawer);
                drawer.addToDrawer(given);

                //Printing out Given, Recieved, and Change given.
                System.out.println("Total Given:");
                drawer.print();
                System.out.println();

                System.out.println("Cash Given:");
                given.print();
                given.change();
                System.out.println();

                System.out.println("Change Given:");
                ChangeComputation change = drawer.difference(given);
                change.change();

                //Exit Gate
                System.out.println("Start another Transaction? (Y/N)");
                exitTransaction = readIn.next();
            }
        }
        catch(Exception ex){
            System.out.println("There was an exception that occured. Please try again.");
        }
    }
}
