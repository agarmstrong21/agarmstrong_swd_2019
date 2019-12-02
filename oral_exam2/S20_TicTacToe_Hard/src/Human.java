/*
Name: Addison Armstrong
Name of Project: S20_TicTacToe_Hard
Name of Class: Human
Class Description: This is the Human player class. This class asks the user to put a move in the char array
*/

import java.util.Scanner;

/**
 * This is the Human player class, This class asks the user to put a move in the char array
 */
public class Human extends Player {
    @Override
    public int play(char[] board) {
        Scanner readIn = new Scanner(System.in);
        System.out.println("Please select where you would like to put your marker. (0-8, left to right, up to down.)");
        int play = Integer.parseInt(readIn.next());

        // Checks to make sure the move they wanted is valid
        while(!validMove(board, play)){
            System.out.println("Not a valid move, try again");
            play = Integer.parseInt(readIn.next());
        }
        return play;
    }


}
