/*
Name: Addison Armstrong
Name of Project: 22-18_BlackJack_Hard
Name of Class: Client
Class Description: This class creates the Client GUI and communicates with the Server, or called Dealer. This class has
    a text box to send messages to the Server.
 */

// Importing important tools
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

// Creating the Client class that extends JFrame.
/** Creating the Client Class that extends JFrame. This class communicates with the Server class.*/
public class Client extends JFrame {

    // Creating Global variables. textField and displayArea are used in the GUI. Then the Socket to connect it to the
        // Server
    private JTextField textField;
    private JTextArea displayArea; // for displaying messages
    private DatagramSocket socket; // socket to connect to server

    // set up GUI and DatagramSocket
    public Client() {
        // Naming the client window Player
        super("Player");

        // Setting up the textField. Must press enter to start the game.
        textField = new JTextField("Please press enter to start...");

        // Adding the ActionListener
        textField.addActionListener(
                event -> {
                    try // create and send packet
                    {
                        // get message from textfield
                        String message = event.getActionCommand();

                        // convert to bytes
                        byte[] data = message.getBytes();

                        // create sendPacket
                        DatagramPacket sendPacket = new DatagramPacket(data,
                                data.length, InetAddress.getLocalHost(), 5000);

                        // sending packet to Server
                        socket.send(sendPacket);

                        // Displaying the message in "Player: Message" Format
                        displayArea.setCaretPosition(
                                displayArea.getText().length());
                    } catch (IOException ioException) {
                        displayMessage(ioException + "\n");
                        ioException.printStackTrace();
                    }
                }
        );
        add(textField, BorderLayout.NORTH);

        // Creating and Adding the Display Area text box.
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Making the Window for Client
        setSize(400, 300); // set window size
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket();
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    // wait for packets to arrive from Server, display packet contents
    public void waitForPackets() {
        while (true) {
            // receive packet and display contents
            try {
                // set up packet
                byte[] data = new byte[100];
                DatagramPacket receivePacket = new DatagramPacket(
                        data, data.length);

                // wait for packet
                socket.receive(receivePacket);

                // Displaying message Client side
                displayMessage("\nPlayer: " + new String(receivePacket.getData(), 0, receivePacket.getLength()));
            } catch (IOException exception) {
                displayMessage(exception + "\n");
                exception.printStackTrace();
            }
        }
    }

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }
}

