/*
Name: Addison Armstrong
Name of Project: S20_TicTacToe_Hard
Name of Class: Player
Class Description: Abstract class Player which takes in Computer and Human.
*/

/**
 * Abstract class Player which takes in Computer and Human.
 */
public abstract class Player {

    // validMove method which checks the move and see if it empty in the char array
    public boolean validMove(char[] board, int move){
        if(board[move] == ' '){
            return true;
        }
        return false;
    }

    // middle man of the play method
    public abstract int play(char[] board);
}
