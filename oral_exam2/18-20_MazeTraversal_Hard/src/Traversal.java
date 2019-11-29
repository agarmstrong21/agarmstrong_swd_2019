public class Traversal {
    public char[][] Traverse(char[][] maze, int x, int y){
//        if(x == 11 || x == 0 || y == 0 || y == 11){
//            print(maze);
//            return maze;
//        }
        if(maze[x][y-1] == '.'){
            maze[x][y] = '0';
            maze[x][y-1] = 'A';
            print(maze);
            return Traverse(maze, x, y-1);
        }
        if(maze[x+1][y] == '.'){
            maze[x][y] = '0';
            maze[x+1][y] = 'A';
            print(maze);
            return Traverse(maze, x+1, y);
        }
        if(maze[x][y+1] == '.'){
            maze[x][y] = '0';
            maze[x][y+1] = 'A';
            print(maze);
            return Traverse(maze, x, y+1);
        }
        if(maze[x-1][y] == '.'){
            maze[x][y] = '0';
            maze[x-1][y] = 'A';
            print(maze);
            return Traverse(maze, x-1, y);
        }
        print(maze);
        return maze;
    }

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
