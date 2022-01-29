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

import java.util.ArrayList;

/**
 *
 * @author popalmu
 */
public class Maze {

    int[][] maze
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
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
    
    public ArrayList<Coordinate> findDeadends() {
        
        return null;
    }
    
}

