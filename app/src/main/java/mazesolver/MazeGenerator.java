/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.Arrays;
import java.util.Collections;

/**
 * A maze generator class
 *
 * @author popalmu
 */
public class MazeGenerator {

    private int width;
    private int height;
    private int[][] maze;

    /**
     * Creates new maze
     *
     * @param height height of the new maze
     * @param width width of the new maze
     * @return Newly created maze object
     */
    public Maze generateMaze(int height, int width) {
        if (height < 10 | width < 10 | height > 100 | width > 100) {
            return null;
        }
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
        maze[height - 1][width - 1] = 8;
        generate(0, 0);
        maze[height - 1][width - 2] |= 4;
        // printMazeArray();
        return new Maze(createMazeToSolve(this.maze));
    }

    /**
     * Internal method that recursively go through maze array and create walls
     *
     * @param cy y position
     * @param cx x position
     */
    private void generate(int cy, int cx) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.getDx();
            int ny = cy + dir.getDy();
            if (isValid(nx, width) && isValid(ny, this.height)
                    && (this.maze[ny][nx] == 0)) {
                this.maze[ny][nx] |= dir.getOpposite().getBit();
                this.maze[cy][cx] |= dir.getBit();

                generate(ny, nx);
            }
        }
    }

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    /**
     * Internal method transform a int array maze into Cell array
     *
     * @param maze 2-d int array
     * @return 2-d Cell array
     */
    private Cell[][] createMazeToSolve(int[][] maze) {

        Cell[][] newMaze = new Cell[maze.length][maze[0].length];

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                newMaze[y][x] = new Cell(y, x);

                if ((maze[y][x] & 1) == 0) {
                    newMaze[y][x].setNorth(false);
                }
                if ((maze[y][x] & 2) == 0) {
                    newMaze[y][x].setSouth(false);
                }
                if ((maze[y][x] & 4) == 0) {
                    newMaze[y][x].setEast(false);
                }

                if ((maze[y][x] & 8) == 0) {
                    newMaze[y][x].setWest(false);

                }
            }
        }

        return newMaze;
    }

}
