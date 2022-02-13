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

    public int[][] generateMaze(int height, int width) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
        System.out.println("maze length boo" + this.maze.length);
        generate(0, 0);
        printMazeArray();
        createMazeToSolve(this.maze);
        return this.maze;
    }

    private void generate(int cy, int cx) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (isValid(nx, width) && isValid(ny, height)
                    && (this.maze[ny][nx] == 0)) {
                this.maze[cy][cx] |= dir.bit;
                this.maze[ny][nx] |= dir.opposite.bit;
                generate(ny, nx);
            }
        }
    }

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum Direction {
        NORTH(1, -1, 0),
        SOUTH(2, 1, 0),
        EAST(4, 0, 1),
        WEST(8, 0, -1);

        private final int bit;
        private final int dy;
        private final int dx;
        private Direction opposite;

        // use the static initializer to resolve forward references
        static {
            NORTH.opposite = SOUTH;
            SOUTH.opposite = NORTH;
            EAST.opposite = WEST;
            WEST.opposite = EAST;
        }

        private Direction(int bit, int dy, int dx) {
            this.bit = bit;
            this.dy = dy;
            this.dx = dx;
        }
    };

    private void printMazeArray() {
        for (int[] maze1 : this.maze) {
            for (int j = 0; j < this.maze[0].length; j++) {
                System.out.printf("%5d ", maze1[j]);
            }
            System.out.println();
        }
    }

    private void createMazeToSolve(int[][] maze) {
        Cell[][] newMaze = new Cell[maze.length][maze[0].length];
        for (int i = 0; i < newMaze.length; i++) {
            for (int j = 0; j < newMaze[i].length; j++) {
                newMaze[i][j] = new Cell();
            }
        }
        System.out.println("new maze length " + newMaze[0].length);
        System.out.println("new maze 0 0 " + newMaze[0][0]);
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[0].length; x++) {

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

        for (int y = 0; y < newMaze.length; y++) {
            for (int x = 0; x < newMaze[0].length; x++) {
                System.out.println("" + newMaze[y][x]);
            }
        }

    }

}
