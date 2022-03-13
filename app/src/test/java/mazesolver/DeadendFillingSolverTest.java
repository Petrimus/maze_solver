/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author popalmu
 */
public class DeadendFillingSolverTest {

    private static Maze maze;
    private static DeadendFillingSolver solver;

    @BeforeClass
    public static void createMaze() {
        Cell[][] mazeArr = new Cell[3][3];
        mazeArr[0][0] = new Cell(0, 0, false, true, false, false);
        mazeArr[0][1] = new Cell(0, 1, false, false, false, true);
        mazeArr[0][2] = new Cell(0, 2, false, true, true, false);
        mazeArr[1][0] = new Cell(1, 0, true, true, false, true);
        mazeArr[1][1] = new Cell(1, 1, false, false, true, true);
        mazeArr[1][2] = new Cell(1, 2, true, false, true, false);
        mazeArr[2][0] = new Cell(2, 0, true, false, false, true);
        mazeArr[2][1] = new Cell(2, 1, false, false, true, true);
        mazeArr[2][2] = new Cell(2, 2, false, false, true, false);

        maze = new Maze(mazeArr);
        solver = new DeadendFillingSolver();
    }
    
    @Test
    public void solveMethodReturnsObject() {
        Maze testMaze = solver.solve(maze);
        assertNotNull("Verify that thing is NOT null", testMaze);
    }
}
