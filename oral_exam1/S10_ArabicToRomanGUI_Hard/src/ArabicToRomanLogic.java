import java.util.Scanner;

public class ArabicToRomanLogic {
    public static void main(String [] args){
        while(0==0){
            try{
                int input = 0;

                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter a integer value in Roman and this program will return it in Arabic.");
                input = scan.nextInt();
                System.out.println("you entered: " + input);

                int temp = input;
                String arabic = "";

                if(temp >= 1000){

                }
            }catch(Exception e){
                throw new NumberFormatException("You must enter in an integer. Please reset program");
            }
        }
    }
}
