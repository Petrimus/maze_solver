/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Representation of the maze.
 * <p>
 * This class is the maze</p>
 *
 * @author Petri Palmu
 */
package mazesolver;

/**
 *
 * @author popalmu
 */
public class Maze {

    private int[][] maze;

//            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
//            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
//            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
//            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
//            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
//            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
//            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//            };
    public Maze(int[][] maze) {
        this.maze = maze;
    }

    public void drawMaze() {
//        for (int[] maze1 : maze) {
//            System.out.println("");
//            for (int j = 0; j < maze1.length; j++) {
//                if (maze1[j] == 1) {
//                    System.out.print("#");
//                } else if (maze1[j] == 2) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//        }
        int height = maze.length;
        int width = maze[0].length;
        // System.out.println("+   ");
        for (int y = 0; y < height; y++) {
            // draw the north edge
            for (int x = 0; x < width; x++) { 
                // System.out.println("maze " + maze[y][x] + "maze bit " + (maze[y][x] & 1));
                System.out.print((maze[y][x] & 1) == 0 ? "+---" : "+   ");
                // if (maze[i][j] == 1)
            }
            System.out.println("+");
            // draw the west edge
            for (int x = 0; x < width; x++) {
                //System.out.println("maze " + maze[y][x] + "maze bit " + (maze[y][x] & 8));
                System.out.print((maze[y][x] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int x = 0; x < width; x++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public int[][] getMazeArray() {
        return this.maze;
    }

    public int getMazeLength() {
        return this.maze[0].length;
    }

    public int getMazeHeight() {
        return this.maze.length;
    }
}
