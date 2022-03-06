/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import static mazesolver.Utils.*;

/**
 * Provides methods to recursive solve a given maze
 *
 * @author popalmu
 */
public class RecursiveSolve {

    private boolean[][] visited;

    /**
     * A method that solves a maze
     *
     * @author Petri Palmu
     * @param referenceMaze a maze to be solved
     * @return Maze deep and solved copy of the maze given as parameter
     */
    public Maze solve(Maze referenceMaze) {
        int height = referenceMaze.getMazeHeight();
        int width = referenceMaze.getMazeLength();
        this.visited = new boolean[height][width];
        Maze maze = deepCopyMaze(referenceMaze);
        Cell[][] mazeArr = maze.getMazeArray();

        long startTime = System.nanoTime();
        boolean solved = recursiveSolve(mazeArr, 0, 0);
        long endTime = System.nanoTime();
        maze.setSolveTime(endTime - startTime);
        maze.setSolved(solved);

        return maze;
    }

    private boolean recursiveSolve(Cell[][] mazeArr, int y, int x) {
        Cell cell = mazeArr[y][x];
        if (y == mazeArr.length - 1 && x == mazeArr[0].length - 1) {
            return true;
        }
        if (visited[y][x]) {
            return false;
        }

        visited[y][x] = true;

        if (cell.isNorth()) {
            if (recursiveSolve(mazeArr, y - 1, x)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isSouth()) {
            if (recursiveSolve(mazeArr, y + 1, x)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isEast()) {
            if (recursiveSolve(mazeArr, y, x + 1)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        if (cell.isWest()) {
            if (recursiveSolve(mazeArr, y, x - 1)) {
                cell.setOnThePath(true);
                return true;
            }
        }

        return false;
    }

}
