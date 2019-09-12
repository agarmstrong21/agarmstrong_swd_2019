import org.graalvm.compiler.replacements.nodes.arithmetic.IntegerAddExactNode;

import java.util.Scanner;

public class Easy {

    private int dollars;
    private int cents;

    private Easy(int d, int c) {
        this.dollars = d;
        this.cents = c;
    }

    public static void main(String[] args){
        Scanner readIn = new Scanner(System.in);
        String totalString;
        String givenString;
        Easy total = new Easy(0,0);
        Easy given = total;



        System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong" +
                " in Intro to Digital Design \n" +
                "Please enter in the total price of all the items.");
        totalString = readIn.nextLine();
        total = totalChecker(totalString);

        System.out.println("Please enter the bills and the cents that is given to the cashier.");
        while(total.dollars > given.dollars || !(total.dollars == given.dollars && total.cents < given.cents)) {
            givenString = readIn.nextLine();
            if(givenString.contains(".")){

            }
            given = totalChecker(givenString);
        }

        if(total.cents < 10){
            System.out.println("Total: " + total.dollars + ".0" + total.cents);
        }
        else{
            System.out.println("Total: " + total.dollars + "." + total.cents);
        }

        if(given.cents < 10){
            System.out.println("Cash Given: " + given.dollars + ".0" + given.cents);
        }
        else{
            System.out.println("Cash Given: " + given.dollars + "." + given.cents);
        }

        given = difference(total, given);

        if(given.cents < 10){
            System.out.println("Change Given: " + given.dollars + ".0" + given.cents);
        }
        else{
            System.out.println("Change Given: " + given.dollars + "." + given.cents);
        }
        change(given);
    }
    private static Easy totalChecker(String check){
        Easy checkTotal = new Easy(0,0);
        Scanner readIn = new Scanner(System.in);

        if(check.contains(".")) {
            String[] checkSplit = check.split("\\.");

            checkTotal.dollars = Integer.parseInt(checkSplit[0]);
            checkTotal.cents = Integer.parseInt(checkSplit[1]);
            while (checkTotal.cents > 99 || checkTotal.cents < 0
                    || checkTotal.dollars < 0)  {
                System.out.println("Please re-enter a new total");
                check = readIn.nextLine();
                if (check.contains(".")) {
                    checkSplit = check.split("\\.");

                    checkTotal.dollars = Integer.parseInt(checkSplit[0]);
                    checkTotal.cents = Integer.parseInt(checkSplit[1]);

                } else{
                    checkTotal.dollars = Integer.parseInt(check);
                    checkTotal.cents = 0;
                }
            }
        } else{
            checkTotal.dollars = Integer.parseInt(check);
        }
        return checkTotal;
    }

    private static int givenChecker(String check){
        Scanner readIn = new Scanner(System.in);
        int[] centArray = new int[] {25, 10, 5, 1};
        int[] dollarArray = new int[] {20,10,5,1};
        boolean temp = false;

        if(!check.contains(".")){
            while(temp) {
                for (int i = 1; i < dollarArray.length; i++) {
                    if (dollarArray[i] == Integer.parseInt(check)) {
                        return Integer.parseInt(check);
                    }
                }
                System.out.println("Sorry but that is not a valid bill. Please enter a correct bill");
                check = readIn.nextLine();
            }
        }
        else{
            while(temp){
                for(int i = 1; i < centArray.length; i++){
                    if(centArray[i] == 25 || centArray[i] == 10){
                        if(centArray[i] == Integer.parseInt(check)){
                            return Integer.parseInt(check);
                        }
                    }
                    else{
                        if(centArray[i] ==  )

                    }
                }
                System.out.println("Sorry but that is not a valid coin. Please enter a correct coin");
                check = readIn.nextLine();
            }
        }


    }

    private static Easy difference(Easy total, Easy given){
        Scanner readIn = new Scanner(System.in);
        String cash;

        while(total.dollars > given.dollars ||
                (total.dollars == given.dollars && total.cents > given.cents)){
            System.out.println("You did not give enough to pay for the total." +
                    "\n Please enter in cash given.");
            cash = readIn.nextLine();
            given = totalChecker(cash);
        }

        if(given.cents < total.cents){
            given.dollars--;
            given.cents += 100;
        }

        given.dollars -= total.dollars;
        given.cents -= total.cents;

        return given;
    }

    private static void change(Easy change){
        int temp = 0;
        int[] dollarArray = new int[]{20,10,5,1};
        int[] centArray = new int[]{25,10,5,1};

        for(int i = 0; i < 4 ; i++){
            temp = change.dollars/dollarArray[i];
            System.out.println(dollarArray[i] + "'s: " + temp);
            change.dollars -= temp*dollarArray[i];
        }

        for(int i = 0; i < 4 ; i++){
            temp = change.cents/centArray[i];
            System.out.println("." + centArray[i] + "'s: " + temp);
            change.cents -= temp*centArray[i];
        }
    }
}
