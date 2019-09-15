import java.util.Scanner;

public class MediumTest {
    public static void main(String[] args) {
        Scanner readIn = new Scanner(System.in);
        String totalString;
        ChangeComputation total = new ChangeComputation(0, 0);
        ChangeComputation given = total;


        System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong" + " in Intro to Digital Design \n" +
                "Please enter in the total price of all the items.");
        totalString = total.stringChecker(readIn.nextLine());
        total = total.totalChecker(totalString);

        System.out.println("Please enter the number of bills (20,10,5,1) and coins (.25, .10, .05, .01) " +
                "that will be given to the cashier.");
        given.getMoney(total);

        System.out.println("Total Given:");
        total.print();
        System.out.println();

        System.out.println("Cash Given:");
        given.print();
        given.change();
        System.out.println();

        System.out.println("Change Given:");
        ChangeComputation change = total.difference(given);
        change.drawer(given);
        change.change();
    }
}
