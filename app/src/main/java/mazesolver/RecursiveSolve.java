/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import static mazesolver.Utils.copyMazeArr;

/**
 * Provides methods to recursive solve a given maze
 * @author popalmu
 */
public class RecursiveSolve {

    private int height = 0;
    private int width;
    private Cell[][] mazeArr;
    private Maze maze;
    private boolean[][] visited;
    private final int startX = 0;
    private final int startY = 0;

    /**
     * A method that solves a maze
     * 
     * @author Petri Palmu
     * @param referenceMaze a maze to be solved
     * @return Maze deep and solved copy of the maze given as parameter
     */
    public Maze solve(Maze referenceMaze) {
        this.height = referenceMaze.getMazeHeight();
        this.width = referenceMaze.getMazeLength();
        this.visited = new boolean[height][width];
        this.maze = new Maze(copyMazeArr(referenceMaze));
        this.mazeArr = this.maze.getMazeArray();
        
        long startTime = System.nanoTime();
        boolean solved = recursiveSolve(this.startY, this.startX);
        long endTime = System.nanoTime();
        this.maze.setSolveTime(endTime - startTime);
        this.maze.setSolved(solved);
        return this.maze;
    }

    
    private boolean recursiveSolve(int y, int x) {
        Cell cell = this.mazeArr[y][x];
        if (y == height - 1 && x == width - 1) {
            return true;
        }
        if (visited[y][x]) {
            return false;
        }

        visited[y][x] = true;

        if (cell.isNorth()) {
            if (recursiveSolve(y - 1, x)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isSouth()) {
            if (recursiveSolve(y + 1, x)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isEast()) {
            if (recursiveSolve(y, x + 1)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isWest()) {
            if (recursiveSolve(y, x - 1)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        return false;
    }

    public int getHeight() {
        return this.height;
    }
}
