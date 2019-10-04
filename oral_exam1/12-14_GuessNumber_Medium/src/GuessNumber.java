//Taken mostly from TextFieldFrame


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber extends JFrame {
    //TODO: Create window

    private final JTextField textField1; // text field with set size

    public GuessNumber() {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());

        // construct textfield with 10 columns
        textField1 = new JTextField(10);
        add(textField1); // add textField1 to JFrame

        // register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
    }

    // private inner class for event handling
    private class TextFieldHandler implements ActionListener {
        // process textfield events
        @Override
        public void actionPerformed(ActionEvent event) {
            String string = "";
            // user pressed Enter in JTextField textField1
            if (event.getSource() == textField1)
                string = String.format("YaYeet: %s",
                        event.getActionCommand());

            // display JTextField content
            JOptionPane.showMessageDialog(null, string);
        }
    } // end private inner class TextFieldHandler

    //Logic for NumberGuesser
    public static void main(String[] args) {
            GuessNumber textFieldFrame = new GuessNumber();
            textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            textFieldFrame.setSize(350, 100);
            textFieldFrame.setVisible(true);



        Scanner readIn = new Scanner(System.in);
        int input = 0;
        Random rmdInt = new Random();
        int given = rmdInt.nextInt(998) + 1;

        //While loop to give the user infinite number of guesses to find the right value.
        System.out.println("Welcome to Number Guesser, please input a value between 1 and 1000.");
        while(given != input){
            input = readIn.nextInt();
            if(input == given){
                System.out.println("Good Job! You got it!");
            } else if (input > 1000 || input < 1) {
                System.out.println("You entered a value too not in the range, please try again.");
            } else if (input > given) {
                System.out.println("You are too high, try again.");
            } else if (input < given) {
                System.out.println("You are too low, try again.");
            }
        }
    }

}
