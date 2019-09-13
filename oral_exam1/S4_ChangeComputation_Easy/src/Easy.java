
import java.util.Scanner;

public class Easy {

    private int dollars, cents, twenties, tens, fives, ones,
            quarters, dimes, nickels, pennies;

    private Easy(int d, int c) {
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
        Easy total = new Easy(0,0);
        Easy given = total;


        System.out.println("Welcome to S4_ChangeComputation Made by Addison Armstrong" +
                " in Intro to Digital Design \n" +
                "Please enter in the total price of all the items.");
        totalString = readIn.nextLine();
        total = totalChecker(totalString);

        System.out.println("Please enter the bills (20,10,5,1) and coins (.25, .10, .05, .01) " +
                "that will be given to the cashier.");
        while(total.dollars > given.dollars || (total.dollars == given.dollars && total.cents > given.cents)){
            givenString = readIn.nextLine();
            given = givenChecker(givenString, given);
            given = condense(given);
        }



        System.out.println("Total Given:");
        print(total);

        System.out.println("Cash Given:");
        print(given);
        change(given);

        Easy change = difference(total, given);

        System.out.println("Change Given:");
        print(change);
        change(change);
    }
    private static Easy totalChecker(String check) {
        Easy checkTotal = new Easy(0, 0);
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


//        if(check.contains(".")) {
//            String[] checkSplit = check.split("\\.");
//
//            checkTotal.dollars = Integer.parseInt(checkSplit[0]);
//            checkTotal.cents = Integer.parseInt(checkSplit[1]);
//            while (checkTotal.cents > 99 || checkTotal.cents < 0
//                    || checkTotal.dollars < 0)  {
//                System.out.println("Please re-enter a new total");
//                check = readIn.nextLine();
//                if (check.contains(".")) {
//                    checkSplit = check.split("\\.");
//
//                    checkTotal.dollars = Integer.parseInt(checkSplit[0]);
//                    checkTotal.cents = Integer.parseInt(checkSplit[1]);
//
//                } else{
//                    checkTotal.dollars = Integer.parseInt(check);
//                    checkTotal.cents = 0;
//                }
//            }
//        } else{
//            while(checkTotal.dollars < 0){
//                System.out.println("Please re-enter a new total");
//                check = readIn.nextLine();
//            }
//            checkTotal.dollars = Integer.parseInt(check);
//        }
//        }
//        return checkTotal;
//    }

    private static Easy givenChecker(String check, Easy given){
        Scanner readIn = new Scanner(System.in);
        String[] cashArray = new String[] {"20", "10", "5", "1", ".25", ".10", ".05", ".01"};
        boolean temp = true;

        while(temp) {
            for (int i = 0; i < cashArray.length; i++) {
                if (cashArray[i].equals(check)) {
                    if(check.equals("20") ){
                        System.out.println("Worked");
                        given.twenties++;
                        given.dollars += 20;
                    }
                    else if (check.equals("10")){
                        given.tens++;
                        given.dollars += 10;
                    }
                    else if (check.equals("5")){
                        given.fives++;
                        given.dollars += 5;
                    }
                    else if (check.equals("1")){
                        given.ones++;
                        given.dollars += 1;
                    }
                    else if (check.equals(".25")){
                        given.quarters++;
                        given.cents += 25;
                    }
                    else if (check.equals(".10")){
                        given.dimes++;
                        given.cents += 10;
                    }
                    else if (check.equals(".05")){
                        given.nickels++;
                        given.cents += 5;
                    }
                    else if (check.equals(".01")){
                        given.pennies++;
                        given.cents += 1;
                    }
                    temp = false;
                }
            }
            if(temp){
                System.out.println("Sorry but that is not valid bills or coins. Please enter a correct bills or coins");
                check = readIn.nextLine();
            }
        }
        return given;
    }

    private static Easy difference(Easy total, Easy given){
        Scanner readIn = new Scanner(System.in);
        String cash;

        if(given.cents < total.cents){
            given.dollars--;
            given.cents += 100;
        }

        given.dollars -= total.dollars;
        given.cents -= total.cents;

        return given;
    }

    private static Easy condense(Easy given){
        if(given.cents > 100){
            given.dollars += 1;
            given.cents -= 100;
        }
        return given;
    }
    private static void print(Easy printed){
        if(printed.cents < 10){
            System.out.println(printed.dollars + ".0" + printed.cents);
        }
        else{
            System.out.println( printed.dollars + "." + printed.cents);
        }
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
