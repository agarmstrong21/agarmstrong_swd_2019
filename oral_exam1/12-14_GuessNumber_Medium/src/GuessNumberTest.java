/************************
 Name: Addison Armstrong
 Name of Project: 12-14_GuessNumber_Medium
 Name of Class: GuessNumberTest
 Description: This class contains the testing methods of GuessNumber. No tests are in the class except for the main.
 The main runs the GuessNumberTest class which inherits GuessNumber. This class creates a window that is closable with
 the size of 350 by 100.
 Date: 10/07/2019
************************/
import javax.swing.*;

public class GuessNumberTest extends GuessNumber {
    /* Logic for NumberGuesser */
    public static void main(String[] args) {
        /* Creating the Window of GuessNumber */
        GuessNumber textFieldFrame = new GuessNumber();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(400, 200);
        textFieldFrame.setVisible(true);
    }
}
