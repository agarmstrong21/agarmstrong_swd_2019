import java.util.Scanner;
import java.util.Random;

public class MediumTest {
    public static void main(String[] args) {
        try{

            Scanner readIn = new Scanner(System.in);
            String totalString;
            ChangeComputation given = new ChangeComputation(0,0);
            String exitTransaction = "y";
            Random rdmInt = new Random();

            ChangeComputation drawer = new ChangeComputation(0,0, rdmInt.nextInt(15),
                    rdmInt.nextInt(15), rdmInt.nextInt(15), rdmInt.nextInt(15),
                    rdmInt.nextInt(15), rdmInt.nextInt(15), rdmInt.nextInt(15),
                    rdmInt.nextInt(15) );

            System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong");

            while(exitTransaction.equals("y") || exitTransaction.equals("Y")) {

                System.out.print("Drawer: ");
                drawer.print();
                System.out.println();
                drawer.change();
                System.out.println();

                System.out.println("What is the total price of all items?");
                totalString = drawer.stringChecker(readIn.nextLine());
                drawer.totalChecker(totalString);


                System.out.println("Please enter the number of bills (20,10,5,1) and coins (.25, .10, .05, .01) " +
                        "that will be given to the cashier.");
                given.getMoney(drawer);
                drawer.addToDrawer(given);

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

                System.out.println("Start another Transaction? (Y/N)");
                exitTransaction = readIn.next();
            }
        }
        catch(Exception ex){
            System.out.println("There was an exception that occurred. Please try again.");
        }
    }
}
