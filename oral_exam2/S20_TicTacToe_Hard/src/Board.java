/*
Name: Addison Armstrong
Name of Project: S20_TicTacToe_Hard
Name of Class: Board
Class Description: This is the Board class which holds the board and specific methods.
*/


import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the Board class which holds the board and specific methods.
 */
public class Board {
    // Creating the board
    private char[] board = new char[9];

    // Board Constructor
    public Board(){
        // Creating players
        Player Player1 = new Computer();
        Player Player2 = new Computer();

        //Creating scanner tool
        Scanner readIn = new Scanner(System.in);

        // Filling the board with space
        Arrays.fill(board, ' ');

        System.out.println("Please input number of human players.\n0 for CvC\n1 for PvC\n2 for PvP");

        // Try catching the input to make sure it is valid for how many players
        try{
            int numPlayer = Integer.parseInt(readIn.next());
            if(numPlayer == 0){
                Player1 = new Computer();
                Player2 = new Computer();
            }else if(numPlayer == 1){
                Player1 = new Human();
                Player2 = new Computer();
            }else if(numPlayer == 2){
                Player1 = new Human();
                Player2 = new Human();
            }else{
                System.out.println("You didn't enter a right one.");
                System.exit(1);
            }
        }catch(Exception e){
            System.out.println("You didn't enter a right one.");
            System.exit(1);
        }

        // Prints Board
        print();
        // While board is not full, play the players
        while(!BoardFull()){
            int play1 = Player1.play(board);
            board[play1] = 'X';
            print();
            if(!BoardFull()) {
                int play2 = Player2.play(board);
                board[play2] = 'O';
                print();
            }
            win();
        }
        //win();
    }

    /**
     * BoardFull method to check if the board is full
     * @return
     */
    public boolean BoardFull(){
        for(int i = 0; i < board.length; i++){
            if(board[i] == ' '){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints board in specific way
     */
    private void print(){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    /**
     * Checks board to see who won via the tictactoe rules
     */
    public void win(){
        if((board[0] == board[1] && board[1] == board[2] && board[0] == 'X') ||
                (board[3] == board[4] && board[4] == board[5] && board[3] == 'X') ||
                (board[6] == board[7] && board[7] == board[8] && board[6] == 'X') ||
                (board[0] == board[3] && board[3] == board[6] && board[0] == 'X') ||
                (board[1] == board[4] && board[4] == board[7] && board[1] == 'X') ||
                (board[2] == board[5] && board[5] == board[8] && board[2] == 'X') ||
                (board[0] == board[4] && board[4] == board[8] && board[0] == 'X') ||
                (board[2] == board[4] && board[4] == board[6] && board[2] == 'X')) {
            System.out.println("Player 1 Wins!");
        }
        else if((board[0] == board[1] && board[1] == board[2] && board[0] == 'O') ||
                (board[3] == board[4] && board[4] == board[5] && board[3] == 'O') ||
                (board[6] == board[7] && board[7] == board[8] && board[6] == 'O') ||
                (board[0] == board[3] && board[3] == board[6] && board[0] == 'O') ||
                (board[1] == board[4] && board[4] == board[7] && board[1] == 'O') ||
                (board[2] == board[5] && board[5] == board[8] && board[2] == 'O') ||
                (board[0] == board[4] && board[4] == board[8] && board[0] == 'O') ||
                (board[2] == board[4] && board[4] == board[6] && board[2] == 'O')){
            System.out.println("Player 2 Wins!");
        }
        else{
            System.out.println();
        }
    }
}
