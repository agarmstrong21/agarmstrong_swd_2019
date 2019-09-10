import java.util.Scanner;
public class Easy {
    public static void main(String[] args){

        Scanner readIn = new Scanner(System.in);
        int dollars = 0;
        int cents = 0;
        int temp = 0;
        String purchase;


        System.out.println("Welcome to S4_ChangeComputation \n" +
                "Please enter in the total price of all the items.");

        purchase = readIn.nextLine();




        if(purchase.contains(".")) {
            String[] purchaseSplit = purchase.split("\\.");

            dollars = Integer.valueOf(purchaseSplit[0]);
            cents = Integer.valueOf(purchaseSplit[1]);
            while (cents > 99 || cents < 0 || dollars < 0)  {
                System.out.println("Please re-enter a new total");
                purchase = readIn.nextLine();

                if (purchase.contains(".")) {
                    purchaseSplit = purchase.split("\\.");

                    dollars = Integer.valueOf(purchaseSplit[0]);
                    cents = Integer.valueOf(purchaseSplit[1]);

                } else {
                    dollars = Integer.valueOf(purchase);
                    cents = 0;
                }
            }

        } else{
            dollars = Integer.valueOf(purchase);
        }

        if(dollars/20 > 0){
            System.out.println("20's: " + dollars/20);
            temp = dollars/20;
            dollars = dollars - temp*20;
        }
        if(dollars/10 > 0){
            System.out.println("10's: " + dollars/10);
            temp = dollars/10;
            dollars = dollars - temp*10;
        }
        if(dollars/5 > 0){
            System.out.println("5's: " + dollars/5);
            temp = dollars /5;
            dollars = dollars - temp*5;
        }

        System.out.println("1/s: " + dollars);

        if(cents/25 > 0){
            System.out.println(".25's: " + cents/25);
            temp = cents/25;
            cents = cents - temp*25;
        }
        if (cents/10 > 0){
            System.out.println(".10's: " + cents/10);
            temp = cents/10;
            cents = cents - temp*10;
        }
        if(cents/5 > 0){
            System.out.println(".05's: " + cents/5);
            temp = cents/5;
            cents = cents - temp*5;
        }

        System.out.println(".01's: " + cents);

//        System.out.println("5's: " + dollars/5);
//        System.out.println("10's: " + dollars/10);
//        System.out.println("10's: " + dollars/10);
//        System.out.println("10's: " + dollars/10);
//        System.out.println("10's: " + dollars/10);
//        System.out.println("10's: " + dollars/10);

        System.out.println(dollars+"\n"+cents);
    }

}
