/*
Name: Addison Armstrong
Name of Project: 22-18_BlackJack_Hard
Name of Class: Card
Class Description: This class contains the Card objects. Cards contain the number value and the suit. There are
    several different methods in this to help create a deck or grab random cards.
*/

// Importing ArrayList and Random tools
import java.util.ArrayList;
import java.util.Random;

//Creating the Card Class which extends the Testing Class.
/** Creating the Card Class. This class creates the Cards with their number and suit. Also contains deck creation
 *      and deal methods
 */
public class Card extends Testing{

    // Global Variables of the Card Class
    char suit;
    int number;

    // Constructor of Card. Taking in suit as a Char and a number as an int.
    public Card(char suit, int number){
        this.suit = suit;
        this.number = number;
    }

    // Card Method that returns an ArrayList of Cards. This creates a deck.
    public static ArrayList<Card> newDeck(){
        ArrayList<Card> Cards = new ArrayList<>();
        String suits = "DHSC";

        for(int i = 0; i < suits.length(); i++){
            for(int j = 1; j < 14; j++){
                Cards.add(new Card(suits.charAt(i), j));
            }
        }
        return Cards;
    }

    // Card Method that returns a random card from the deck.
    public static Card rdmCard(ArrayList<Card> Cards){
        Random rdmInt = new Random();
        return Cards.get(rdmInt.nextInt(Cards.size()));
    }

    // Card Method that prints out the deck that is taken in.
    public static String printDeck(ArrayList<Card> Cards){
        String out = "";
        for(int i = 0; i < Cards.size(); i++){
            out = out + Cards.get(i).printCard() + "\n";
        }
        return out;
    }

    // Prints out the given card, depending on the suit and number.
    public String printCard(){
        String output = "";

        // Prints out the suit
        if(this.suit == 'D'){
            output = "Diamond";
        }else if(this.suit == 'H'){
            output = "Heart ";
        }else if(this.suit == 'C'){
            output = "Club ";
        }else{
            output = "Spades ";
        }

        // Prints out face cards
        if(this.number == 1){
            output = output + " Ace";
        }else if(this.number == 11){
            output = output + " Jack";
        }else if(this.number == 12){
            output = output + " Queen";
        }else if(this.number == 13){
            output = output + " King";
        }else{
            output = output + " " + this.number;
        }
        return output;
    }

}
