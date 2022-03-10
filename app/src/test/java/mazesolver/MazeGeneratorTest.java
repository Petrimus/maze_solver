/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

/**
 *
 * @author popalmu
 */
public class MazeGeneratorTest {

    private final MazeGenerator generator = new MazeGenerator();
    private final Maze maze = generator.generateMaze(10, 12);

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

    @Test
    public void thatFirstAndLastCellHasOneOpenDirection() {
        Cell firstCell = maze.getMazeArray()[0][0];
        Cell lastCell = maze.getMazeArray()[9][11];
        assertEquals(firstCell.getPossibleDirections().size(), 1);
        assertEquals(lastCell.getPossibleDirections().size(), 1);

    }

    @Test
    public void mazeHasToBeWithinLimits() {
        Maze one = generator.generateMaze(5, 12);
        Maze two = generator.generateMaze(10, 125);

        assertNull("Verify that object is null", one);
        assertNull("Verify that object is null", two);
    }
}
