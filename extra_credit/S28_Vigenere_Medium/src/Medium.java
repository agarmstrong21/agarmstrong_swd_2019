/*
Name: Addison Armstrong
Name of Project: S28_Vigenere_Medium
Name of Class: EncrpytMedium
Class Description: Finds the encryption of an inputted word using the file's key. Then decrypts the message too.
 */

// Importing file and scanner tools
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Creation of Medium class which runs the encryption and decryption of a word.
 */
public class Medium {

    // Creating and initializing global variables used in the class
    private static Scanner readIn = new Scanner(System.in);
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static String input;
    private static String key;

    /**
     * encrypt method encrypts the input with the key from the file
     */
    private static void encrypt(){
        // Set a temp char array that will contain the new word that is encrypted.
        char[]temp = new char[input.length()];

        // iterates through the input and changes it using encryptHelper
        for(int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            char b = key.charAt(i);
            temp[i] = encryptHelper(a,b);
        }
        // Sets input to the new encrypted input and prints it
        input = String.valueOf(temp);
        System.out.println(input);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private static char encryptHelper(char a, char b){
        // finds the numerical value of the char using findNumericValue method
        int aAt = findNumericValue(a);
        int bAt = findNumericValue(b);

        // Find the encrypted numerical value and returns the respective letter
        aAt = (aAt + bAt)%26;
        return alphabet.charAt(aAt);
    }

    /**
     *  Finds the numerical value of the char using the alphabet string
     * @param a
     * @return
     */
    private static int findNumericValue(char a){
        for(int i = 0; i < 26; i++){
            if(alphabet.charAt(i) == a){
                return i;
            }
        }
        return -1;
    }

    /**
     * Much like encrypt, but instead using decryptHelper method
     */
    private static void decrypt(){
        for(int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            char b = key.charAt(i);
            decryptHelper(a, b);
        }
    }

    /**
     * Much like encryptHelper but instead finds the decrypted letter using alphabet and findNumericValue
     * @param a
     * @param b
     */
    private static void decryptHelper(char a, char b){
        // Finds the respective numeric value of both chars using findNumericValue method
        int aAt = findNumericValue(a);
        int bAt = findNumericValue(b);

        // if the sum of the two positions are negative, then takes it out of 26, else, finds the numerical value of both
        if((aAt - bAt) < 0){
            aAt = (26 + (aAt - bAt))%26;
        }else {
            aAt = (aAt - bAt) % 26;
        }
        // Prints out the respective char
        System.out.print(alphabet.charAt(aAt));
    }

    /**
     * Main function which runs all the private methods.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Attempts to connect to the file containing the key
        Scanner fileIn;
        try{
            fileIn = new Scanner(new File("extra_credit/S28_Vigenere_Medium/CipherText.txt"));
        }catch (Exception e){
            throw e;
        }

        // Welcome message
        System.out.println("Welcome to Vigenere\nPlease enter one word only using alphabetical characters. Must be < " +
                "20 Characters.");

        // Scans in user input to lowercase
        input = readIn.next().toLowerCase();

        // Finds the key from the file and repeats it 4 times for up to 20 characters
        key = fileIn.next();
        key = key.repeat(4);

        // Starts the encryption
        System.out.println("Encrypted Text");
        encrypt();

        // Starts the decryption
        System.out.println("\nDecrypted Text");
        decrypt();

        // resets the key at the end
        key = "";
    }
}
