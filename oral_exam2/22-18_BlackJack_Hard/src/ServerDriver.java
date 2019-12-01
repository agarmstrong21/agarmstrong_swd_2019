/*
Name: Addison Armstrong
Name of Project: 22-18_BlackJack_Hard
Name of Class: ServerDriver
Class Description: This class creates the Client GUI and communicates with the Server, or called Dealer. This class has
    a text box to send messages to the Server.
 */

// Importing Java Swing tools
import javax.swing.*;

// Creating the ServerDriver Class
/** Creating the ServerDriver Class that starts up the Server Class.*/
public class ServerDriver {
    public static void main(String[] args) {
        Server application = new Server(); // Creates Server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.run(); // Starts Application
    }
}

