/*
Name: Addison Armstrong
Name of Project: 18-20_MazeTraversal_Hard
Name of Class: Traversal
Class Description: This is the Traversal class. This class contains the algorithm mazeTraversal that finds the path from
    the beginning of the maze, to the end, or the beginning again. This algorithm takes in the maze in a char array and
        the coordinates of the start. They check down, right, up, then left. In that order.
*/

// Creating the Traversal class. This contains the mazeTraversal Algorithm.
/** Creating the Traversal class. This contains the mazeTraversal Algorithm.*/
public class Traversal {

    // mazeTraversal Algorithm to find the end of the maze given the maze and the start coordinates.
    public char[][] mazeTraversal(char[][] maze, int x, int y){

        // Using the try catch to find the 'end' of the maze. Or when the maze hits the bounds of the char array.
        try{
            // this will test all valid moves. If they are valid, it replaces the current position with 'x' and moves
                // the cursor 'A' to the next position. Prints maze and recursively calls mazeTraversal.

            // if down is a valid move
            if(maze[x][y-1] == '.'){
                maze[x][y] = 'x';
                maze[x][y-1] = 'A';
                print(maze);
                mazeTraversal(maze, x, y-1);
            }

            // if right is a valid move
            if(maze[x+1][y] == '.'){
                maze[x][y] = 'x';
                maze[x+1][y] = 'A';
                print(maze);
                mazeTraversal(maze, x+1, y);
            }

            // if up is a valid move
            if(maze[x][y+1] == '.'){
                maze[x][y] = 'x';
                maze[x][y+1] = 'A';
                print(maze);
                mazeTraversal(maze, x, y+1);
            }

            // if left is a valid move
            if(maze[x-1][y] == '.'){
                maze[x][y] = 'x';
                maze[x-1][y] = 'A';
                print(maze);
                mazeTraversal(maze, x-1, y);
            }

            // if no moves are available or the cursor approaches a dead end, the current position is replaced with '0'
                // and prints the maze again. This will remove the cursor until a next valid move is available.
                    // Returns the current maze.
            maze[x][y] = '0';
            print(maze);
            return maze;
        }catch(Exception e){
            // If the maze approaches the 'end' of the maze, or approaches a point where the cursor is at the bounds,
                // then the catch will initiate. Assuming the maze is done. Ending the program.
            System.out.println("The Maze is traversed. Thank you for playing.");
            maze[x][y] = 'x';
            print(maze);
            System.exit(0);
        }
        return maze;
    }

    // Print method to print out the mazes
    public void print(char[][] test){
        for(int y =0; y < 12; y++){
            for(int x = 0; x <  12; x++){
                System.out.print(test[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
