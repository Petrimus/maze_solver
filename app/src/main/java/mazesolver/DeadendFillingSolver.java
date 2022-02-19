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

        for (int y = 0; y < mazeArr.length; y++) {
            for (int x = 0; x < mazeArr[y].length; x++) {
                Cell cell = mazeArr[y][x];
                if (cell.getPossibleDirections().size() == 1 && (y != height - 1 && x != width - 1) && (y != 0 && x != 0)) {
                    deadends.add(cell);
                }
            }
        }
        Iterator<Cell> itr = deadends.iterator();
        while (itr.hasNext()) {
            System.out.println("ollaanko täällä???");
            Cell cell = itr.next();
            Direction dir = cell.getPossibleDirections().get(0);
            clearPath(cell.getY() + dir.getDy(), cell.getX() + dir.getDx(), dir);
        }

    }

    private void clearPath(int cy, int cx, Direction dir) {
        System.out.println(dir);
        if (isValid(cy, height) && isValid(cx, width)) {
           

            Cell cell = this.mazeArr[cy][cx];
            
            if (dir == Direction.NORTH) {
                cell.setSouth(false);
            }
            if (dir == Direction.SOUTH) {
                cell.setNorth(false);
            }
            if (dir == Direction.WEST) {
                cell.setEast(false);
            }
            if (dir == Direction.EAST) {
                cell.setWest(false);
            }

            List<Direction> dirs = cell.getPossibleDirections();
            if (dirs.size() > 1) {
                return;
            }
            
             if (cy == height - 1 && cx == width - 1) {
                return;
            }

            for (Direction newDir : dirs) {
                if (newDir != dir) {
                    System.out.println("newdir " + newDir + " dir " + dir);
                    clearPath(cell.getY() + newDir.getDy(), cell.getX() + newDir.getDx(), newDir);
                }

            }

        }
    }

    private boolean isValid(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
}
