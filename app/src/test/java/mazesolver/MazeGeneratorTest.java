/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author popalmu
 */
public class MazeGeneratorTest {

    MazeGenerator generator = new MazeGenerator();
    Maze maze = generator.generateMaze(10, 12);

    @Test
    public void mazeIsCreated() {
        assertNotNull("Verify that maze is NOT null", this.maze);
    }

    @Test
    public void mazeHasRightDimensions() {

        assertEquals(10, this.maze.getMazeHeight());
        assertEquals(12, this.maze.getMazeLength());
    }

    @Test
    public void everyCellHasAtleastOneOpenWall() {
        ArrayList<Cell> cells = new ArrayList<>();
        int x = 0;
        while (x < 10) {
            int height = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            int width = ThreadLocalRandom.current().nextInt(0, 11 + 1);
            cells.add(this.maze.getMazeArray()[height][width]);
            x++;
        }
        for (int i = 0; i < cells.size(); i++) {
            boolean open = false;
            Cell cell = cells.get(i);
            if (cell.isNorth() | cell.isEast() | cell.isSouth() | cell.isWest()) {
                open = true;
            }
            assertEquals(open, true);
        }
    }

}
