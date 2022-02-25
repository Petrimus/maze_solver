/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author popalmu
 */
public class DeadendFillingSolver {

    private Cell[][] mazeArr;
    private int height;
    private int width;

    public void solve(Maze maze) {
        this.mazeArr = maze.getMazeArray();
        this.height = mazeArr.length;
        this.width = mazeArr[0].length;

        Deque<Cell> deadends = new ArrayDeque<>();

        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Cell cell = mazeArr[y][x];
                // System.out.println("first cell: " + cell);
                if ((cell.getPossibleDirections().size() == 1) && (y != height - 1 || x != width - 1) && (y != 0 || x != 0)) {
                    deadends.add(cell);
                    System.out.println("cell: " + cell);
                }
            }
        }
        // System.out.println("deadends length: " + deadends.size());
        Iterator<Cell> itr = deadends.iterator();
        while (itr.hasNext()) {
            Cell cell = itr.next();
            Direction dir = cell.getPossibleDirections().get(0);
            clearPath(cell.getY(), cell.getX(), dir);
        }

    }

    private void clearPath(int py, int px, Direction dir) {
        System.out.println(dir);
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

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
}
