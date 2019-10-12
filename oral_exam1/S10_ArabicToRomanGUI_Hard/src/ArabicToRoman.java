/*
Name: Addison Armstrong
Name of Project: S10_ArabicToRomanGUI_Hard
Name of Class: ArabicToRomanDriver
Class Description: ArabicToRoman class is a GUI that changes the users input between Arabic numbers or Roman Numbers.
 */

// Importing classes to help with
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Creating ArabicToRoman class
/**ArabicToRoman class is a GUI that changes the users input between Arabic numbers or Roman Numbers.*/
class ArabicToRoman extends JFrame {

    //Creating private final variables for the TextFields
    private final JTextField textFieldArabic;
    private final JTextField textFieldRoman;

    // Constructor for ArabicToRoman
    ArabicToRoman() {
        //Set up of the GUI window
        super("Arabic to Roman");
        setLayout(new GridLayout(2, 2));

        // Adding textStatement that says arabic
        JTextField textStatementArabic = new JTextField("Arabic");
        textStatementArabic.setEditable(false);
        textStatementArabic.setLocation(1,2);
        add(textStatementArabic);

        // Adding textStatement that says roman
        JTextField textStatementRoman = new JTextField("Roman");
        textStatementRoman.setEditable(false);
        textStatementRoman.setLocation(2,2);
        add(textStatementRoman);

        // adding a textField and key listeners for the arabic side
        textFieldArabic = new JTextField("Arabic",10);
        textFieldArabic.setLocation(1,1);
        add(textFieldArabic);
        ArabicKeyListener arabicKeyListener = new ArabicKeyListener();
        textFieldArabic.addKeyListener(arabicKeyListener);

        // adding a textField and key listeners for the roman side
        textFieldRoman = new JTextField("Roman" ,10);
        textFieldArabic.setLocation(2,1);
        add(textFieldRoman);
        RomanKeyListener romanKeyListener = new RomanKeyListener();
        textFieldRoman.addKeyListener(romanKeyListener);
    }

    //Creating ArabicKeyListener Class
    /**ArabicKeyListener is a overrided class of KeyListener to use our logic for the text fields.*/
    private class ArabicKeyListener implements KeyListener
    {
        //Overriding KeyTyped, keyPressed, and keyReleased to our logic
        @Override
        public void keyTyped (KeyEvent event){
    }

        @Override
        public void keyPressed (KeyEvent event){
    }

        @Override
        public void keyReleased (KeyEvent event){
        String input = textFieldArabic.getText();
        translate(input);
    }

        //Private void method that translates the inputted string to arabic or roman respectively
        private void translate (String inputString){
        StringBuilder outputString = new StringBuilder();
        int input;
            //A try catch to make sure the values entered are valid
            try {
                input = Integer.parseInt(inputString);
                int temp = input;
                if (temp < 4000 && temp > 0) {
                    //While loop of changing the Arabic numbers to Roman numbers
                    while (temp != 0) {
                        if (temp >= 1000) {
                            outputString.append("M");
                            temp -= 1000;
                        } else if (temp >= 900) {
                            outputString.append("CM");
                            temp -= 900;
                        } else if (temp >= 500) {
                            outputString.append("D");
                            temp -= 500;
                        } else if (temp >= 400) {
                            outputString.append("CD");
                            temp -= 400;
                        } else if (temp >= 100) {
                            outputString.append("C");
                            temp -= 100;
                        } else if (temp >= 90) {
                            outputString.append("XC");
                            temp -= 90;
                        } else if (temp >= 50) {
                            outputString.append("L");
                            temp -= 50;
                        } else if (temp >= 40) {
                            outputString.append("XL");
                            temp -= 40;
                        } else if (temp >= 10) {
                            outputString.append("X");
                            temp -= 10;
                        } else if (temp >= 9) {
                            outputString.append("IX");
                            temp -= 9;
                        } else if (temp >= 5) {
                            outputString.append("V");
                            temp -= 5;
                        } else if (temp >= 4) {
                            outputString.append("IV");
                            temp -= 4;
                        } else if (temp >= 1) {
                            outputString.append("I");
                            temp -= 1;
                        }
                    }
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "You entered a value that is not an integer. Please try again.");
            }
            //Replaces text in roman to the new text
            textFieldRoman.setText(outputString.toString());
        }
    }

    //Creating RomanKeyListener
    /**Creating RomanKeyListener that overrides keyListener to our logic*/
    private class RomanKeyListener implements KeyListener{

        //Methods keyTyped, keyPressed, and keyReleased are overrided to our logic
        @Override
        public void keyTyped (KeyEvent event){
        }

        @Override
        public void keyPressed (KeyEvent event){
        }

        @Override
        public void keyReleased (KeyEvent event){
            translate(textFieldRoman.getText());
        }

        //translate method translates the inputted string to arabic
        private void translate(String inputString){
            int output = 0;
                //try catch to make sure the string is valid
                try {
                    inputString = inputString.toUpperCase();
                    String temp = inputString;

                    if ((temp.contains("MMMM") || temp.contains("CCCC") || temp.contains("DDDD") || temp.contains("XXXX")
                            || temp.contains("VVVV") || temp.contains("IIII") || temp.contains("LLLL"))) {
                        throw new NumberFormatException();
                    } else {
                        //While loop to change roman to arabic, uses letters that contain two first to make sure it reads it right
                        while (!temp.isEmpty()) {
                            if (temp.contains("CM")) {
                                temp = temp.replaceFirst("CM", "");
                                output += 900;
                            } else if (temp.contains("M")) {
                                temp = temp.replaceFirst("M", "");
                                output += 1000;
                            } else if (temp.contains("CD")) {
                                temp = temp.replaceFirst("CD", "");
                                output += 400;
                            } else if (temp.contains("D")) {
                                temp = temp.replaceFirst("D", "");
                                output += 500;
                            } else if (temp.contains("XC")) {
                                temp = temp.replaceFirst("XC", "");
                                output += 90;
                            } else if (temp.contains("C")) {
                                temp = temp.replaceFirst("C", "");
                                output += 100;
                            } else if (temp.contains("XL")) {
                                temp = temp.replaceFirst("XL", "");
                                output += 40;
                            } else if (temp.contains("L")) {
                                temp = temp.replaceFirst("L", "");
                                output += 50;
                            } else if (temp.contains("IX")) {
                                temp = temp.replaceFirst("IX", "");
                                output += 9;
                            } else if (temp.contains("X")) {
                                temp = temp.replaceFirst("X", "");
                                output += 10;
                            } else if (temp.contains("IV")) {
                                temp = temp.replaceFirst("IV", "");
                                output += 4;
                            } else if (temp.contains("V")) {
                                temp = temp.replaceFirst("V", "");
                                output += 5;
                            } else if (temp.contains("I")) {
                                temp = temp.replaceFirst("I", "");
                                output += 1;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "You entered a string with the wrong characters. Please try again.");
                }
                //Changes the arabic textfield to represent the output
                textFieldArabic.setText(String.valueOf(output));
            }
        }
    }

