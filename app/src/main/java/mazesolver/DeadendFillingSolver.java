/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import static mazesolver.Utils.deepCopyMaze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * A class that solves a given maze with dead end filling-algorithm
 *
 * @author popalmu
 */
public class DeadendFillingSolver {

    private Maze maze;
    private Cell[][] mazeArr;
    private int height;
    private int width;

    /**
     * Will block all the dead ends and return a new Maze with the correct path
     *
     * @param referenceMaze a maze that is to be resolved
     * @return A new maze where all the dead ends are blocked
     */
    public Maze solve(Maze referenceMaze) {
        this.maze = deepCopyMaze(referenceMaze);
        this.mazeArr = this.maze.getMazeArray();
        this.height = mazeArr.length;
        this.width = mazeArr[0].length;
        long startTime = System.nanoTime();
        Deque<Cell> deadends = new ArrayDeque<>();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Cell cell = mazeArr[y][x];
                if ((cell.getPossibleDirections().size() == 1) && (y != height - 1
                        || x != width - 1) && (y != 0 || x != 0)) {
                    deadends.add(cell);
                }
            }
        }
        Iterator<Cell> itr = deadends.iterator();
        while (itr.hasNext()) {
            Cell cell = itr.next();
            Direction dir = cell.getPossibleDirections().get(0);
            clearPath(cell.getY(), cell.getX(), dir);
        }
        long endTime = System.nanoTime();        
        this.maze.setSolveTime(endTime - startTime);
        return this.maze;
    }

    /**
     * A recursive method, which goes through the maze from a dead end and stop
     * in conjunction
     *
     * @param py current y position
     * @param px current x position
     * @param dir Direction to move
     */
    private void clearPath(int py, int px, Direction dir) {
        int cy = py + dir.getDy();
        int cx = px + dir.getDx();

        if (isValid(cy, height) && isValid(cx, width)) {
            Cell prevCell = this.mazeArr[py][px];
            Cell currCell = this.mazeArr[cy][cx];

            if (dir == Direction.NORTH) {
                prevCell.setNorth(false);
                currCell.setSouth(false);
            }
            if (dir == Direction.SOUTH) {
                prevCell.setSouth(false);
                currCell.setNorth(false);
            }
            if (dir == Direction.WEST) {
                prevCell.setWest(false);
                currCell.setEast(false);
            }
            if (dir == Direction.EAST) {
                prevCell.setEast(false);
                currCell.setWest(false);
            }

            List<Direction> dirs = currCell.getPossibleDirections();

            if (dirs.size() > 1) {
                return;
            }

            for (Direction newDir : dirs) {
                clearPath(currCell.getY(), currCell.getX(), newDir);

            }

        }
    }

    /**
     * A valid check if move to this position in the maze is possible
     *
     * @param v
     * @param upper
     * @return
     */
    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
}
