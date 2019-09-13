import java.util.Scanner;

public class Easy2 {

    private int dollars, cents, twenties, tens, fives, ones,
            quarters, dimes, nickels, pennies;

    private Easy2(int d, int c) {
        this.dollars = d;
        this.cents = c;
        this.twenties = 0;
        this.tens = 0;
        this.fives = 0;
        this.ones = 0;
        this.quarters = 0;
        this.dimes = 0;
        this.nickels = 0;
        this.pennies = 0;
    }

    public static void main(String[] args){
        Scanner readIn = new Scanner(System.in);
        String totalString;
        String givenString;
        Easy2 total = new Easy2(0,0);
        Easy2 given = total;


        System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong" +
                " in Intro to Digital Design \n" +
                "Please enter in the total price of all the items.");
        totalString = readIn.nextLine();
        total = totalChecker(totalString);

        System.out.println("Please enter the number of bills (20,10,5,1) and coins (.25, .10, .05, .01) " +
                "that will be given to the cashier.");
        while(total.dollars > given.dollars || (total.dollars == given.dollars && total.cents > given.cents)){
            given.dollars  = given.cents = 0;
            given.twenties = given.tens = given.fives = given.ones = 0;
            given.quarters = given.dimes = given.nickels = given.pennies = 0;

            System.out.print("20's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.twenties += Integer.parseInt(givenString);
                given.dollars += 20*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print("10's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.tens += Integer.parseInt(givenString);
                given.dollars += 10*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print("5's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.fives += Integer.parseInt(givenString);
                given.dollars += 5*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print("1's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.ones += Integer.parseInt(givenString);
                given.dollars += Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print(".25's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.quarters += Integer.parseInt(givenString);
                given.cents += 25*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print(".10's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.dimes += Integer.parseInt(givenString);
                given.cents += 10*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print(".05's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.nickels += Integer.parseInt(givenString);
                given.cents += 5*Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            System.out.print(".01's: ");
            givenString = readIn.nextLine();
            if(!givenString.contains("-") && !givenString.contains(".")){
                given.pennies += Integer.parseInt(givenString);
                given.cents += Integer.parseInt(givenString);
                condense(given);
                print(given);
            }

            if(total.dollars > given.dollars || (total.dollars == given.dollars && total.cents > given.cents)){
                System.out.println("You did not provide enough change. Please enter a new amount.");
            }
        }



        System.out.println("Total Given:");
        print(total);

        System.out.println("Cash Given:");
        print(given);
        change(given);

        Easy2 change = difference(total, given);

        System.out.println("Change Given:");
        print(change);
        change(change);
    }
    private static Easy2 totalChecker(String check) {
        Easy2 checkTotal = new Easy2(0, 0);
        Scanner readIn = new Scanner(System.in);
        boolean temp = true;

        while (temp) {
            if (!check.contains("-")) {
                if (check.contains(".")) {
                    String[] checkSplit = check.split("\\.");
                    if(Integer.parseInt(checkSplit[1]) <100) {
                        checkTotal.dollars = Integer.parseInt(0 + checkSplit[0]);
                        checkTotal.cents = Integer.parseInt(checkSplit[1]);
                        temp = false;
                    }
                } else {
                    checkTotal.dollars = Integer.parseInt(check);
                    checkTotal.cents = 0;
                    temp = false;
                }
            }
            if (temp) {
                System.out.println("Sorry but that is not a valid total. Please enter a correct total");
                check = readIn.nextLine();
            }
        }
        return checkTotal;
    }

    private static Easy2 difference(Easy2 total, Easy2 given){
        int temp;
        Easy2 tempGiven;

        if(given.cents < total.cents){
            given.dollars--;
            given.cents += 100;
        }

        given.dollars -= total.dollars;
        given.cents -= total.cents;
        given.twenties = given.tens = given.fives = given.ones = 0;
        given.quarters = given.dimes = given.nickels = given.pennies = 0;
        tempGiven = given;

        if(tempGiven.dollars/20 > 0){
            temp = tempGiven.dollars/20;
            tempGiven.dollars -= temp*20;
            given.twenties += temp;
        }
        if(tempGiven.dollars/10 > 0){
            temp = tempGiven.dollars/10;
            tempGiven.dollars-= temp*10;
            given.tens += temp;
        }
        if(tempGiven.dollars/5 > 0){
            temp = tempGiven.dollars/5;
            tempGiven.dollars -= temp*5;
            given.fives += temp;
        }
        if(tempGiven.dollars > 0){
            temp = tempGiven.dollars;
            tempGiven.dollars -= temp;
            given.ones += temp;
        }
        if(tempGiven.cents/25 > 0){
            temp = tempGiven.cents/25;
            tempGiven.cents -= temp*25;
            given.quarters += temp;
        }
        if(tempGiven.cents/10 > 0){
            temp = tempGiven.cents/10;
            tempGiven.cents -= temp*10;
            given.dimes += temp;
        }
        if(tempGiven.cents/5 > 0){
            temp = tempGiven.cents/5;
            tempGiven.cents -= temp*5;
            given.nickels += temp;
        }
        if(tempGiven.cents > 0){
            temp = tempGiven.cents;
            tempGiven.cents -= temp;
            given.pennies += temp;
        }

        return given;
    }

    private static Easy2 condense(Easy2 given){
        while(given.cents > 100){
            given.dollars += 1;
            given.cents -= 100;
        }
        return given;
    }
    private static void print(Easy2 printed){
        if(printed.cents < 10){
            System.out.println(printed.dollars + ".0" + printed.cents);
        }
        else{
            System.out.println( printed.dollars + "." + printed.cents);
        }
    }

    private static void change(Easy2 given){
        System.out.println("20's: " + given.twenties);
        System.out.println("10's: " + given.tens);
        System.out.println("5's: " + given.fives);
        System.out.println("1's: " + given.ones);
        System.out.println(".25's: " + given.quarters);
        System.out.println(".10's: " + given.dimes);
        System.out.println(".05's: " + given.nickels);
        System.out.println(".01's: " + given.pennies);
    }

}
