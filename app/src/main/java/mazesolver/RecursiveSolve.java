/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author popalmu
 */
public class RecursiveSolve {

    private int height = 0;
    private int width;
    private int[][] maze; // = new boolean[width][height]; // The maze
    private boolean[][] visited;
    // private boolean[][] correctPath;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    /**
     * Class provides recursive way to a solve maze.
     * <p>
     * Recursive maze solver class</p>
     *
     * @author Petri Palmu
     * @param referenceMaze
     */
<<<<<<< HEAD
   
    public void solve(Maze referenceMaze) {
=======
    public RecursiveSolve(Maze referenceMaze) {
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5
        this.height = referenceMaze.getMazeHeight();
        this.width = referenceMaze.getMazeLength();
        this.visited = new boolean[height][width];
        // this.correctPath = new boolean[height][width];
        this.maze = Utils.copyMaze(referenceMaze);
        System.out.println(maze[1][1]);
<<<<<<< HEAD
        
=======

    }

    public void solve() {
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5
        long startTime = System.nanoTime();
        int startX = 1;
        int startY = 1;
        boolean solved = recursiveSolve(startY, startX);
        long endTime = System.nanoTime();
        if (solved) {
            System.out.println("");
            System.out.println("solved");
            for (int[] maze1 : this.maze) {
                System.out.println("");
                for (int j = 0; j < maze1.length; j++) {
                    if (maze1[j] == 1) {
                        System.out.print("#");
                    } else if (maze1[j] == 2) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
<<<<<<< HEAD
            System.out.println("Time it took to solve was " + (endTime - startTime) / 1e9 * 1000 + "milliseconds");
=======
            System.out.println("Time it took to solve was " + (endTime - startTime) / 1e9 / 1000 + "milliseconds");
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5
        } else {
            System.out.println("Pieleen meni");
        }
        System.out.println(" ");
    }

    public boolean recursiveSolve(int y, int x) {
        if (y == height - 2 && x == width - 2) {
            this.maze[y][x] = 2;
            return true;
        }
        if (maze[y][x] == 1 || visited[y][x]) {
            return false;
        }
        // If you are on a wall or already were here
        visited[y][x] = true;

        if (y != 0) {
            if (recursiveSolve(y - 1, x)) {
                this.maze[y][x] = 2;
                return true;
            }
        }
        if (y != height - 1) {
            if (recursiveSolve(y + 1, x)) {
                this.maze[y][x] = 2;
                return true;
            }
        }
        if (x != 0) {
            if (recursiveSolve(y, x - 1)) {
                this.maze[y][x] = 2;
                return true;
            }
        }
        if (x != width - 1) {
            if (recursiveSolve(y, x + 1)) {
                this.maze[y][x] = 2;
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
    
//    public boolean recursiveSolve(int y, int x) {
//        if (y == height - 2 && x == width - 2) {
//            this.maze[y][x] = 2;
//            return true;
//        }
//        if (maze[y][x] == 1 || visited[y][x]) {
//            return false;
//        }
//        // If you are on a wall or already were here
//        visited[y][x] = true;
//
//        if (y != 0) {
//            if (recursiveSolve(y - 1, x)) {
//                this.maze[y][x] = 2;
//                return true;
//            }
//        }
//        if (y != height - 1) {
//            if (recursiveSolve(y + 1, x)) {
//                this.maze[y][x] = 2;
//                return true;
//            }
//        }
//        if (x != 0) {
//            if (recursiveSolve(y, x - 1)) {
//                this.maze[y][x] = 2;
//                return true;
//            }
//        }
//        if (x != width - 1) {
//            if (recursiveSolve(y, x + 1)) {
//                this.maze[y][x] = 2;
//                return true;
//            }
//        }
//        return false;
//    }
=======
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5

    public int getHeight() {
        return this.height;
    }
}
