/*
Name: Addison Armstrong
Name of Project: S10_ArabicToRomanGUI_Hard
Name of Class: ArabicToRomanDriver
Class Description: A driver class that starts up the Arabic To Roman GUI
 */

// Importing Swing* to help GUI
import javax.swing.*;

// Creating ArabicToRomanDriver class
/** A driver class that starts up the Arabic To Roman GUI*/
public class ArabicToRomanDriver extends ArabicToRoman {
    /* Driver for ArabicToRoman */
    public static void main(String[] args){
        /* Creating the Window for ArabicToRoman */
        ArabicToRoman textFieldFrame = new ArabicToRoman();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(200,200);
        textFieldFrame.setVisible(true);
    }
}
