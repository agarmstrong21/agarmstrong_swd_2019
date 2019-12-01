/*
Name: Addison Armstrong
Name of Project: 22-18_BlackJack_Hard
Name of Class: Server
Class Description: This class creates the Server that communicates with clients. This also contains the logic of the
    Black Jack game. This is the Dealer.
 */

// Importing Java tools for Server
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

// Creating the Server Class
/** Creating the Server Class, this starts up the GUI for the Server.*/
public class Server extends JFrame {

    // Global variables to communicate with Client and show the text
    private JTextArea textArea; // displays packets received
    private DatagramSocket socket; // socket to connect to client

    // set up GUI and DatagramSocket
    public Server() {
        // Name of the Window
        super("Dealer");

        // Creating the textArea
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Creating the Window
        setSize(400, 300);
        setVisible(true);

        // Connecting to Client
        try
        {
            socket = new DatagramSocket(5000);
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    // Run program that will run the logic of the game
    public void run(){
        // Creating Player and Dealer Decks and Totals
        ArrayList<Card> Player = new ArrayList<>();
        ArrayList<Card> Dealer = new ArrayList<>();
        int PlayerTotal = 0;
        int DealerTotal = 0;

        // Creates a temp card to use to give to people
        Card Temp = null;

        // Booleans with if Player or Dealer wishes to continue
        boolean p1 = true, p2 = true;

        // Creates a new deck with 13 cards of all suits
        ArrayList<Card> Cards = Card.newDeck();

        // First Message, and waiting for response of Player Client
        displayMessage("Welcome to the game of Black Jack. You need to get the closest to 21 as possible.\n");
        displayMessage("Waiting for player to connect...");
        waitForPackets();

        // Gets new random cards from current deck and gives it out to the players.
        displayMessage("Player: Here are your cards: \n");
        Temp = Card.rdmCard(Cards); // Getting Random Card from Deck
        Player.add(Temp); // Adding Card to Player Deck
        Cards.remove(Temp); // Removing Card from Deck
        PlayerTotal += Temp.number; // Adding Total

        // Repeats everything above again for second draw
        Temp = Card.rdmCard(Cards);
        Player.add(Temp);
        Cards.remove(Temp);
        PlayerTotal += Temp.number;

        // Prints total
        displayMessage(Card.printDeck(Player) + "Total: " + PlayerTotal + "\n\n");

        // Prints out random cards dealt to the dealer, repeated from above.
        displayMessage("Dealer: Here are your cards: \n");
        Temp = Card.rdmCard(Cards);
        Dealer.add(Temp);
        Cards.remove(Temp);
        DealerTotal += Temp.number;

        // Second Card
        Temp = Card.rdmCard(Cards);
        Dealer.add(Temp);
        Cards.remove(Temp);
        DealerTotal += Temp.number;

        // Displays total
        displayMessage(Card.printDeck(Dealer) + "Total: " + DealerTotal + "\n\n");

        // While loop if both parties want to draw. It will break if both parties do not want to continue
            // or if totals reach 21
        while(p1||p2) {
            displayMessage("Player would you like to draw? Type y for yes or n for no.");
            String p1String = waitForPackets();

            // If player wants to deal then it will give them a new card
            if (p1String.equals("y")) {
                p1 = true;
                displayMessage("Player, Here are your cards:\n");
                Temp = Card.rdmCard(Cards);
                Player.add(Temp);
                Cards.remove(Temp);
                PlayerTotal += Temp.number;
                displayMessage(Card.printDeck(Player) + "Total: " + PlayerTotal + "\n\n");
            } else if(p1String.equals("n")){
                p1 = false;
                displayMessage("Player decides to stay.\n");
            }

            // If dealer wants to deal then it will give them a new card
            if(DealerTotal < 21){
                p2 = true;
                displayMessage("Dealer, Here are your cards:\n");
                Temp = Card.rdmCard(Cards);
                Dealer.add(Temp);
                Cards.remove(Temp);
                DealerTotal += Temp.number;
                displayMessage(Card.printDeck(Dealer) + "Total: " + DealerTotal +"\n\n");
            }else{
                p2 = false;
                displayMessage("Dealer decides to stay.\n");
            }

            // If either totals are over 20, then it will break the loop
            if(PlayerTotal > 20 || DealerTotal > 20){
                p1 = false;
                p2 = false;
            }
        }

        // Runs the WhoWins Method to print out who won
        WhoWins(Player, Dealer);
    }

    // wait for packets to arrive, display data
    public String waitForPackets() {
        boolean temp = true;
        String out = "";
        while (temp) {
            // receive packet, display contents, return copy to client
            try
            {
                byte[] data = new byte[100]; // set up packet
                DatagramPacket receivePacket =
                        new DatagramPacket(data, data.length);

                socket.receive(receivePacket); // wait to receive packet

                out = new String(receivePacket.getData(), 0, receivePacket.getLength());
                displayMessage("\nPlayer: " + out + "\n");
                sendPacketToClient(receivePacket); // send packet to client
                if(!out.equals("")){
                    temp = false;
                }

            } catch (IOException ioException) {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
        return out;
    }

    private void sendPacketToClient(DatagramPacket receivePacket)
            throws IOException {
        // create packet to send
        DatagramPacket sendPacket = new DatagramPacket(
                receivePacket.getData(), receivePacket.getLength(),
                receivePacket.getAddress(), receivePacket.getPort());

        socket.send(sendPacket); // send packet to client
    }

    // manipulates textArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates textArea
                    {
                        textArea.append(messageToDisplay); // display message
                    }
                }
        );
    }

    // Gets total of given deck
    public int CardTotal(ArrayList<Card> p){
        int total = 0;
        for (Card card : p) {
            total += card.number;
        }
        return total;
    }

    // Displays who won depending on total
    public void WhoWins(ArrayList<Card> Player, ArrayList<Card> Dealer){
        // Prints out totals of both parties
        displayMessage("Here are the ending results:\n Player has: \n" + Card.printDeck(Player));
        displayMessage("\nDealer has: \n" + Card.printDeck(Dealer));
        int p1 = CardTotal(Player);
        int p2 = CardTotal(Dealer);

        // Compares the totals
        // If both are equal, ends in tie
        if(p1 == p2){
            displayMessage("\nPlayer and Dealer tie with " + p1);
        }

        // If player has a higher total then...
        else if(p1 > p2 ){
            // If player's total is less than 22, then they win
            if(p1 < 22){
                displayMessage("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }
            // If player's total is greater than 22, then dealer wins
            else if(p2 < 22){
                displayMessage("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }
        }
        // If Dealer has a higher total then...
        else if(p2 > p1){
            // If Dealer's total is less than 22, then they win
            if(p2 < 22){
                displayMessage("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }
            // If Dealer's total is greater than 22, then player wins
            else if(p1 < 22){
                displayMessage("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }
        }
        // If none of the statements worked, no one won.
        else{
            displayMessage("\nNo one won.");
        }
    }
}