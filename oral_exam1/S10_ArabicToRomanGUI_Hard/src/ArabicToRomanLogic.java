import java.util.Scanner;

public class ArabicToRomanLogic {
    public static void main(String [] args){
        while(0==0){
            try{
                int input = 0;
                StringBuilder roman = new StringBuilder();

                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter a integer value in Arabic and this program will return it in Roman.");
                input = scan.nextInt();
                System.out.println("you entered: " + input);


                int temp = input;
                while(temp != 0) {
                    if (temp >= 1000) {
                        roman.append("M");
                        temp -= 1000;
                    }else if(temp >= 900){
                        roman.append("CM");
                        temp -= 900;
                    }else if(temp >= 500) {
                        roman.append("D");
                        temp -= 500;
                    }else if (temp >= 400){
                        roman.append("CD");
                        temp -= 400;
                    }else if(temp >= 100) {
                        roman.append("C");
                        temp -= 100;
                    }else if(temp >= 90){
                        roman.append("XC");
                        temp -= 90;
                    }else if(temp >= 50) {
                        roman.append("L");
                        temp -= 50;
                    }else if (temp >= 40){
                        roman.append("XL");
                        temp -= 40;
                    }else if(temp >= 10) {
                        roman.append("X");
                        temp -= 10;
                    }else if(temp >= 9){
                        roman.append("IX");
                        temp -= 9;
                    }else if(temp >= 5) {
                        roman.append("V");
                        temp -= 5;
                    }else if(temp >= 4) {
                        roman.append("IV");
                        temp -= 4;
                    }else if(temp >= 1){
                        roman.append("I");
                        temp -= 1;
                    }
                }
                System.out.println(roman);
                System.out.println(input + " " + temp);
            }catch(Exception e){
                throw new NumberFormatException("You must enter in an integer. Please reset program");
            }


        }
    }
}
