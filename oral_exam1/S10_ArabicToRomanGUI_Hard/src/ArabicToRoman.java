

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ArabicToRoman extends JFrame{

    private final JTextField textStatementArabic;
    private final JTextField textStatementRoman;
    private final JTextField textFieldArabic;
    private final JTextField textFieldRoman;

    public ArabicToRoman() {
        super("Arabic to Roman");
        setLayout(new GridLayout(2, 2));

        textStatementArabic = new JTextField("Arabic");
        textStatementArabic.setEditable(false);
        textStatementArabic.setLocation(1,2);
        add(textStatementArabic);


        textStatementRoman = new JTextField("Roman");
        textStatementRoman.setEditable(false);
        textStatementRoman.setLocation(2,2);
        add(textStatementRoman);

        textFieldArabic = new JTextField("Arabic",10);
        textFieldArabic.setLocation(1,1);
        add(textFieldArabic);

        textFieldRoman = new JTextField("Roman" ,10);
        textFieldArabic.setLocation(2,1);
        add(textFieldRoman);

        TextFieldHandler ArabicHandler;
        ArabicHandler = new TextFieldHandler();
        textFieldArabic.addActionListener(ArabicHandler);

        TextFieldHandler RomanHandler  = new TextFieldHandler();
        textFieldRoman.addActionListener(RomanHandler);
    }

    private class TextFieldHandler implements ActionListener {
        /* Process TextField events */

        @Override
        public void actionPerformed(ActionEvent event) {
            String inputString = "";
            String outputString = "";
            int input = 0;
            int output = 0;

            if(event.getSource() == textFieldArabic){
                try {
                    inputString = String.format("%s", event.getActionCommand());
                    input = Integer.parseInt(inputString);

                    int temp = input;
                    if (temp < 4000 && temp > 0) {
                        while (temp != 0) {
                            if (temp >= 1000) {
                                outputString += "M";
                                temp -= 1000;
                            } else if (temp >= 900) {
                                outputString += "CM";
                                temp -= 900;
                            } else if (temp >= 500) {
                                outputString += "D";
                                temp -= 500;
                            } else if (temp >= 400) {
                                outputString += "CD";
                                temp -= 400;
                            } else if (temp >= 100) {
                                outputString += "C";
                                temp -= 100;
                            } else if (temp >= 90) {
                                outputString += "XC";
                                temp -= 90;
                            } else if (temp >= 50) {
                                outputString += "L";
                                temp -= 50;
                            } else if (temp >= 40) {
                                outputString += "XL";
                                temp -= 40;
                            } else if (temp >= 10) {
                                outputString += "X";
                                temp -= 10;
                            } else if (temp >= 9) {
                                outputString += "IX";
                                temp -= 9;
                            } else if (temp >= 5) {
                                outputString += "V";
                                temp -= 5;
                            } else if (temp >= 4) {
                                outputString += "IV";
                                temp -= 4;
                            } else if (temp >= 1) {
                                outputString += "I";
                                temp -= 1;
                            }
                        }
                    }
                }catch(NumberFormatException e){
                    outputString = "You entered a value that is not an integer. Please try again.";
                    JOptionPane.showMessageDialog(null, outputString);
                }
                textFieldRoman.setText(outputString);
            }
            if(event.getSource() == textFieldRoman){
                try {
                    inputString = String.format("%s", event.getActionCommand());

                    inputString = inputString.toUpperCase();

                    String temp = inputString;
                    if(!(temp.contains("M") && temp.contains("C") && temp.contains("D") && temp.contains("X") &&
                            temp.contains("V") && temp.contains("I") && temp.contains("L")) ) {
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
                    }else{
                        throw new NumberFormatException();
                    }
                }catch(NumberFormatException e){
                    outputString = "You entered a string with the wrong characters. Please try again.";
                    JOptionPane.showMessageDialog(null, output);
                }
                textFieldArabic.setText(String.valueOf(output));
            }
        }
    }
}
