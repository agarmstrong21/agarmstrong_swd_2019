/*
Name: Addison Armstrong
Name of Project: 22-18_BlackJack_Hard
Name of Class: ClientDriver
Class Description: This class starts up the Client class.
 */

// Importing Java Swing tools
import javax.swing.*;

// Creating the ClientDriver class.
/** Creating the ClientDriver Class, this class starts up the Client Class.*/
public class ClientDriver {
    public static void main(String[] args) {
        Client application = new Client(); // create client
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.waitForPackets(); // run client application
    }
}

