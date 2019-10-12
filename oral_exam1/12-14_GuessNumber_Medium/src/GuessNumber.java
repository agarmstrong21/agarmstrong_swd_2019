/*
 Name: Addison Armstrong
 Name of Project: 12-14_GuessNumber_Medium
 Name of Class: GuessNumber
 Description: This class contains the code to create a window which makes a number guessing game. The number guessing
 game takes in integer values between 1 and 1000. The code randomizes an answer and the user must guess a number. If
 number is wrong, a new window will appear telling the user that they are cold or hot based on their previous answer.
 The window will also turn red or blue according to if the user is colder or hotter to the number. Once the number is
 guessed, the window will turn green. Reset button is always available for the user to try a different number.
 Date: 10/07/2019
*/

//Importing classes for make GUI function
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//Creating GuessNumberClass
/**GuessNumber GUI is a game that you must guess the number between a set range. */
public class GuessNumber extends JFrame {

    //Creating variables given that is a random number, TextField to type in, and a previous input
    private final JTextField textField;
    private int given = new Random().nextInt(998) + 1;
    private int pInput = given;

    //Constructor for GuessNumber
    public GuessNumber() {
        super("Guess Number Game");
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        /* Constructs and Adds textStatements with game text*/
        JTextField textStatement = new JTextField("I have a number between 1 and 1000. Can you guess my number?");
        textStatement.setEditable(false);
        add(textStatement);
        JTextField textStatement2 = new JTextField("Please enter your first Guess");
        textStatement2.setEditable(false);
        add(textStatement2);

        /* Constructs and Adds textfield with 10 columns */
        textField = new JTextField(10);
        add(textField);

        /* Constructs and adds the Reset Button */
        JButton resetJButton = new JButton("Reset");
        add(resetJButton);

        /* Creates and registers event handler textHandler */
        TextFieldHandler textHandler = new TextFieldHandler();
        textField.addActionListener(textHandler);

        /* Creates and registers event handler buttonHandler */
        ButtonHandler buttonHandler = new ButtonHandler();
        resetJButton.addActionListener(buttonHandler);
    }

    /* Private class for textField event handling */
    private class TextFieldHandler implements ActionListener {
        /* Process textfield events */

        /* Overrid actionPrefromed function */
        @Override
        public void actionPerformed(ActionEvent event) {
            /* Creating instance variable inputString, outputString, and input */
            String inputString;
            String outputString = "";
            int input = 0;

            /* Whenever the user pressed Enter in JTextField textField */
            if (event.getSource() == textField) {

                /*Converting the entered string to an actual string */
                inputString = String.format("%s", event.getActionCommand());

                /* Try catch to see if the inputString is allowed to be an integer */
                try{
                    /* If inputString is allowed to be an integer, set it equal to input */
                    input = Integer.parseInt(inputString);

                    /* If statement to make sure that input is between 1 and 1000 */
                    if (input > 0 && input < 1001) {

                        /* If statements that evaluated the input. Depending on where the input lands, the main window */
                        /* will change colors, and a new window will pop up stating where the input lands */
                        if (input == given) {
                            outputString = "Good Job! You got it! (GREEN)";
                            getContentPane().setBackground(Color.green);
                            textField.setEditable(false);
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
                        outputString = "Sorry you entered a invalid number between 1 and 1000. Please try again";
                        getContentPane().setBackground(Color.WHITE);
                    }
                }catch(NumberFormatException e){
                    outputString = "You entered a value that is not an integer. Please try again.";
                }
            }
            /* Display JTextField content */
            JOptionPane.showMessageDialog(null, outputString);
            pInput = input;
        }
    }

    /* Private class for reset button event handling */
    private class ButtonHandler implements ActionListener {
        /* handle button event */
        @Override
        public void actionPerformed(ActionEvent event) {
            /* When Reset button is pressed, re initializes the random int and changes the background color to white*/
            JOptionPane.showMessageDialog(GuessNumber.this, "Restarted the Game");
            given = new Random().nextInt(998) + 1;
            pInput = given;
            getContentPane().setBackground(Color.WHITE);
            textField.setEditable(true);
        }
    }
}
/*End program */