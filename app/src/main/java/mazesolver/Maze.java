/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Representation of the maze.
 * <p>This class is the maze</p>
 * @author Petri Palmu
 */
package mazesolver;


/**
 *
 * @author popalmu
 */
public class Maze {

    private final int[][] maze
            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

    public void drawMaze() {
        for (int[] maze1 : maze) {
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

