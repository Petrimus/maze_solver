/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.util.Scanner;

/**
 *
 * @author popalmu
 */
public class UserInterface {

    private final Scanner reader;
    private Maze maze;
    private int[][] solvable;
    private final MazeGenerator generator = new MazeGenerator();

    public UserInterface(Scanner reader) {
        this.maze = new Maze(generator.generateMaze(10, 10));
        this.solvable = solvableMaze(this.maze.getMazeArray());
        this.reader = reader;
    }

    public void start() {

        RecursiveSolve recSolve = new RecursiveSolve(this.maze);
        System.out.print("Anna nimesi: ");
        String name = reader.nextLine();
        System.out.println("");

        OUTER:
        while (true) {
            System.out.println("Anna komento: ");
            System.out.println("1 - tulosta nimi");
            System.out.println("2 - Generoi uusi labyrintti");
            System.out.println("3 - piirrä labyrintti");
            System.out.println("4 - ratkaise labyrintti rekursiivisesti");
            System.out.println("5 - lopeta");

            int command = Integer.parseInt(reader.nextLine());

            switch (command) {
                case 1:
                    System.out.println(name);
                    break;

                case 2:
                    this.maze = optionGeneratteMaze();
                    this.solvable = solvableMaze(this.maze.getMazeArray());

                case 3:
                    this.maze.drawMaze();
                    System.out.println("");
                    break;

                case 4:
                    recSolve.solve();
                    break;

                case 5:
                    break OUTER;

                default:
                    System.out.println("Syötä oikea komento");
                    break;
            }
        }
    }

    private Maze optionGeneratteMaze() {
        int height = 0;
        int width = 0;
        while (true) {
            System.out.print("Anna leveys (10-100): ");
            if (reader.hasNextInt()) {
                width = reader.nextInt();
                break;
            } else {
                System.out.println("Pitää olla numer välillä 10-100");
            }
        }
        System.out.println("");
        while (true) {
            System.out.print("Anna korkeus (10-100): ");
            if (reader.hasNextInt()) {
                height = reader.nextInt();
                break;
            } else {
                System.out.println("Pitää olla numer välillä 10-100");
            }
        }
        return new Maze(this.generator.generateMaze(height, width));
    }

    private int[][] solvableMaze(int[][] original) {
        int height = original.length;
        int width = original[0].length;
        int[][] solveMaze = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ((original[y][x] & 1) == 0 ) { // && (original[y][x] & 8) == 0
                    solveMaze[y][x] = 1;
                }
            }
        }
        printMazeArray(solveMaze);
        return solveMaze;
    }
    
     private void printMazeArray(int[][] arr) {
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%5d ", arr1[j]);
            }
            System.out.println();
        }
    }
}
