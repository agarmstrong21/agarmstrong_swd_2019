import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends JFrame {
    private JTextArea displayArea; // displays packets received
    private DatagramSocket socket; // socket to connect to client

    // set up GUI and DatagramSocket
    public Server() {
        super("Dealer");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window

        try
        {
            socket = new DatagramSocket(5000);
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    public void run(){
        ArrayList<Card> Player1 = new ArrayList<>();
        ArrayList<Card> Player2 = new ArrayList<>();
        int Player1Total = 0;
        int Player2Total = 0;
        Card Temp = null;
        boolean p1 = true, p2 = true;
        Scanner readIn = new Scanner(System.in);

        ArrayList<Card> Cards = Card.newDeck();
        displayMessage("Welcome to the game of Black Jack. You need to get the closest to 21 as possible.\n");
        displayMessage("Waiting for player to connect...");
        waitForPackets();

        displayMessage("Player: Here are your cards: \n");
        Temp = Card.rdmCard(Cards);
        Player1.add(Temp);
        Cards.remove(Temp);
        Player1Total += Temp.number;
        Temp = Card.rdmCard(Cards);
        Player1.add(Temp);
        Cards.remove(Temp);
        Player1Total += Temp.number;
        displayMessage(Card.printDeck(Player1) + "Total: " + Player1Total + "\n\n");

        displayMessage("Dealer: Here are your cards: \n");
        Temp = Card.rdmCard(Cards);
        Player2.add(Temp);
        Cards.remove(Temp);
        Player2Total += Temp.number;
        Temp = Card.rdmCard(Cards);
        Player2.add(Temp);
        Cards.remove(Temp);
        Player2Total += Temp.number;
        displayMessage(Card.printDeck(Player2) + "Total: " + Player2Total + "\n\n");

        while(p1||p2) {
            displayMessage("Player would you like to draw? Type y for yes or n for no.");
            String p1String = waitForPackets();
            if (p1String.equals("y")) {
                p1 = true;
                displayMessage("Player, Here are your cards:\n");
                Temp = Card.rdmCard(Cards);
                Player1.add(Temp);
                Cards.remove(Temp);
                Player1Total += Temp.number;
                displayMessage(Card.printDeck(Player1) + "Total: " + Player1Total + "\n\n");
            } else if(p1String.equals("n")){
                p1 = false;
                displayMessage("Player decides to stay.\n");
            }

            if(Player2Total < 21){
                p2 = true;
                displayMessage("Dealer, Here are your cards:\n");
                Temp = Card.rdmCard(Cards);
                Player2.add(Temp);
                Cards.remove(Temp);
                Player2Total += Temp.number;
                displayMessage(Card.printDeck(Player2) + "Total: " + Player2Total +"\n\n");
            }else{
                p2 = false;
                displayMessage("Dealer decides to stay.\n");
            }

            if(Player1Total > 20 || Player2Total > 20){
                p1 = false;
                p2 = false;
            }
        }
        WhoWins(Player1, Player2);
    }

    // wait for packets to arrive, display data
    public String waitForPackets() {
        boolean temp = true;
        String out = "";
        while (temp) {
            try // receive packet, display contents, return copy to client
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

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // display message
                    }
                }
        );
    }

    public int CardTotal(ArrayList<Card> p){
        int total = 0;
        for(int i = 0; i < p.size(); i++){
            total += p.get(i).number;
        }
        return total;
    }

    public void WhoWins(ArrayList<Card> Player1, ArrayList<Card> Player2){
        displayMessage("Here are the ending results:\n Player has: \n" + Card.printDeck(Player1));
        displayMessage("\nDealer two has: \n" + Card.printDeck(Player2));
        int p1 = CardTotal(Player1);
        int p2 = CardTotal(Player2);
        if(p1 == p2){
            displayMessage("\nPlayer and Dealer tie with " + p1);
        } else if(p1 > p2 ){
            if(p1 < 22){
                displayMessage("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }else if(p2 < 22){
                displayMessage("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }
        }else if(p2 > p1 && p2 < 22){
            if(p2 < 22){
                displayMessage("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }else if(p1 < 22){
                displayMessage("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }
        }else{
            displayMessage("\nNo one won.");
        }
    }
}