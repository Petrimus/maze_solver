/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author popalmu
 */
public class RecursiveSolve {

    private int height = 0;
    private int width;
    private Cell[][] maze;
    private Maze referenceMaze;
    private boolean[][] visited;
    // private boolean[][] correctPath;
    private final int startX = 0;
    private final int startY = 0;    

    /**
     * Class provides recursive way to a solve maze.
     * <p>
     * Recursive maze solver class</p>
     *
     * @author Petri Palmu
     * @param referenceMaze
     */
//    public RecursiveSolve(Maze referenceMaze) {
//        this.height = referenceMaze.getMazeHeight();
//        this.width = referenceMaze.getMazeLength();
//        this.visited = new boolean[height][width];
//        this.maze = referenceMaze.getMazeArray();
//        this.referenceMaze = referenceMaze;
//        // this.maze = Utils.copyMaze(referenceMaze);
//
//    }

    public void solve(Maze referenceMaze) {
        this.height = referenceMaze.getMazeHeight();
        this.width = referenceMaze.getMazeLength();
        this.visited = new boolean[height][width];
        this.maze = referenceMaze.getMazeArray();
        this.referenceMaze = referenceMaze;
        long startTime = System.nanoTime();
        
        boolean solved = recursiveSolve(this.startY, this.startX);
        long endTime = System.nanoTime();
        if (solved) {
            System.out.println("");
            System.out.println("solved");
           this.referenceMaze.drawMaze();
            System.out.println("");

            System.out.println("Time it took to solve was " + (endTime - startTime) / 1e9 / 1000 + "milliseconds");

        } else {
            System.out.println("Pieleen meni");
        }
        System.out.println(" ");
    }

    public boolean recursiveSolve(int y, int x) {
        Cell cell = this.maze[y][x];
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
