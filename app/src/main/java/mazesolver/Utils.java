/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author popalmu
 */
public class Utils {

    /**
     * creates a deep of the maze given as parameter
     *
     * @param maze
     * @return new maze
     */
    public static Maze deepCopyMaze(Maze maze) {
        Cell[][] refMaze = maze.getMazeArray();
        int height = refMaze.length;
        int width = refMaze[0].length;
        Cell[][] arr = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                arr[y][x] = (Cell) refMaze[y][x].clone();
            }
        }

        return new Maze(arr);
    }
}
