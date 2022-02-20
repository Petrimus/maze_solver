/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author popalmu
 */
public class MazeGenerator {

    private int width;
    private int height;
    private int[][] maze;

    public Maze generateMaze(int height, int width) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
        // System.out.println("maze length boo" + this.maze.length);
        generate(0, 0);
        // printMazeArray();
        return new Maze(createMazeToSolve(this.maze));
    }

    private void generate(int cy, int cx) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.getDx();
            int ny = cy + dir.getDy();
            if (isValid(nx, width) && isValid(ny, height)
                    && (this.maze[ny][nx] == 0)) {
                this.maze[ny][nx] |= dir.getOpposite().getBit();

                if (cy == height - 1 && cx == width - 1) {
                    return;
                }
                this.maze[cy][cx] |= dir.getBit();

                generate(ny, nx);
            }
        }
    }

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private Cell[][] createMazeToSolve(int[][] maze) {
        int height = maze.length;
        int width = maze[0].length;
        Cell[][] newMaze = new Cell[maze.length][maze[0].length];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newMaze[y][x] = new Cell(y, x);
                if (y != 0) {
                    if ((maze[y][x] & 1) != 0) {
                        newMaze[y][x].setNorth(true);
                        newMaze[y - 1][x].setSouth(true);
                    }

                }
                if (x != 0) {
                    if ((maze[y][x] & 8) != 0) {
                        newMaze[y][x].setWest(true);
                        newMaze[y][x - 1].setEast(true);
                    }
                }
            }
        }

        return newMaze;
    }

}
