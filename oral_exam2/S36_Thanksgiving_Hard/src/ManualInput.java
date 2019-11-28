/*
Name: Addison Armstrong
Name of Project: S36_ThanksGiving_Hard
Name of Class: ManualInput
Class Description: This is a class to test the manual inputs of weight and enjoyment of each item.
Warnings: If you wish to use ManualInput class, you must run it in that class. Not here.
*/

// Importing Scanner and ArrayList tools
import java.util.ArrayList;
import java.util.Scanner;

//Creating ManualInput class that extends MaxEnjoyment class
/**Creating ManualInput class that extends MaxEnjoyment class, user will test the inputted data*/
public class ManualInput extends MaxEnjoyment {
    public static void main(String[] args){

        // Initializing the Capacity c and the Food ArrayList f.
        int c = 0;
        ArrayList<Food> f = new ArrayList<>();
        f.add(new Food("Turkey", 0, 0));
        f.add(new Food("Pie", 0,0));
        f.add(new Food("Potatoes", 0, 0));
        f.add(new Food("Gravy", 0,0));
        f.add(new Food("Stuffing", 0,0));
        f.add(new Food("Cranberries",0,0));
        f.add(new Food("Casserole", 0,0));

        // Initialing the Scanner tool
        Scanner readIn = new Scanner(System.in);

        // Printing out asking user to input all weights and enjoyments of each item individually
        System.out.println("Please enter in all of the values one at a time.");
        for(int i = 0; i < f.size(); i++){
            System.out.println(f.get(i).getName() + " Weight: ");

            //Try Catching all inputs to make sure that are castable to double.
            try {
                f.get(i).setWeight(Double.parseDouble(readIn.next()));
            }catch(IllegalArgumentException e){
                System.out.println(e.toString() + "\n Please enter in the correct type. Try again");
                System.exit(0);
            }


            System.out.println("Enjoyment: ");

            //Try Catching all inputs to make sure that are castable to double.
            try {
                f.get(i).setEnjoyment(Double.parseDouble(readIn.next()));
            }catch(IllegalArgumentException e){
                System.out.println(e.toString() + "\n Please enter in the correct type. Try again");
                System.exit(0);
            }
        }

        // Printing out asking the user to input the capacity
        System.out.println("Capacity: ");

        //Try Catching all inputs to make sure that are castable to integer.
        try {
            c = Integer.parseInt(readIn.next());
        }catch(IllegalArgumentException e){
            System.out.println(e.toString() + "\n Please enter in the correct type. Try again");
            System.exit(0);
        }

        // Printing out all items with respective values
        System.out.println("Manual Test\n----------\nInput:");
        for (Food food : f) {
            food.print();
        }
        System.out.println("Capacity = " + c + "\n\nOutput:\nOptimal enjoyment: ");

        // Runs and prints MaxEnjoyment class
        int result = MaxEnjoyment(f, c);
        System.out.print(result);
    }
}
