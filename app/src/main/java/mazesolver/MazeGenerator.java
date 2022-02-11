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
       return this.maze;
    }
    
    private void generate(int cy, int cx) {
        Direction[] dirs = Direction.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (Direction dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (isValid(nx, width) && isValid(ny, height)
                    && (maze[ny][nx] == 0)) {
                maze[cy][cx] |= dir.bit;
                maze[ny][nx] |= dir.opposite.bit;
                generate(ny, nx);
            }
        }
    }  

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum Direction {
        NORTH (1, -1, 0),
        SOUTH (2, 1, 0),
        EAST (4, 0, 1),
        WEST (8, 0, -1);
        
        private final int bit;
        private final int dx;
        private final int dy;
        private Direction opposite;

        // use the static initializer to resolve forward references
        static {
            NORTH.opposite = SOUTH;
            SOUTH.opposite = NORTH;
            EAST.opposite = WEST;
            WEST.opposite = EAST;
        }

        private Direction(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    };

}
