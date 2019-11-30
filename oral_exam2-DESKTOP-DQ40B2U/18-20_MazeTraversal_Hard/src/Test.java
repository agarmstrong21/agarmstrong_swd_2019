import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Test {
    @org.junit.Test
    public void Test1(){

        char[][] test = maze1();
        print(test);

    }

    private char[][] maze1(){
        //    0 1 2 3 4 5 6 7 8 91011
        //  0 # # # # # # # # # # # #
        //  1 # . . . # . . . . . . #
        //  2 . . # . # . . # # # . #
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
                = m[5][0] = m[5][4] = m[5][5] = m[5][6] = m[5][9]= m[5][11]
                = m[6][0] = m[6][4]= m[6][11]
                = m[7][0] = m[7][2] = m[7][4] = m[7][5] = m[7][6] = m[7][7] = m[7][9] = m[7][10]= m[7][11]
                = m[8][0] = m[8][2] = m[8][9]= m[8][11]
                = m[9][0] = m[9][2] = m[9][3] = m[9][4] = m[9][5] = m[9][6] = m[9][7] = m[9][8] = m[9][9]= m[9][11]
                = m[10][0] = m[10][11]
                = m[11][0] = m[11][1] = m[11][2] = m[11][3] = m[11][5] = m[11][6] = m[11][7] = m[11][8] = m[11][9] = m[11][10] = m[11][11]
                = '#';

        return m;
    }


    public void print(char[][] test){
        for(int i =0; i < 12; i++){
            for(int j = 0; j <  12; j++){
                System.out.print(test[j][i]+" ");
            }
            System.out.println();
        }
    }
}