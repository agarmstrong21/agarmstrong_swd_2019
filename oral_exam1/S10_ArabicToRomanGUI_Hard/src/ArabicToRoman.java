

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
        super("Arabic to outputString");
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        textStatementArabic = new JTextField("Arabic");
        textStatementArabic.setEditable(false);
        add(textStatementArabic);


        textStatementRoman = new JTextField("Roman");
        textStatementRoman.setEditable(false);
        add(textStatementRoman);

        textFieldArabic = new JTextField("Arabic",10);
        add(textFieldArabic);

        textFieldRoman = new JTextField("Roman",10);
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
            StringBuilder outputString = new StringBuilder();
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
                    }
                    System.out.println(outputString);
                    System.out.println(input + " " + temp);
                }catch(NumberFormatException e){
                    outputString.append( "You entered a value that is not an integer. Please try again.");
                }
                /* Display JTextField content */
                JOptionPane.showMessageDialog(null, outputString);
            }
            if(event.getSource() == textFieldRoman){
                inputString = String.format("%s",event.getActionCommand());

                inputString = inputString.toUpperCase();

                String temp = inputString;
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
                System.out.println(output);
                System.out.println(input + " " + temp);

                /* Display JTextField content */
                JOptionPane.showMessageDialog(null, outputString);
            }

        }
    }
}
