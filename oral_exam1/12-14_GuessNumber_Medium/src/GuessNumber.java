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
        String inputString = "";
        int input = 0;
        Random rmdInt = new Random();
        int given = rmdInt.nextInt(998) + 1;
        int pInput = given;

        //While loop to give the user infinite number of guesses to find the right value.
        System.out.println("Welcome to Number Guesser, please input a value between 1 and 1000.");
        while(given != input){
            pInput = input;
            inputString = readIn.nextLine();
            try {
                input = Integer.parseInt(inputString);
                if (input > 0 && input < 1001) {
                    if (input == given) {
                        System.out.println("Good Job! You got it! (GREEN)");
                    } else if (input > given && input < pInput) {
                        System.out.println("Getting Warmer.... Too High (RED)");
                    } else if (input > given && input > pInput) {
                        System.out.println("Getting Colder.... Too High (BLUE)");
                    } else if (input < given && input > pInput) {
                        System.out.println("Getting Warmer.... Too Low (RED)");
                    } else if (input < given && input < pInput) {
                        System.out.println("Getting Colder.... Too Low (BLUE)");
                    }
                }
            }catch(NumberFormatException e) {
                System.out.println("You entered a value that is not an integer. Please try again.");
                throw e;
            }

        }
    }
}
//test