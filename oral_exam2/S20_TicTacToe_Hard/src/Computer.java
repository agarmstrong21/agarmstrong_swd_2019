/*
Name: Addison Armstrong
Name of Project: S20_TicTacToe_Hard
Name of Class: Computer
Class Description: This is the Computer player class. This class randomly chooses a place in the char array to play
*/
import java.util.Random;

/**
 * This is the Computer player class, This class randomly chooses a place in the char array to play
 */
public class Computer extends Player {
    @Override
    public int play(char[] board) {
        Random rdmInt = new Random();
        int play = rdmInt.nextInt(9);
        // While this is not a valid move, try to find another random int
        while(!validMove(board, play)){
            play = rdmInt.nextInt(9);
        }
        return play;
    }
}
