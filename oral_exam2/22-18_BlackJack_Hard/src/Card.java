import java.util.ArrayList;
import java.util.Random;

public class Card extends Testing{
    char suit;
    int number;

    public Card(char suit, int number){
        this.suit = suit;
        this.number = number;
    }

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

    public static String printDeck(ArrayList<Card> Cards){
        String out = "";
        for(int i = 0; i < Cards.size(); i++){
            out = out + Cards.get(i).printCard() + "\n";
        }
        return out;
    }

    public static Card rdmCard(ArrayList<Card> Cards){
        Random rdmInt = new Random();
        return Cards.get(rdmInt.nextInt(Cards.size()));
    }

    public String printCard(){
        String output = "";

        if(this.suit == 'D'){
            output = "Diamond";
        }else if(this.suit == 'H'){
            output = "Heart ";
        }else if(this.suit == 'C'){
            output = "Club ";
        }else{
            output = "Spades ";
        }

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
