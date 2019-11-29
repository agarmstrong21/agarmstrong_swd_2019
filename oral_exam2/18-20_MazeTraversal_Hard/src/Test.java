/*
Name: Addison Armstrong
Name of Project: 18-20_MazeTraversal_Hard
Name of Class: Test
Class Description: This is the Test class. This class will test 4 pre-made unique mazes using the mazeTraversal
    algorithm. There will be one open test and one open maze creator for further testing purposes.
*/

//Creation of the Test class for testing mazeTraversals.
/** Creation of the Test class for testing mazeTraversals. */
public class Test extends Traversal{

    // CONSTRAINTS OF MAZES
    // All mazes must have a starting point on the edge of the maze. It cannot start in the middle. Mazes can have no
        // exit. But they all need need at least one '.' to start on. The ending needs to be on the edge of the Maze too
        // , they cannot end at a 'dead end.'

    // Note: Test 1 is the maze from the prompt.

    // Test 1
    // Testing maze 1
    @org.junit.Test
    public void Test1(){
        char[][] test = maze1();
        print(test);
        mazeTraversal(test, 0, 2);
    }

    // Test 2
    // Testing maze 2
    @org.junit.Test
    public void Test2(){
        char[][] test = maze2();
        print(test);
        mazeTraversal(test, 0, 6);
    }

    // Test 3
    // Testing maze 3
    @org.junit.Test
    public void Test3(){
        char[][] test = maze3();
        print(test);
        mazeTraversal(test, 0, 1);
    }

    // Test 4
    // Testing maze 4
    @org.junit.Test
    public void Test4(){
        char[][] test = maze4();
        print(test);
        mazeTraversal(test, 0, 1);
    }

    @org.junit.Test
    public void Test5(){
        char[][] test = maze5();
        print(test);
        mazeTraversal(test,0,0);
    }

    // Creation of Maze 1
    private char[][] maze1(){
        //    0 1 2 3 4 5 6 7 8 91011
        //  0 # # # # # # # # # # # #
        //  1 # . . . # . . . . . . #
        //  2 . . # . # . # # # # . #
        //  3 # # # . # . . . . # . #
        //  4 # . . . . # # # . # . .
        //  5 # # # # . # . # . # . #
        //  6 # . . # . # . # . # . #
        //  7 # # . # . # . # . # . #
        //  8 # . . . . . . . . # . #
        //  9 # # # # # # . # # # . #
        // 10 # . . . . . . # . . . #
        // 11 # # # # # # # # # # # #

        char[][] m = new char[12][12];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                m[i][j] = '.';
            }
        }

        m[0][0] = m[0][1] = m[0][3] = m[0][4] = m[0][5] = m[0][6] = m[0][7] = m[0][8] = m[0][9] = m[0][10] = m[0][11]
            = m[1][0] = m[1][3]= m[1][5]= m[1][7]= m[1][9]= m[1][11]
                = m[2][0] = m[2][2] = m[2][3]= m[2][5]= m[2][9]= m[2][11]
                = m[3][0] = m[3][5] = m[3][6] = m[3][7] = m[3][9]= m[3][11]
                = m[4][0] = m[4][1] = m[4][2] = m[4][3] = m[4][9]= m[4][11]
                = m[5][0] = m[5][4] = m[5][5] = m[5][6] =  m[5][7] = m[5][9]= m[5][11]
                = m[6][0] = m[6][2] = m[6][4]= m[6][11]
                = m[7][0] = m[7][2] = m[7][4] = m[7][5] = m[7][6] = m[7][7] = m[7][9] = m[7][10]= m[7][11]
                = m[8][0] = m[8][2] = m[8][9]= m[8][11]
                = m[9][0] = m[9][2] = m[9][3] = m[9][4] = m[9][5] = m[9][6] = m[9][7] = m[9][8] = m[9][9]= m[9][11]
                = m[10][0] = m[10][11]
                = m[11][0] = m[11][1] = m[11][2] = m[11][3] = m[11][5] = m[11][6] = m[11][7] = m[11][8] = m[11][9] = m[11][10] = m[11][11]
                = '#';

        return m;
    }

    // Creation of Maze 2
    private char[][] maze2(){
        //    0 1 2 3 4 5 6 7 8 91011
        //  0 # # # # # # # # # # # #
        //  1 # # . # . # . # . # . #
        //  2 # # . # . # . # . # . #
        //  3 # # . # . # . # . # . #
        //  4 # # . # . # . # . # . #
        //  5 # # . # . # . # . # . #
        //  6 . . . . . . . . . . . #
        //  7 # . # . # . # . # . # #
        //  8 # . # . # . # . # . # #
        //  9 # . # . # . # . # . # #
        // 10 # . # . # . # . # . # #
        // 11 # # # # # # # # # # # #

        char[][] m = new char[12][12];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                m[i][j] = '.';
            }
        }

        m[0][0] = m[0][1] = m[0][2] = m[0][3] = m[0][4] = m[0][5] = m[0][7] = m[0][8] = m[0][9] = m[0][10] = m[0][11]
                = m[1][0] = m[1][1] = m[1][2] = m[1][3] = m[1][4] = m[1][5] = m[1][11]
                = m[2][0] = m[2][7] = m[2][8] = m[2][9] = m[2][10] = m[2][11]
                = m[3][0] = m[3][1] = m[3][2] = m[3][3] = m[3][4] = m[3][5] = m[3][11]
                = m[4][0] = m[4][7] = m[4][8] = m[4][9] = m[4][10] = m[4][11]
                = m[5][0] = m[5][1] = m[5][2] = m[5][3] = m[5][4] = m[5][5] = m[5][11]
                = m[6][0] = m[6][7] = m[6][8] = m[6][9] = m[6][10] = m[6][11]
                = m[7][0] = m[7][1] = m[7][2] = m[7][3] = m[7][4] = m[7][5] = m[7][11]
                = m[8][0] = m[8][7] = m[8][8] = m[8][9] = m[8][10] = m[8][11]
                = m[9][0] = m[9][1] = m[9][2] = m[9][3] = m[9][4] = m[9][5] = m[9][11]
                = m[10][0] = m[10][7] = m[10][8] = m[10][9] = m[10][10] = m[10][11]
                = m[11][0] = m[11][1] = m[11][2] = m[11][3] = m[11][4] = m[11][5] = m[11][6] = m[11][7] = m[11][8]
                 = m[11][9] = m[11][10]= m[11][11] = '#';

        return m;
    }

    // Creation of Maze 3
    private char[][] maze3(){
        //    0 1 2 3 4 5 6 7 8 91011
        //  0 # # # # # # # # # # # #
        //  1 . . . . . . . . . . . #
        //  2 # # # # # # # # # # . #
        //  3 # . . . . . . . . . . #
        //  4 # . # # # # # # # # # #
        //  5 # . . . . . . . . . . #
        //  6 # # # # # # # # # # . #
        //  7 # . . . . . . . . . . #
        //  8 # . # # # # # # # # # #
        //  9 # . . . . . . . . . . #
        // 10 . . . . . . . . . . . #
        // 11 # # # # # # # # # # # #

        char[][] m = new char[12][12];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                m[i][j] = '.';
            }
        }

        m[0][0] = m[0][2] = m[0][3] = m[0][4] = m[0][5] = m[0][6] = m[0][7] = m[0][8] = m[0][9] = m[0][11]
                = m[1][0] = m[1][2] = m[1][6] = m[1][11]
                = m[2][0] = m[2][2] = m[2][4] = m[2][6] = m[2][8] = m[2][11]
                = m[3][0] = m[3][2] = m[3][4] = m[3][6] = m[3][8] = m[3][11]
                = m[4][0] = m[4][2] = m[4][4] = m[4][6] = m[4][8] = m[4][11]
                = m[5][0] = m[5][2] = m[5][4] = m[5][6] = m[5][8] = m[5][11]
                = m[6][0] = m[6][2] = m[6][4] = m[6][6] = m[6][8] = m[6][11]
                = m[7][0] = m[7][2] = m[7][4] = m[7][6] = m[7][8] = m[7][11]
                = m[8][0] = m[8][2] = m[8][4] = m[8][6] = m[8][8] = m[8][11]
                = m[9][0] = m[9][2] = m[9][4] = m[9][6] = m[9][8] = m[9][11]
                = m[10][0] = m[10][4] = m[10][8] = m[10][11]
                = m[11][0] = m[11][1] = m[11][2] = m[11][3] = m[11][4] = m[11][5] = m[11][6] = m[11][7] = m[11][8] = m[11][9] = m[11][10] = m[11][11] ='#';


        return m;
    }

    // Creation of Maze 4
    private char[][] maze4(){
        //    0 1 2 3 4 5 6 7 8 91011
        //  0 # # # # # # # # # # # #
        //  1 . . . . . . . . . . . #
        //  2 # . . . . . . . . . . #
        //  3 # . . . . . . . . . . #
        //  4 # . . . . . . . . . . #
        //  5 # . . . . . . . . . . #
        //  6 # . . . . . . . . . . #
        //  7 # . . . . . . . . . . #
        //  8 # . . . . . . . . . . #
        //  9 # . . . . . . . . . . #
        // 10 . . . . . . . . . . . #
        // 11 # # # # # # # # # # # #

        char[][] m = new char[12][12];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                m[i][j] = '.';
            }
        }

        m[0][0] = m[0][2] = m[0][3] = m[0][4] = m[0][5] = m[0][6] = m[0][7] = m[0][8] = m[0][9] = m[0][11]
                = m[1][0] = m[1][11]
                = m[2][0] = m[2][11]
                = m[3][0] = m[3][11]
                = m[4][0] = m[4][11]
                = m[5][0] = m[5][11]
                = m[6][0] = m[6][11]
                = m[7][0] = m[7][11]
                = m[8][0] = m[8][11]
                = m[9][0] = m[9][11]
                = m[10][0] = m[10][11]
                = m[11][0] = m[11][1] = m[11][2] = m[11][3] = m[11][4] = m[11][5] = m[11][6] = m[11][7] = m[11][8] = m[11][9] = m[11][10] = m[11][11]
                = '#';

        return m;
    }

    // Creating the additional testing maze
    private char[][] maze5() {
        //    0 1 2 3 4 5 6 7 8 91011
        //  0
        //  1
        //  2
        //  3
        //  4
        //  5
        //  6
        //  7
        //  8
        //  9
        // 10
        // 11

        // Filling the array with '.'
        char[][] m = new char[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                m[i][j] = '.';
            }
        }

        // Creat the boundary lines of the maze below.
        // m[0][0] = '#';

        // Return the maze
        return m;
    }
}
