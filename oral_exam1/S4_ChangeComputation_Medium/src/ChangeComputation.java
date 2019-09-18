import java.util.Scanner;

//Comments to ask TA's
//Hot to do java docs
//review over these and see if they will suffice



public class ChangeComputation {

    private Scanner readIn = new Scanner(System.in);

    private int dollars, cents, twenties, tens, fives, ones,
            quarters, dimes, nickels, pennies;


    public ChangeComputation(int d, int c) {
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

    public ChangeComputation (int d, int c, int T, int t, int f, int o, int q, int D, int n, int p){
        this.dollars = d;
        this.cents = c;
        this.twenties = T;
        this.tens = t;
        this.fives = f;
        this.ones = o;
        this.quarters = q;
        this.dimes = D;
        this.nickels = n;
        this.pennies = p;
    }



    public String stringChecker(String str){
        while(str.equals("")){
            System.out.println("You gave an amount that is blank, please try again.");
            str = readIn.nextLine();
        }
        return str;
    }


    public void totalChecker(String check) {
        boolean temp = true;

        while (temp) {
            if (!check.contains("-")) {
                if (check.contains(".")) {
                    String[] checkSplit = check.split("\\.");
                    if(Integer.parseInt(checkSplit[1]) <100) {
                        this.dollars = Integer.parseInt(0 + checkSplit[0]);
                        this.cents = Integer.parseInt(checkSplit[1]);
                        temp = false;
                    }
                } else {
                    this.dollars = Integer.parseInt(check);
                    this.cents = 0;
                    temp = false;
                }
            }
            if (temp) {
                System.out.println("Sorry but that is not a valid total. Please enter a correct total");
                check = stringChecker(readIn.nextLine());
            }
        }
    }

    public void getMoney(ChangeComputation total){
        String givenString;
        while(total.dollars > this.dollars || (total.dollars == this.dollars && total.cents > this.cents)){
            this.dollars  = this.cents = 0;
            this.twenties = this.tens = this.fives = this.ones = 0;
            this.quarters = this.dimes = this.nickels = this.pennies = 0;

            System.out.print("20's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.twenties += Integer.parseInt(givenString);
                this.dollars += 20*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }


            System.out.print("10's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.tens += Integer.parseInt(givenString);
                this.dollars += 10*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print("5's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.fives += Integer.parseInt(givenString);
                this.dollars += 5*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print("1's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.ones += Integer.parseInt(givenString);
                this.dollars += Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print(".25's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.quarters += Integer.parseInt(givenString);
                this.cents += 25*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print(".10's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.dimes += Integer.parseInt(givenString);
                this.cents += 10*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print(".05's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.nickels += Integer.parseInt(givenString);
                this.cents += 5*Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            System.out.print(".01's: ");
            givenString = this.stringChecker(readIn.nextLine());
            if(!givenString.contains("-") && !givenString.contains(".")){
                this.pennies += Integer.parseInt(givenString);
                this.cents += Integer.parseInt(givenString);
                this.condense();
                this.print();
            }

            if(total.dollars > this.dollars || (total.dollars == this.dollars && total.cents > this.cents)){
                System.out.println("You did not provide enough change. Please enter a new amount.");
            }
        }
        System.out.println();
    }

    public ChangeComputation difference(ChangeComputation given){
        int temp;

        if(given.cents < this.cents){
            given.dollars--;
            given.cents += 100;
        }

        given.dollars -= this.dollars;
        given.cents -= this.cents;
        given.twenties = given.tens = given.fives = given.ones = 0;
        given.quarters = given.dimes = given.nickels = given.pennies = 0;
        given.print();

        if(given.dollars/20 > 0 && this.twenties != 0){
            temp = given.dollars/20;
            for(int i = 0; i <= temp; i++){
                if(this.twenties != 0){
                    given.dollars -= 20;
                    given.twenties ++;
                    this.twenties --;
                }
            }

        }
        if(given.dollars/10 > 0 && given.dollars/10 < this.tens){
            temp = given.dollars/10;
            for(int i = 0; i <= temp; i++){
                if(this.tens != 0){
                    given.dollars -= 10;
                    given.tens ++;
                    this.tens --;
                }
            }
        }
        if(given.dollars/5 > 0 && given.dollars/5 < this.fives){
            temp = given.dollars/5;
            for(int i = 0; i <= temp; i++){
                if(this.fives != 0){
                    given.dollars -= 5;
                    given.fives ++;
                    this.fives --;
                }
            }
        }
        if(given.dollars > 0 && given.dollars < this.ones){
            temp = given.dollars;
            for(int i = 0; i <= temp; i++){
                if(this.ones != 0){
                    given.dollars -= 1;
                    given.ones ++;
                    this.ones --;
                }
            }
        }
        if(given.cents/25 > 0 && this.quarters > 0){
            temp = given.cents/25;
            for(int i = 0; i <= temp; i++){
                if(this.quarters != 0){
                    given.cents -= 25;
                    given.quarters ++;
                    this.quarters --;
                }
            }
        }
        if(given.cents/10 > 0 && this.dimes > 0){
            temp = given.cents/10;
            for(int i = 0; i <= temp; i++){
                if(this.dimes != 0){
                    given.cents -= 10;
                    given.dimes ++;
                    this.dimes --;
                }
            }
        }
        if(given.cents/5 > 0 && this.nickels > 0){
            temp = given.cents/5;
            for(int i = 0; i <= temp; i++){
                if(this.nickels != 0){
                    given.cents -= 5;
                    given.nickels ++;
                    this.nickels --;
                }
            }
        }
        if(given.cents > 0 && this.pennies > 0){
            temp = given.cents;
            for(int i = 0; i <= temp; i++){
                if(this.pennies != 0){
                    given.cents -= 1;
                    given.pennies ++;
                    this.pennies --;
                }
            }
        }

        if(given.dollars > 0 || given.cents > 0){
            System.out.println("The drawer does not have enough money to complete Transaction.");
            System.exit(0);
        }

        return given;
    }

    public ChangeComputation condense(){
        while(this.cents >= 100){
            this.dollars += 1;
            this.cents -= 100;
        }
        return this;
    }


    //Printing off money
    public void print(){
        if(this.cents < 10){
            System.out.println(this.dollars + ".0" + this.cents);
        }
        else{
            System.out.println( this.dollars + "." + this.cents);
        }
    }

    public void change(){
        System.out.println("20's: " + this.twenties);
        System.out.println("10's: " + this.tens);
        System.out.println("5's: " + this.fives);
        System.out.println("1's: " + this.ones);
        System.out.println(".25's: " + this.quarters);
        System.out.println(".10's: " + this.dimes);
        System.out.println(".05's: " + this.nickels);
        System.out.println(".01's: " + this.pennies);
    }

    public void addToDrawer (ChangeComputation given){
        this.twenties += given.twenties;
        this.tens += given.tens;
        this.fives += given.fives;
        this.ones += given.ones;
        this.quarters += given.quarters;
        this.dimes += given.dimes;
        this.nickels += given.nickels;
        this.pennies += given.pennies;
    }
}
