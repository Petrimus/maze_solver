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
public class MazeGeneratorTest {
    MazeGenerator generator = new MazeGenerator();
    
    @Test
    public void mazeHasRightDimensions() {
      int[][] maze = generator.generateMaze(10, 10);
       // System.out.println("maze");
      display(maze);
      assertEquals(10, maze.length);
      assertEquals(10, maze[0].length);
    }
   
    public void display(int[][] maze) {
        int y = maze.length;
        int x = maze[0].length;
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
			}
			System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < x; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}
    
}
