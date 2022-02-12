/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

<<<<<<< HEAD

import static org.junit.Assert.assertEquals;
import org.junit.Test;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5

/**
 *
 * @author popalmu
 */
public class RecursiveSolveTest {
<<<<<<< HEAD

    Maze maze = new Maze();

    @Test
    public void initialHeightIsZero() {
        RecursiveSolve recSolve = new RecursiveSolve();
=======
    Maze maze = new Maze();
    @Test
     public void initialHeightIsZero() {
        RecursiveSolve recSolve = new RecursiveSolve(this.maze);
>>>>>>> 6898e1d579c1adf6c89cf6e6e56aa0bcde9bffd5
        assertEquals(10, recSolve.getHeight());
    }
}
