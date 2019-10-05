//Taken mostly from TextFieldFrame
//TODO: Put in comments, comment blocks, and etc.
//TODO: Move Main to a test file.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumber extends JFrame {

    private final JTextField textField1; // text field with set size
    private final JButton resetJButton;
    private int given = new Random().nextInt(998) + 1;
    private int pInput = given;

    public GuessNumber() {
        super("12-14_GuessNumber_Medium");
        setLayout(new FlowLayout());

        // construct textfield with 10 columns
        textField1 = new JTextField(10);
        add(textField1); // add textField1 to JFrame

        // Adds button
        resetJButton = new JButton("Reset"); // button with text
        add(resetJButton); // add plainJButton to JFrame

        // register event handlers
        TextFieldHandler textHandler = new TextFieldHandler();
        textField1.addActionListener(textHandler);


        ButtonHandler buttonHandler = new ButtonHandler();
        resetJButton.addActionListener(buttonHandler);
    }

    // private inner class for event handling
    private class TextFieldHandler implements ActionListener {
        // process textfield events
        @Override
        public void actionPerformed(ActionEvent event) {
            String inputString = "";
            String outputString = "";
            int input = 0;

            // user pressed Enter in JTextField textField1
            if (event.getSource() == textField1) {
                inputString = String.format("%s", event.getActionCommand());
                try{
                    input = Integer.parseInt(inputString);
                    if (input > 0 && input < 1001) {
                        if (input == given) {
                            outputString = "Good Job! You got it! (GREEN)";
                            getContentPane().setBackground(Color.green);
                        } else if (input > given && input < pInput) {
                            outputString = "Getting Warmer.... Too High (RED)";
                            getContentPane().setBackground(Color.red);
                        } else if (input > given && input > pInput) {
                            outputString = "Getting Colder.... Too High (BLUE)";
                            getContentPane().setBackground(Color.blue);
                        } else if (input < given && input > pInput) {
                            outputString = "Getting Warmer.... Too Low (RED)";
                            getContentPane().setBackground(Color.red);
                        } else if (input < given && input < pInput) {
                            outputString = "Getting Colder.... Too Low (BLUE)";
                            getContentPane().setBackground(Color.BLUE);
                        }
                    }
                    else{
                        outputString = "Sorry you entered a invalid number. Please try again";
                        getContentPane().setBackground(Color.WHITE);
                    }

                }catch(NumberFormatException e){
                    outputString = "You entered a value that is not an integer. Please try again.";
                }
            }

            // display JTextField content
            JOptionPane.showMessageDialog(null, outputString + " " + given);
            pInput = input;
        }
    } // end private inner class TextFieldHandler

    // inner class for button event handling
    private class ButtonHandler implements ActionListener {
        // handle button event
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(GuessNumber.this, String.format(
                    "Restarted the Game", event.getActionCommand()));
            given = new Random().nextInt(998) + 1;
            pInput = given;
            getContentPane().setBackground(Color.WHITE);
        }
    }

    //Logic for NumberGuesser
    public static void main(String[] args) {
        GuessNumber textFieldFrame = new GuessNumber();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(350, 100);
        textFieldFrame.setVisible(true);
    }
}
//test