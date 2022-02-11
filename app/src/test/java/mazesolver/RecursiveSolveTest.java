/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author popalmu
 */
public class RecursiveSolveTest {

    Maze maze = new Maze();

    @Test
    public void initialHeightIsZero() {
        RecursiveSolve recSolve = new RecursiveSolve();
        assertEquals(10, recSolve.getHeight());
    }
}
