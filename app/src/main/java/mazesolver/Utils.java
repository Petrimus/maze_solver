/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.Arrays;

/**
 *
 * @author popalmu
 */
public class Utils {

    public static Cell[][] copyMaze(Maze maze) {
        Cell[][] refMaze = maze.getMazeArray();
        Cell[][] arr = new Cell[refMaze.length][];
        for (int i = 0; i < refMaze.length; i++) {
            arr[i] = Arrays.copyOf(refMaze[i], refMaze[i].length);
        }
        return arr;
    }
}
