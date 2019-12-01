import java.util.ArrayList;
import java.util.Scanner;

// This class is for testing logic, Does not work anymore.
public class Testing  {

    public static void main(String[] args){
        ArrayList<Card> Player1 = new ArrayList<>();
        ArrayList<Card> Player2 = new ArrayList<>();
        Card Temp = null;
        boolean p1 = true, p2 = true;
        Scanner readIn = new Scanner(System.in);

        ArrayList<Card> Cards = Card.newDeck();
        System.out.println("Welcome to the game of Black Jack. You need to get the closest to 21 as possible.");
        Card.printDeck(Cards);

        System.out.println("Player one: Here are your cards: ");
        Temp = Card.rdmCard(Cards);
        Player1.add(Temp);
        Cards.remove(Temp);
        Temp = Card.rdmCard(Cards);
        Player1.add(Temp);
        Cards.remove(Temp);
        Card.printDeck(Player1);

        System.out.println("Player two: Here are your cards: ");
        Temp = Card.rdmCard(Cards);
        Player2.add(Temp);
        Cards.remove(Temp);
        Temp = Card.rdmCard(Cards);
        Player2.add(Temp);
        Cards.remove(Temp);
        Card.printDeck(Player2);

        while(p1||p2) {
            System.out.print("Player 1 would you like to draw? Type y for yes or n for no.");
            String p1String = readIn.next();
            System.out.print("Player 2 would you like to draw? Type y for yes or n for no.");
            String p2String = readIn.next();
            if (p1String.equals("y")) {
                p1 = true;
                System.out.println("Player one: Here are your cards: ");
                Temp = Card.rdmCard(Cards);
                Player1.add(Temp);
                Cards.remove(Temp);
                Temp = Card.rdmCard(Cards);
                Player1.add(Temp);
                Cards.remove(Temp);
                Card.printDeck(Player1);
            } else {
                p1 = false;
            }
            if (p2String.equals("y")) {
                p2 = true;
                System.out.println("Player two: Here are your cards: ");
                Temp = Card.rdmCard(Cards);
                Player2.add(Temp);
                Cards.remove(Temp);
                Temp = Card.rdmCard(Cards);
                Player2.add(Temp);
                Cards.remove(Temp);
                Card.printDeck(Player2);
            } else {
                p2 = false;
            }
        }

        WhoWins(Player1, Player2);
    }

    public static void WhoWins(ArrayList<Card> Player1, ArrayList<Card> Player2){
        System.out.print("Here are the ending results:\n Player has: \n" + Card.printDeck(Player1));
        System.out.print("\nDealer two has: \n" + Card.printDeck(Player2));
        int p1 = CardTotal(Player1);
        int p2 = CardTotal(Player2);
        if(p1 == p2){
            System.out.print("\nPlayer and Dealer tie with " + p1);
        } else if(p1 > p2 ){
            if(p1 < 22){
                System.out.print("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }else if(p2 < 22){
                System.out.print("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }
        }else if(p2 > p1 && p2 < 22){
            if(p2 < 22){
                System.out.print("\nDealer Wins! With " + p2 + " over Player's " + p1);
            }else if(p1 < 22){
                System.out.print("\nPlayer Wins! With " + p1 + " over Dealer's " + p2);
            }
        }else{
            System.out.print("\nNo one won.");
        }
    }

    public static int CardTotal(ArrayList<Card> p){
        int total = 0;
        for(int i = 0; i < p.size(); i++){
            total += p.get(i).number;
        }
        return total;
    }
}
