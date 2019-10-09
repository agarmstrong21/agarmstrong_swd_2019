import java.util.Scanner;

public class RomanToArabicLogic {
    public static void main(String[] args) {
        while (0 == 0) {
            try {
                int arabic = 0;
                String input;

                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter a integer value in Roman and this program will return it in Arabic.");
                input = scan.nextLine();
                input = input.toUpperCase();
                System.out.println("you entered: " + input);

                String temp = input;
                while (!temp.isEmpty()) {
                    if (temp.contains("CM")) {
                        temp = temp.replaceFirst("CM", "");
                        arabic += 900;
                    } else if (temp.contains("M")) {
                        temp = temp.replaceFirst("M", "");
                        arabic += 1000;
                    } else if (temp.contains("CD")) {
                        temp = temp.replaceFirst("CD", "");
                        arabic += 400;
                    } else if (temp.contains("D")) {
                        temp = temp.replaceFirst("D", "");
                        arabic += 500;
                    } else if (temp.contains("XC")) {
                        temp = temp.replaceFirst("XC", "");
                        arabic += 90;
                    } else if (temp.contains("C")) {
                        temp = temp.replaceFirst("C", "");
                        arabic += 100;
                    } else if (temp.contains("XL")) {
                        temp = temp.replaceFirst("XL", "");
                        arabic += 40;
                    } else if (temp.contains("L")) {
                        temp = temp.replaceFirst("L", "");
                        arabic += 50;
                    } else if (temp.contains("IX")) {
                        temp = temp.replaceFirst("IX", "");
                        arabic += 9;
                    } else if (temp.contains("X")) {
                        temp = temp.replaceFirst("X", "");
                        arabic += 10;
                    } else if (temp.contains("IV")) {
                        temp = temp.replaceFirst("IV", "");
                        arabic += 4;
                    } else if (temp.contains("V")) {
                        temp = temp.replaceFirst("V", "");
                        arabic += 5;
                    } else if (temp.contains("I")) {
                        temp = temp.replaceFirst("I", "");
                        arabic += 1;
                    }
                }
                System.out.println(arabic);
                System.out.println(input + " " + temp);
            } catch (Exception e) {
                throw new NumberFormatException("You must enter in valid letters. Please reset program");
            }
        }
    }
}

